package com.developerssays.uitask.compounds


import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.developerssays.uitask.R
import com.developerssays.uitask.model.BurgerItem
import com.developerssays.uitask.model.CoffeeItem
import com.developerssays.uitask.model.DessertItem
import com.developerssays.uitask.model.LunchItem
import com.developerssays.uitask.model.MenuItem
import com.developerssays.uitask.model.SaladItem


@Composable
fun MenuItemCard(item: MenuItem,
                 onAddClicked: (MenuItem) -> Unit,
                // navController: NavHostController
                 ) {
        // Display the Menu Item Card
        Card(
            modifier = Modifier.size(180.dp).padding(5.dp).clickable {
                onAddClicked.invoke(item) },
            elevation = CardDefaults.elevatedCardElevation(10.dp),
            colors = CardDefaults.cardColors(Color.White)
        ) {
            Column(
                modifier = Modifier.fillMaxWidth().padding(5.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                // Display item image
                Image(
                    painter = painterResource(id = item.image), // Dynamic item image
                    contentDescription = "",
                    modifier = Modifier.size(100.dp)
                        .clip(RoundedCornerShape(10.dp)),
                    contentScale = ContentScale.FillBounds
                )
                Spacer(modifier = Modifier.height(5.dp))

                // Display item name
                Text(
                    text = item.name,
                    fontSize = 16.sp,
                    style = MaterialTheme.typography.titleSmall,
                    textAlign = TextAlign.Center
                )

                Spacer(modifier = Modifier.height(5.dp))
                // Display item description
                Text(
                    text = item.description,
                    fontSize = 12.sp,
                    style = MaterialTheme.typography.bodySmall
                )
                // Display item price
                Text(
                    text = "₹${item.price}",
                    fontSize = 14.sp,
                    style = MaterialTheme.typography.labelLarge
                )
            }
        }
    }

