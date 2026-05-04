package com.example.plcomposemasterclass.basicmodifiers

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.plcomposemasterclass.ui.theme.PLComposeMasterclassTheme

@Composable
fun OffsetModifiersDemo(modifier: Modifier = Modifier) {

    Column(
        modifier = modifier
            .size(100.dp)
            .background(Color.Red)
    ) {
        Text(
            text = "Hello World",
            modifier = Modifier
                .offset(
                    x = 50.dp,
                    y = 20.dp
                )
                .background(Color.Green)
        )

        Text(
            text = "Hello World",
            modifier = Modifier
                .background(Color.Yellow)
        )
    }
}

@Preview(
    showBackground = true
)
@Composable
private fun OffsetModifiersDemoPreview() {
    PLComposeMasterclassTheme {
        OffsetModifiersDemo()
    }
}
