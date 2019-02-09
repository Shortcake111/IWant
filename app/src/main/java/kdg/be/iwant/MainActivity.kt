package kdg.be.iwant

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
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
            "pc-accesories",
            calCreation.time,
            calEdited.time,
            2,
            "pc.png"
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
            "look.png"
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
            "controller.png"
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
            "groceries.png"
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
            "heart.png"
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
            "movie.png"
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
            "wrench.png"
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
            "gear.png"
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
            "euro.png"
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
            "test.png"
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
            "test.png"
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
            "test.png"
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
            "test.png"
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
            "test.png"
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
            "test.png"
        )
    )
    return wishlists
}

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}
