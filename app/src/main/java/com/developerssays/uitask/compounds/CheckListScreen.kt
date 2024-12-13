package com.developerssays.uitask.compounds

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Minimize
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.developerssays.uitask.R
import com.developerssays.uitask.model.CartItem
import com.developerssays.uitask.model.MenuItem
import com.developerssays.uitask.viewModel.HomeViewModel
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun CheckListScreen(
    navController: NavHostController,
    cartItemsJson: String?,
   // cartItems: List<CartItem>,
) {

    val itemTaoltalPrice = remember { mutableStateOf(1) }
    val itemQty = remember {
        mutableStateOf(1)
    }
    val vm: HomeViewModel = viewModel()

    val cartItems: List<MenuItem> = if (!cartItemsJson.isNullOrEmpty())
    {
        Gson().fromJson(cartItemsJson,object : TypeToken<List<MenuItem>>() {}.type)
    }else{
        emptyList()
    }

    Log.d("cartItems","$cartItems")

    Scaffold(modifier = Modifier.fillMaxSize(),
        topBar = { MyAppbar(onClicked = { navController.popBackStack() }) },
        content = { pad ->
            Column(modifier = Modifier.padding(paddingValues = pad))
            {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(10.dp),
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {

                    Button(onClick = { /*TODO*/ },
                        colors = ButtonDefaults.buttonColors(Color.Blue))
                    {
                        Text(text = "Add member")

                    }
                    Button(onClick = { /*TODO*/ },
                        colors = ButtonDefaults.buttonColors(Color.Blue) ) {
                        Text(text = "New Champaing")

                    }

                    // lazyCloum

                }

                Card(
                    modifier = Modifier.fillMaxSize().padding(10.dp),
                    elevation = CardDefaults.elevatedCardElevation(10.dp),
                    colors = CardDefaults.cardColors(Color.White)
                ) {
                    Column(
                        verticalArrangement = Arrangement.SpaceEvenly,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {

                        LazyColumn(contentPadding = PaddingValues(vertical = 10.dp, horizontal = 10.dp)) {
                            items(2){
                                ItemViewPrice( 1, totalPrice = 60,
                                    onClikedIncrese = {})
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
                                DetailsItems(text = "SubTotal", textValue = "12.22")
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



@Composable
fun ItemViewPrice(
    qty:Int,
    totalPrice:Int,
    onClikedIncrese: () -> Unit,
  //  onClikedDecrese:(Int)->Unit

){

    var itemQty= remember { mutableStateOf(qty) }
    val itemTotalPrice = remember { mutableStateOf(totalPrice) }
    Row (modifier = Modifier
        .fillMaxWidth()
        .padding(10.dp), verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.Center)
    {
        // item icon
        Image(painter = painterResource(id = R.drawable.lunch6),
            contentDescription ="item images",
            modifier = Modifier.size(40.dp).clip(shape = CircleShape),
            contentScale = ContentScale.FillBounds )
        Spacer(modifier = Modifier.width(15.dp))

            //itam name
        Text(text = "item name", fontSize = 12.sp,
            style = MaterialTheme.typography.bodyMedium)
        Spacer(modifier = Modifier.width(5.dp))

        IconButton(onClick = {
            itemQty.value=itemQty.value+1
            onClikedIncrese()   })
        {
            Icon(Icons.Default.Add,"add button  ")
        }
        Spacer(modifier = Modifier.width(5.dp))
        Text(text = "itemQty${itemQty.value}", fontSize = 12.sp,
            style = MaterialTheme.typography.bodyMedium)

        IconButton(onClick = {  onClikedIncrese.invoke()    }   )
        {
            Icon(Icons.Default.Minimize,"minues button ")

        }
        // item total price
        Text(text = itemTotalPrice.toString(), fontSize = 12.sp,
            style = MaterialTheme.typography.bodyMedium)
    }

}



@Composable
fun DetailsItems(
    text:String,
    textValue:String
){

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 0.dp, start = 20.dp, end = 20.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(100.dp)
    ) {
        Text(text = text)
        Text(text = textValue)
    }
}


@Composable
fun PaymentMode(
    icon: Painter,
    name: String,
    onCliked: () -> Unit,

    ) {
    Card(modifier = Modifier
        .size(100.dp)
        .padding(10.dp)
        .clickable { onCliked.invoke() }) {
        Column(
            modifier = Modifier.padding(10.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = icon, contentDescription = "", modifier = Modifier.size(20.dp)
            )
            Text(text = "$name", style = MaterialTheme.typography.bodyLarge)
        }

    }

}
