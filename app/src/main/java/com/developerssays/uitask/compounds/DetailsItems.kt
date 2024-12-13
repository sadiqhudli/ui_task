package com.developerssays.uitask.compounds

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp


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