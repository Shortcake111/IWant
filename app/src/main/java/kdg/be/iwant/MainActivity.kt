package kdg.be.iwant

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import kdg.be.iwant.model.Wishlist
import java.util.*

fun getWishlists(): ArrayList<Wishlist> {
    val wishlists: ArrayList<Wishlist> = ArrayList()
    val calCreation = Calendar.getInstance()
    calCreation.set(2019, 1, 1)
    val calEdited = Calendar.getInstance()
    calEdited.set(2019, 1, 5)
    wishlists.add(
        Wishlist(
            1,
            "PC-accesories",
            calCreation.time,
            calEdited.time,
            2,
            "pc"
        )
    )
    calCreation.set(2018, 7, 4)
    calEdited.set(2019, 1, 5)
    wishlists.add(
        Wishlist(
            2,
            "Appearance",
            calCreation.time,
            calEdited.time,
            3,
            "look"
        )
    )
    calCreation.set(2018, 3, 19)
    calEdited.set(2018, 4, 5)
    wishlists.add(
        Wishlist(
            3,
            "Games",
            calCreation.time,
            calEdited.time,
            1,
            "controller"
        )
    )
    calCreation.set(2018, 9, 10)
    calEdited.set(2019, 1, 5)
    wishlists.add(
        Wishlist(
            4,
            "Groceries",
            calCreation.time,
            calEdited.time,
            4,
            "groceries"
        )
    )
    calCreation.set(2018, 10, 10)
    calEdited.set(2018, 12, 3)
    wishlists.add(
        Wishlist(
            5,
            "Boyfriend",
            calCreation.time,
            calEdited.time,
            5,
            "heart"
        )
    )
    calCreation.set(2018, 2, 20)
    calEdited.set(2018, 9, 15)
    wishlists.add(
        Wishlist(
            6,
            "Cinema",
            calCreation.time,
            calEdited.time,
            6,
            "movie"
        )
    )
    calCreation.set(2018,1,28)
    calEdited.set(2018,11,30)
    wishlists.add(
        Wishlist(
            7,
            "Reparaties",
            calCreation.time,
            calEdited.time,
            7,
            "wrench"
        )
    )
    calCreation.set(2018,4,21)
    calEdited.set(2019,6,12)
    wishlists.add(
        Wishlist(
            8,
            "Onderhoud",
            calCreation.time,
            calEdited.time,
            8,
            "gear"
        )
    )
    calCreation.set(2018,2,1)
    calEdited.set(2019,4,13)
    wishlists.add(
        Wishlist(
            9,
            "Abonnementen",
            calCreation.time,
            calEdited.time,
            9,
            "euro"
        )
    )
    calCreation.set(2018,1,2)
    calEdited.set(2019,1,5)
    wishlists.add(
        Wishlist(
            10,
            "TestList 1",
            calCreation.time,
            calEdited.time,
            10,
            "test"
        )
    )
    calCreation.set(2018,4,10)
    calEdited.set(2018,4,10)
    wishlists.add(
        Wishlist(
            11,
            "TestList 2",
            calCreation.time,
            calEdited.time,
            14,
            "test"
        )
    )
    calCreation.set(2018,5,25)
    calEdited.set(2018,7,21)
    wishlists.add(
        Wishlist(
            12,
            "TestList 3",
            calCreation.time,
            calEdited.time,
            12,
            "test"
        )
    )
    calCreation.set(2018,7,9)
    calEdited.set(2018,7,27)
    wishlists.add(
        Wishlist(
            13,
            "TestList 4",
            calCreation.time,
            calEdited.time,
            11,
            "test"
        )
    )
    calCreation.set(2018,10,27)
    calEdited.set(2019,1,18)
    wishlists.add(
        Wishlist(
            14,
            "TestList 5",
            calCreation.time,
            calEdited.time,
            15,
            "test"
        )
    )
    calCreation.set(2018,12,28)
    calEdited.set(2018,12,31)
    wishlists.add(
        Wishlist(
            15,
            "TestList 6",
            calCreation.time,
            calEdited.time,
            13,
            "test"
        )
    )
    return wishlists
}

class MainActivity : AppCompatActivity() {
    private lateinit var icon:ImageView
    private lateinit var name:TextView
    private lateinit var created:TextView
    private lateinit var edited:TextView
    private lateinit var id:TextView
    private lateinit var previous:ImageButton
    private lateinit var next:ImageButton
    private var currentRecord:Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initialiseViews()
        addEventHandlers()
        currentRecord = 0
        fillFields(currentRecord)
    }

    private fun initialiseViews(){
        icon = findViewById(R.id.iconImageView)
        name = findViewById(R.id.nameTextView)
        created = findViewById(R.id.createdTextView)
        edited = findViewById(R.id.editedTextView)
        id = findViewById(R.id.idTextView)
        previous = findViewById(R.id.previousImageButton)
        next = findViewById(R.id.nextImageButton)
        currentRecord = 0
    }

    private fun addEventHandlers(){
        previous.setOnClickListener {
            if (currentRecord > 0) {
                fillFields(--currentRecord)
            } else {
                currentRecord = getWishlists().size-1
                fillFields(currentRecord)
            }
        }

        next.setOnClickListener {
            if (currentRecord < getWishlists().size-1) {
                fillFields(++currentRecord)
            } else {
                currentRecord = 0
                fillFields(currentRecord)
            }
        }

        icon.setOnClickListener{
            var imageIntent:Intent = Intent(this, ImageActivity::class.java)
            imageIntent.putExtra("icon", resources.getIdentifier("@drawable/"+getWishlists()[currentRecord].icon, null, packageName))
            startActivity(imageIntent)
        }
    }

    private fun fillFields(nr:Int){
        if (!getWishlists().isEmpty()) {
            icon.setImageDrawable(resources.getDrawable(resources.getIdentifier("@drawable/"+getWishlists()[nr].icon, null, packageName)))
            name.text = getWishlists()[nr].name

            var date:Date = getWishlists()[nr].created
            created.text = "Created: " + date.month + "-" + date.day
            if (Calendar.YEAR != date.year) {
                created.append("-" + date.year)
            }

            date = getWishlists()[nr].last_edited
            edited.text = "Edited: " + date.month + "-" + date.day
            if (Calendar.YEAR != date.year) {
                edited.append("-" + date.year)
            }

            id.text = (currentRecord+1).toString()
        } else{
            name.text = "No records found"
        }
    }
}
