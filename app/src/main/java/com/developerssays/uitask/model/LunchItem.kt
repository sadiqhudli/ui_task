package com.developerssays.uitask.model

import android.os.Parcelable
import java.io.Serializable


sealed class MenuItem {
    abstract val id: Long
    abstract val name: String
    abstract val description: String
    abstract val price: Double
    abstract val image: Int
}


data class LunchItem(
    override val id: Long,
    override val name: String,
    override val description: String,
    override val price: Double,
    override val image: Int
): MenuItem()


data class SaladItem(
    override val id: Long,
    override val name: String,
    override val description: String,
    override val price: Double,
     override val image: Int
):MenuItem()

data class BurgerItem(
   override val id:Long,
  override  val name:String,
   override val description:String,
   override val price:Double,
   override val image: Int
):MenuItem()

data class CoffeeItem(
    override val id:Long,
    override  val name:String,
    override val description:String,
    override val price:Double,
    override val image: Int
):MenuItem()

data class DessertItem(
    override val id:Long,
    override  val name:String,
    override val description:String,
    override val price:Double,
    override val image: Int
):MenuItem()



data class CartItem(
    val item:MenuItem,
    var quantity: Int
)  {
    val totalPrice: Double
        get() = item.price * quantity

    fun increaseQuantity() {
        quantity++
    }

    fun decreaseQuantity() {
        if (quantity > 1) quantity-- // To prevent going below 1
    }
}










