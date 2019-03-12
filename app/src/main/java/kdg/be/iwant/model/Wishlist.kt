package kdg.be.iwant.model

import java.util.*

data class Wishlist (
    val id:Int,
    val name:String,
    val created:Date,
    val last_edited:Date,
    val icon:String,
    val color:Int
    )