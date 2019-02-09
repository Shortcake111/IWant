package kdg.be.iwant.model

data class Product(
    val id:Int,
    val name:String,
    val pricePerPiece:Double,
    val quantity:Int,
    val ticked:Boolean,
    val wishlistId:Int)