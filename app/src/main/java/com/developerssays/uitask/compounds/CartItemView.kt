package com.developerssays.uitask.compounds

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Minimize
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.developerssays.uitask.R
import com.developerssays.uitask.model.CartItem


@Composable
fun CartItemView(
    item: CartItem,
    onClikedIncrese: () -> Unit,
    onClikedDecrese:()->Unit

){

    Row (modifier = Modifier
        .fillMaxWidth()
        .padding(10.dp), verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.Center)
    {
        // item icon
        Image(painter = painterResource(id = item.item.image),
            contentDescription ="item images",
            modifier = Modifier
                .size(40.dp)
                .clip(shape = CircleShape),
            contentScale = ContentScale.FillBounds )
        Spacer(modifier = Modifier.width(15.dp))

        //itam name
        Text(text = "${item.item.name}", fontSize = 12.sp,
            style = MaterialTheme.typography.bodyMedium)
        Spacer(modifier = Modifier.width(5.dp))

        IconButton(onClick = {onClikedIncrese()

        })
        {
            Icon(Icons.Default.Add,
                "add button  ",
                tint = Color.Black,
                modifier = Modifier.size(30.dp))
        }
        Spacer(modifier = Modifier.width(5.dp))
        Text(text = "${item.quantity}", fontSize = 12.sp,
            style = MaterialTheme.typography.bodyMedium)

        IconButton(onClick = {onClikedDecrese.invoke()
              }   )
        {
            Icon(
                Icons.Default.Minimize,
                "minues button ", tint = Color.Black,
                modifier = Modifier.size(30.dp)
            )

        }
        // item total price
        Text(text = "${item.totalPrice}", fontSize = 12.sp,
            style = MaterialTheme.typography.bodyMedium)
    }

}