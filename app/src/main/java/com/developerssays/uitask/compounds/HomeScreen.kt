package com.developerssays.uitask.compounds

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.developerssays.uitask.R
import com.developerssays.uitask.model.LunchItem
import com.developerssays.uitask.model.SaladItem
import com.developerssays.uitask.viewModel.HomeViewModel
import com.google.gson.Gson

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun HomeScreen(innerPadding: PaddingValues,
               navController: NavHostController)
{
    // get viewmodel
    val viewModel: HomeViewModel = viewModel()
    val selectedItemCategory by viewModel.selectedItemCategory
    val itemOptions = viewModel.itemOptionsCategories

    Scaffold(modifier = Modifier.fillMaxSize(),
        topBar = { MyAppbar(onClicked = {
                  val cartItemsJson = Gson().toJson(viewModel.cartItems.value.values.map { it.item })
                    navController.navigate("checkList/$cartItemsJson")
               })},
            //}
         //  val cartItems = viewModel.cartItems.value.values.map { it.item }.joinToString(",")
           //  navController.navigate("checkList")})},
        content = { paddingValues ->
            Column (modifier = Modifier.fillMaxSize()
                .padding(paddingValues = paddingValues))
        {
                Spacer(modifier = Modifier.height(20.dp))
            LazyRow(modifier = Modifier
                .fillMaxWidth(), contentPadding = PaddingValues(10.dp))
            {
                items(itemOptions.size){index->
                    val itemName = itemOptions[index]
                    CustomChips(itemName =itemName,
                        onClicked = { viewModel.updateSelectedCategory(itemName)    }   )
                }
            }
            Column(modifier = Modifier.fillMaxWidth()
                .padding(10.dp).weight(1f))
            {
                Text(text = selectedItemCategory.toString(), fontSize = 22.sp)
                LazyVerticalGrid(columns = GridCells.Fixed(2),
                    contentPadding = PaddingValues(10.dp))
                {
                    when(selectedItemCategory){
                        "Lunch" -> items(viewModel.lunchItemList) { item ->
                            MenuItemCard(item, onAddClicked = {viewModel.addItemToCart(item)})
                            Log.d("items","$item")
                        }

                        "Salad" -> items(viewModel.saladItemList) { item ->
                            MenuItemCard(item, onAddClicked = {viewModel.addItemToCart(item)})
                        }
                        "Burger" -> items(viewModel.burgerItemList) { item ->
                            MenuItemCard(item, onAddClicked = {viewModel.addItemToCart(item)})
                        }
                        "Coffee" -> items(viewModel.coffeeItemList) { item ->
                            MenuItemCard(item, onAddClicked = {viewModel.addItemToCart(item)})

                        }
                        "Dessert" -> items(viewModel.dessertItemList) { item ->
                            MenuItemCard(item, onAddClicked = {viewModel.addItemToCart(item)})

                        }
                    }
                    
                }
            }
        }}
    )

}


@Preview(showBackground = true)
@Composable
fun HomePre() {
    //HomeScreen(innerPadding = PaddingValues())
}



@Preview(showBackground = false)
@Composable
fun HomePreLight() {
   // HomeScreen(innerPadding = PaddingValues())
}