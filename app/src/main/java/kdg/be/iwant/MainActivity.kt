package kdg.be.iwant

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import kdg.be.iwant.adapters.WishlistAdapter
import java.util.*

class MainActivity : AppCompatActivity(){
    /*private lateinit var icon:ImageView
    private lateinit var name:TextView
    private lateinit var created:TextView
    private lateinit var edited:TextView
    private lateinit var id:TextView
    private lateinit var previous:ImageButton
    private lateinit var next:ImageButton
    private var currentRecord:Int = 0

    @Override
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_default, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        return when (item!!.itemId){
            R.id.settingsMenuItem -> {
                val settingsIntent = Intent(this, SettingsActivity::class.java)
                startActivity(settingsIntent)
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

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
            val imageIntent = Intent(this, ImageActivity::class.java)
            imageIntent.putExtra("icon", resources.getIdentifier("@drawable/"+getWishlists()[currentRecord].icon, null, packageName))
            startActivity(imageIntent)
        }
    }

    private fun fillFields(nr:Int){
        if (!getWishlists().isEmpty()) {
            icon.setImageDrawable(resources.getDrawable(resources.getIdentifier("@drawable/"+getWishlists()[nr].icon, null, packageName)))
            name.text = getWishlists()[nr].name

            var date:Date = getWishlists()[nr].created
            created.text = "Created: " + date.get(Calendar.MONTH) + "-" + date.day
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
    }*/
}
