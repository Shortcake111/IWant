package kdg.be.iwant

import android.graphics.Color
import kdg.be.iwant.model.Product
import kdg.be.iwant.model.Wishlist
import java.util.*

fun getWishlists(): ArrayList<Wishlist> {
    val wishlists: ArrayList<Wishlist> = ArrayList()
    val pdt = SimpleTimeZone(-8 * 60 * 60 * 1000, TimeZone.getAvailableIDs(-8 * 60 * 60 * 1000)[0])
    pdt.setStartRule(Calendar.APRIL, 1, Calendar.SUNDAY, 2 * 60 * 60 * 1000)
    pdt.setEndRule(Calendar.OCTOBER, -1, Calendar.SUNDAY, 2 * 60 * 60 * 1000)

    val calCreation = GregorianCalendar(pdt)
    val calEdited = GregorianCalendar(pdt)

    setTime(calCreation, 2019, 0, 1)
    setTime(calEdited, 2019, 0, 5)
    //val calEdited = Calendar.getInstance()
    //calEdited.set(2019, 1, 5)
    wishlists.add(
        Wishlist(
            1,
            "PC-accesories",
            calCreation.time,
            calEdited.time,
            "pc",
            Color.rgb(200, 253, 195)
        )
    )

    setTime(calCreation, 2018, 6, 4)
    setTime(calEdited, 2019, 0, 5)
    /*calCreation.set(2018, 7, 4)
    calEdited.set(2019, 1, 5)*/
    wishlists.add(
        Wishlist(
            2,
            "Appearance",
            calCreation.time,
            calEdited.time,
            "look",
            Color.rgb(255, 251, 208)
        )
    )
    setTime(calCreation, 2018, 2, 19)
    setTime(calEdited, 2018, 3, 5)
    /*calCreation.set(2018, 3, 19)
    calEdited.set(2018, 4, 5)*/
    wishlists.add(
        Wishlist(
            3,
            "Games",
            calCreation.time,
            calEdited.time,
            "controller",
            Color.rgb(200, 253, 195)
        )
    )
    setTime(calCreation, 2018, 8, 10)
    setTime(calEdited, 2019, 0, 5)
    /*calCreation.set(2018, 9, 10)
    calEdited.set(2019, 1, 5)*/
    wishlists.add(
        Wishlist(
            4,
            "Groceries",
            calCreation.time,
            calEdited.time,
            "groceries",
            Color.rgb(230, 178, 253)
        )
    )
    setTime(calCreation, 2018, 9, 10)
    setTime(calEdited, 2019, 11, 3)
    /*calCreation.set(2018, 10, 10)
    calEdited.set(2018, 12, 3)*/
    wishlists.add(
        Wishlist(
            5,
            "Boyfriend",
            calCreation.time,
            calEdited.time,
            "heart",
            Color.rgb(255, 184, 184)
        )
    )
    setTime(calCreation, 2018, 1, 20)
    setTime(calEdited, 2018, 8, 15)
    /*calCreation.set(2018, 2, 20)
    calEdited.set(2018, 9, 15)*/
    wishlists.add(
        Wishlist(
            6,
            "Cinema",
            calCreation.time,
            calEdited.time,
            "movie",
            Color.rgb(255, 184, 184)
        )
    )
    setTime(calCreation, 2018, 0, 28)
    setTime(calEdited, 2018, 10, 30)
    /*calCreation.set(2018,1,28)
    calEdited.set(2018,11,30)*/
    wishlists.add(
        Wishlist(
            7,
            "Reparaties",
            calCreation.time,
            calEdited.time,
            "wrench",
            Color.rgb(230, 178, 253)
        )
    )
    setTime(calCreation, 2018, 3, 21)
    setTime(calEdited, 2019, 5, 12)
    /*calCreation.set(2018,4,21)
    calEdited.set(2019,6,12)*/
    wishlists.add(
        Wishlist(
            8,
            "Onderhoud",
            calCreation.time,
            calEdited.time,
            "gear",
            Color.rgb(230, 178, 253)
        )
    )
    setTime(calCreation, 2018, 1, 1)
    setTime(calEdited, 2019, 3, 13)
    /*calCreation.set(2018,2,1)
    calEdited.set(2019,4,13)*/
    wishlists.add(
        Wishlist(
            9,
            "Abonnementen",
            calCreation.time,
            calEdited.time,
            "euro",
            Color.rgb(151, 242, 208)
        )
    )
    setTime(calCreation, 2018, 0, 2)
    setTime(calEdited, 2019, 0, 5)
    /*calCreation.set(2018,1,2)
    calEdited.set(2019,1,5)*/
    wishlists.add(
        Wishlist(
            10,
            "TestList 1",
            calCreation.time,
            calEdited.time,
            "test",
            Color.rgb(255, 209, 130)
        )
    )
    setTime(calCreation, 2018, 3, 10)
    setTime(calEdited, 2018, 3, 10)
    /*calCreation.set(2018,4,10)
    calEdited.set(2018,4,10)*/
    wishlists.add(
        Wishlist(
            11,
            "TestList 2",
            calCreation.time,
            calEdited.time,
            "test",
            Color.rgb(255, 209, 130)
        )
    )
    setTime(calCreation, 2018, 4, 25)
    setTime(calEdited, 2018, 6, 21)
    /*calCreation.set(2018,5,25)
    calEdited.set(2018,7,21)*/
    wishlists.add(
        Wishlist(
            12,
            "TestList 3",
            calCreation.time,
            calEdited.time,
            "test",
            Color.rgb(255, 209, 130)
        )
    )
    setTime(calCreation, 2018, 6, 9)
    setTime(calEdited, 2018, 6, 27)
    /*calCreation.set(2018,7,9)
    calEdited.set(2018,7,27)*/
    wishlists.add(
        Wishlist(
            13,
            "TestList 4",
            calCreation.time,
            calEdited.time,
            "test",
            Color.rgb(255, 209, 130)
        )
    )
    setTime(calCreation, 2018, 9, 27)
    setTime(calEdited, 2019, 0, 18)
    /*calCreation.set(2018,10,27)
    calEdited.set(2019,1,18)*/
    wishlists.add(
        Wishlist(
            14,
            "TestList 5",
            calCreation.time,
            calEdited.time,
            "test",
            Color.rgb(255, 209, 130)
        )
    )
    setTime(calCreation, 2018, 11, 28)
    setTime(calEdited, 2018, 11, 31)
    /*calCreation.set(2018,12,28)
    calEdited.set(2018,12,31)*/
    wishlists.add(
        Wishlist(
            15,
            "TestList 6",
            calCreation.time,
            calEdited.time,
            "test",
            Color.rgb(255, 209, 130)
        )
    )
    return wishlists
}

