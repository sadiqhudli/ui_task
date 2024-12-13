package com.developerssays.uitask.viewModel

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.createSavedStateHandle
import com.developerssays.uitask.R
import com.developerssays.uitask.model.BurgerItem
import com.developerssays.uitask.model.CartItem
import com.developerssays.uitask.model.CoffeeItem
import com.developerssays.uitask.model.DessertItem
import com.developerssays.uitask.model.LunchItem
import com.developerssays.uitask.model.MenuItem
import com.developerssays.uitask.model.SaladItem
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow



class HomeViewModel( ) : ViewModel(){

    // Selected category
    private var _selectedItemCategory= mutableStateOf("Lunch") // Default selection
    val selectedItemCategory: State<String> = _selectedItemCategory

        // Lists of items for different categories
      val itemOptionsCategories = listOf("Lunch", "Salad", "Burger", "Coffee", "Dessert")

    // Cart data
    private val _cartItems = MutableStateFlow<List<CartItem>>(emptyList())
    val cartItems: StateFlow<List<CartItem>> = _cartItems





    val lunchItemList = listOf(
        LunchItem(id = 1, name = "Pova", description = "Good food", price = 60.00, image = R.drawable.lunch),
        LunchItem(id = 2, name = "Biryani", description = "Spicy rice with meat", price = 120.00, image =R.drawable.lunch1 ),
        LunchItem(id = 3, name = "Paneer Tikka", description = "Grilled paneer with spices", price = 80.00,image = R.drawable.lunch3),
        LunchItem(id = 4, name = "Veg Pulao", description = "Mixed vegetable rice", price = 50.00,image = R.drawable.lunch4),
        LunchItem(id = 5, name = "Chicken Korma", description = "Tender chicken in creamy curry", price = 150.00,image = R.drawable.lunch5),
        LunchItem(id = 6, name = "Dal Makhani", description = "Rich black lentils in creamy sauce", price = 70.00,image = R.drawable.lunch6),
        LunchItem(id = 7, name = "Chole Bhature", description = "Chickpeas served with deep-fried bread", price = 90.00,image = R.drawable.lunch6),
        LunchItem(id = 8, name = "Egg Curry", description = "Hard-boiled eggs in spicy curry", price = 100.00,image = R.drawable.lunch6),
      //  LunchItem(id = 9, name = "Aloo Paratha", description = "Potato-stuffed flatbread", price = 40.00,image = R.drawable.lunch_icon),
      // LunchItem(id = 10, name = "Kadhi Pakora", description = "Fried gram flour fritters in yogurt gravy", price = 75.00,image = R.drawable.lunch_icon)
    )
    val saladItemList = listOf(
        SaladItem(id = 1, name = "Caesar Salad", description = "Crisp Romaine lettuce, croutons, and Caesar dressing", price = 80.00,image = R.drawable.lunch_icon),
        SaladItem(id = 2, name = "Greek Salad", description = "Cucumber, tomatoes, olives, feta cheese, and olive oil dressing", price = 85.00,image = R.drawable.lunch_icon),
        SaladItem(id = 3, name = "Cobb Salad", description = "Mixed greens with grilled chicken, bacon, eggs, and avocado", price = 120.00,image = R.drawable.lunch_icon),
        SaladItem(id = 4, name = "Caprese Salad", description = "Fresh mozzarella, tomatoes, basil, olive oil, and balsamic glaze", price = 95.00,image = R.drawable.lunch_icon),
        SaladItem(id = 5, name = "Quinoa Salad", description = "Quinoa, roasted vegetables, mixed greens, and lemon vinaigrette", price = 110.00,image = R.drawable.lunch_icon),
        SaladItem(id = 6, name = "Spinach Salad", description = "Fresh spinach leaves, walnuts, cranberries, and balsamic vinaigrette", price = 90.00,image = R.drawable.lunch_icon),
        SaladItem(id = 7, name = "Garden Salad", description = "Mixed greens with tomatoes, cucumbers, carrots, and your choice of dressing", price = 70.00,image = R.drawable.lunch_icon),
        SaladItem(id = 8, name = "Avocado Salad", description = "Sliced avocado, mixed greens, tomatoes, and lemon dressing", price = 115.00,image = R.drawable.lunch_icon),
        SaladItem(id = 9, name = "Chicken & Avocado Salad", description = "Grilled chicken, avocado, tomatoes, and a lemon vinaigrette", price = 130.00,image = R.drawable.lunch_icon),
        SaladItem(id = 10, name = "Beetroot Salad", description = "Roasted beets with arugula, goat cheese, and a honey vinaigrette", price = 100.00,image = R.drawable.lunch_icon),
        SaladItem(id = 11, name = "Asian Sesame Salad", description = "Cabbage, carrots, and scallions tossed in sesame dressing", price = 80.00,image = R.drawable.lunch_icon),
        SaladItem(id = 12, name = "Tuna Salad", description = "Tuna with mixed greens, olives, cucumbers, and a light vinaigrette", price = 120.00,image = R.drawable.lunch_icon),
        SaladItem(id = 13, name = "Lentil Salad", description = "Cooked lentils with red onions, tomatoes, and a lemon dressing", price = 95.00,image = R.drawable.lunch_icon),
        SaladItem(id = 14, name = "Fruit Salad", description = "A fresh mix of seasonal fruits with a drizzle of honey", price = 70.00,image = R.drawable.lunch_icon)
    )
    val burgerItemList = listOf(
        BurgerItem(id = 1, name = "Classic Beef Burger", description = "Juicy beef patty with ", price = 120.00, image = R.drawable.burger1),
        BurgerItem(id = 2, name = "Cheese Burger", description = "Beef patty with melted ", price = 130.00,image = R.drawable.burger2),
        BurgerItem(id = 3, name = "Chicken Burger", description = "Grilled chicken patty ", price = 110.00,image = R.drawable.burger3),
        BurgerItem(id = 4, name = "Veggie Burger", description = "A patty made of mixed ", price = 95.00,image = R.drawable.burger4),
        BurgerItem(id = 5, name = "BBQ Bacon Burger", description = "Beef patty topped with crispy ", price = 150.00,image = R.drawable.burger5),
        BurgerItem(id = 6, name = "Spicy Chicken Burger", description = "Spicy grilled chicken patty", price = 120.00,image = R.drawable.burger6),
        BurgerItem(id = 7, name = "Double Cheeseburger", description = "Two beef patties with double ", price = 160.00,image = R.drawable.burger7),
        BurgerItem(id = 8, name = "Fish Burger", description = "Crispy fish fillet ", price = 135.00,image = R.drawable.burger8),
        BurgerItem(id = 9, name = "Breakfast Burger", description = "Beef patty, ", price = 140.00,image = R.drawable.burger8)
    )
    val coffeeItemList = listOf(
        CoffeeItem(id = 1, name = "Espresso", description = "Strong and bold black coffee", price = 40.00,image = R.drawable.lunch_icon),
        CoffeeItem(id = 2, name = "Cappuccino", description = "Espresso with steamed milk ", price = 60.00,image = R.drawable.lunch_icon),
        CoffeeItem(id = 3, name = "Latte", description = "Espresso with steamed milk ", price = 65.00,image = R.drawable.lunch_icon),
        CoffeeItem(id = 4, name = "Americano", description = "Espresso diluted with hot water for a lighter taste", price = 50.00,image = R.drawable.lunch_icon),
        CoffeeItem(id = 5, name = "Macchiato", description = "Espresso with a dash of steamed milk", price = 55.0,image = R.drawable.lunch_icon),
        CoffeeItem(id = 6, name = "Flat White", description = "Espresso with velvety ", price = 70.00,image = R.drawable.lunch_icon),
        CoffeeItem(id = 7, name = "Mocha", description = "Espresso, steamed milk, and ", price = 80.00,image = R.drawable.lunch_icon),
        CoffeeItem(id = 8, name = "Pumpkin Spice Latte", description = "Espresso with steamed milk, ", price = 90.00,image = R.drawable.lunch_icon)
    )
    val dessertItemList = listOf(
        DessertItem(id = 1, name = "Chocolate Cake", description = "Rich and moist chocolate ", price = 120.00,image = R.drawable.dessert1),
        DessertItem(id = 2, name = "Tiramisu", description = "Classic Italian dessert  and mascarpone", price = 130.00,image = R.drawable.dessert2),
        DessertItem(id = 3, name = "Cheesecake", description = "Creamy cheesecake with fruit topping", price = 140.00,image = R.drawable.dessert3),
        DessertItem(id = 4, name = "Apple Pie", description = "Traditional apple ", price = 100.00,image = R.drawable.dessert4),
        DessertItem(id = 5, name = "Brownies", description = "Fudgy chocolate gooey center", price = 80.00,image = R.drawable.dessert5),
        DessertItem(id = 6, name = "Lemon Meringue Pie", description = " topped with fluffy meringue on a flaky crust", price = 110.00,image = R.drawable.dessert6),
        DessertItem(id = 7, name = "Profiteroles", description = "Choux pastry filled with chocolate", price = 95.00,image = R.drawable.dessert6)
    )

