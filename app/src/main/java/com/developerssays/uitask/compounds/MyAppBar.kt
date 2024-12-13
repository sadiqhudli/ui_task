package com.developerssays.uitask.compounds

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyAppbar(onClicked: () -> Unit) {
    TopAppBar(title = { Text(text = "pos System ") },
        navigationIcon = {
            IconButton(onClick = { onClicked.invoke() })
            {
                Icon(Icons.Default.ShoppingCart, contentDescription = "")

            }
        })
}