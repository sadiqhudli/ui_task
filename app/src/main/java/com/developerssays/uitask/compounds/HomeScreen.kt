package com.developerssays.uitask.compounds

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.developerssays.uitask.viewModel.HomeViewModel

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun HomeScreen(
    innerPadding: PaddingValues,
    navController: NavHostController,
    viewModel: HomeViewModel,
) {

    val selectedItemCategory by viewModel.selectedItemCategory
    val itemOptionsCategories = viewModel.itemOptionsCategories
    val context = LocalContext.current

    Scaffold(modifier = Modifier.fillMaxSize(), topBar = {
        MyAppbar(title = navController.currentDestination!!.route.toString(), onClicked = {
            navController.navigate("CheckListScreen")
        })
    },

        content = { paddingValues ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues = paddingValues)
            ) {
                Spacer(modifier = Modifier.height(20.dp))
                LazyRow(
                    modifier = Modifier.fillMaxWidth(), contentPadding = PaddingValues(10.dp)
                ) {
                    items(itemOptionsCategories.size) { index ->
                        val itemName = itemOptionsCategories[index]
                        CustomChips(itemName = itemName,
                            onClicked = { viewModel.updateSelectedCategory(itemName) })
                    }
                }
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(10.dp)
                        .weight(1f)
                ) {
                    Text(text = selectedItemCategory.toString(), fontSize = 22.sp)
                    //  val itemsForSelectedCategory=
                    LazyVerticalGrid(
                        columns = GridCells.Fixed(2), contentPadding = PaddingValues(10.dp)
                    ) {
                        when (selectedItemCategory) {
                            "Lunch" -> items(viewModel.lunchItemList) { item ->
                                MenuItemCard(item, onAddClicked = { viewModel.addItemToCart(item) })
                            }

                            "Salad" -> items(viewModel.saladItemList) { item ->
                                MenuItemCard(item, onAddClicked = { viewModel.addItemToCart(item) })
                            }

                            "Burger" -> items(viewModel.burgerItemList) { item ->
                                MenuItemCard(item, onAddClicked = { viewModel.addItemToCart(item) })
                            }

                            "Coffee" -> items(viewModel.coffeeItemList) { item ->
                                MenuItemCard(item, onAddClicked = { viewModel.addItemToCart(item) })
                            }

                            "Dessert" -> items(viewModel.dessertItemList) { item ->
                                MenuItemCard(item, onAddClicked = { viewModel.addItemToCart(item) })

                            }
                        }

                    }
                }
            }
        })

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