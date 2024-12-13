package com.developerssays.uitask.compounds

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.developerssays.uitask.R
import com.developerssays.uitask.viewModel.HomeViewModel


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun CheckListScreen(
    navController: NavHostController,
    viewModel: HomeViewModel,
    ) {

    val cartItemList = viewModel.cartItems.collectAsState().value
    Log.d("it","$cartItemList")
    val list = remember {
        mutableListOf(0)
    }
    Scaffold(modifier = Modifier.fillMaxSize(),
        topBar = { MyAppbar(onClicked = { navController.popBackStack() }, title = navController.currentDestination!!.route.toString()) },
        content = { pad ->
            Column(modifier = Modifier.padding(paddingValues = pad))
            {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(10.dp),
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {

                    Button(onClick = {  },
                        colors = ButtonDefaults.buttonColors(Color.Blue))
                    {
                        Text(text = "Add member")

                    }
                    Button(onClick = { /*TODO*/ },
                        colors = ButtonDefaults.buttonColors(Color.Blue) ) {
                        Text(text = "New Champaing")

                    }
                }

                Card(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(10.dp),
                    elevation = CardDefaults.elevatedCardElevation(10.dp),
                    colors = CardDefaults.cardColors(Color.White)
                ) {
                    Column(
                        verticalArrangement = Arrangement.SpaceEvenly,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {

                        LazyColumn(contentPadding = PaddingValues(vertical = 10.dp, horizontal = 10.dp)) {
                            items(cartItemList){entry->
                                val item = entry
                                CartItemView(item = item,
                                    onClikedIncrese = { item.increaseQuantity()},
                                    onClikedDecrese = {viewModel.addItemToCart(item = item.item)})
                            }
                        }

                        Card(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(10.dp),
                            elevation = CardDefaults.elevatedCardElevation(10.dp),
                            colors = CardDefaults.cardColors(colorResource(id = R.color.teal_200))
                        ) {
                            Column(
                                modifier = Modifier.padding(10.dp),
                                verticalArrangement = Arrangement.spacedBy(10.dp),
                                horizontalAlignment = Alignment.CenterHorizontally
                            ) {
                                DetailsItems(text = "SubTotal$", textValue = "12.22")
                                DetailsItems(text = "Discount", textValue = "2")
                                DetailsItems(text = "Tax(12%)", textValue = "2")
                            }

                        }

                        // Payments
                        Text(text = "Payment Methods ")

                        Row {
                            PaymentMode(
                                name = "Cash",
                                onCliked = {},
                                icon = painterResource(id = R.drawable.rupee_indian)
                            )

                            PaymentMode(
                                name = "PhonePay",
                                onCliked = {},
                                icon = painterResource(id = R.drawable.download)
                            )

                            PaymentMode(
                                name = "Card",
                                onCliked = {},
                                icon = painterResource(id = R.drawable.e_wallet)
                            )
                        }

                        Button(
                            onClick = { /*TODO*/ },
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(10.dp)
                        ) {
                            Text(text = "Prints Bill")

                        }


                    }
                }
            }
        })
}