    // Update selected category
    fun updateSelectedCategory(category: String) {
        _selectedItemCategory.value = category
    }




    // Add item to cart
    fun addItemToCart(item: MenuItem){
        val currentCartItems = _cartItems.value.toMutableList()
        val existingCartItem = currentCartItems.find { it.item.id==item.id }
        if (existingCartItem!=null){
            existingCartItem.increaseQuantity()
        }else{
            currentCartItems.add(CartItem(item, 1))
        }
        _cartItems.value = currentCartItems
     //   saveCartItems(currentCartItems, savedStateHandle)
        Log.d("item","inside fun ${_cartItems.value}")
    }



    private fun getSavedCartItems(savedStateHandle: SavedStateHandle): List<CartItem> {
        return savedStateHandle.get<List<CartItem>>("cartItems") ?: emptyList()
    }

    private fun saveCartItems(cartItems: List<CartItem>, savedStateHandle: SavedStateHandle) {
        savedStateHandle.set("cartItems", cartItems)
    }

    fun getMenuItemById(itemId: Long): MenuItem? {
        // Check all categories for the item with the given ID
        return lunchItemList.find { it.id == itemId }
            ?: saladItemList.find { it.id == itemId }
            ?: burgerItemList.find { it.id == itemId }
            ?: coffeeItemList.find { it.id == itemId }
            ?: dessertItemList.find { it.id == itemId }
    }


    /*
     fun getItemsForCategory(category: String): List<MenuItem> {
        return when (category) {
            "Lunch" -> lunchItemList
            "Salad" -> saladItemList
            "Burger" -> burgerItemList
            "Coffee" -> coffeeItemList
            "Dessert" -> dessertItemList
            else -> emptyList()
        }
    }
     */



    //remove item in cart
    fun removeItemFromCart(item: MenuItem) {
        val currentCartItems = _cartItems.value.toMutableList()
        val existingCartItem = currentCartItems.find { it.item.id==item.id }
        if (existingCartItem != null && existingCartItem.quantity > 1) {
            existingCartItem.decreaseQuantity()
        }else{
            currentCartItems.remove(existingCartItem)
        }
        _cartItems.value = currentCartItems
    }

    fun getTotalCartItemCount(): Int {
        return _cartItems.value.sumOf { it.quantity }
        //return _cartItems.value.size
    }
}