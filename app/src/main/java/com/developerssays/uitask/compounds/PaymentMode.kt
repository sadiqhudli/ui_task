package com.developerssays.uitask.compounds

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.unit.dp


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