fun getProducts(): ArrayList<Product> {
    val products: ArrayList<Product> = ArrayList()
    products.add(
        Product(
            1,
            "Keyboard",
            110.00,
            1,
            false,
            1
        )
    )
    products.add(
        Product(
            2,
            "Dresses",
            20.00,
            2,
            false,
            2
        )
    )
    products.add(
        Product(
            3,
            "Mascara",
            4.00,
            1,
            true,
            2
        )
    )
    products.add(
        Product(
            4,
            "Overwatch",
            60.00,
            1,
            true,
            3
        )
    )
    products.add(
        Product(
            5,
            "Atelier Sophie: The Alchemist of the Mysterious Book",
            29.99,
            1,
            false,
            3
        )
    )
    products.add(
        Product(
            6,
            "Hand of Fate",
            19.99,
            1,
            true,
            3
        )
    )
    products.add(
        Product(
            7,
            "WC papier",
            2.00,
            2,
            false,
            8
        )
    )
    products.add(
        Product(
            8,
            "Maandverband",
            4.79,
            1,
            false,
            8
        )
    )
    products.add(
        Product(
            9,
            "Crunchyroll (monthly)",
            5.00,
            1,
            true,
            9
        )
    )
    products.add(
        Product(
            10,
            "TestItem1",
            0.05,
            10,
            false,
            10
        )
    )
    return products
}

private fun setTime(cal: Calendar, year: Int, month: Int, day: Int) {
    cal.set(year, month, day)
}