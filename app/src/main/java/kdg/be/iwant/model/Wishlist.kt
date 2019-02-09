package kdg.be.iwant.model

import java.time.LocalDate
import java.util.*

data class Wishlist (
    val id:Int,
    val name:String,
    val created:Date,
    val last_edited:Date,
    val position:Int,
    val icon:String)