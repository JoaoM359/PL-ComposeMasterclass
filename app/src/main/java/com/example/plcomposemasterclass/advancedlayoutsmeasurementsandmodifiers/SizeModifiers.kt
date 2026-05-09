package com.example.plcomposemasterclass.advancedlayoutsmeasurementsandmodifiers

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.requiredWidth
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.plcomposemasterclass.advancedlayoutsmeasurementsandmodifiers.utils.printConstraints
import com.example.plcomposemasterclass.ui.theme.PLComposeMasterclassTheme

@Composable
fun SizeModifiersDemo(modifier: Modifier = Modifier) {
    Row(
        modifier = modifier
            .height(100.dp)
            .fillMaxWidth()
            .background(Color.Red)
    ) {
        Box(
            modifier = Modifier
                .height(100.dp)
                .printConstraints("Before 1. fillMaxWidth")
                .requiredWidth(300.dp)
                .background(Color.Green)
                .wrapContentWidth(
                    align = Alignment.CenterHorizontally
                )
                .printConstraints("After 1. fillMaxWidth")
                .background(Color.Yellow),
        ) {
            Text("Hello")
        }

//        Box(
//            modifier = Modifier
//                .height(100.dp)
//                .printConstraints("Before 2. fillMaxWidth")
//                .requiredWidth(300.dp)
//                .wrapContentWidth()
//                .printConstraints("After 2. fillMaxWidth")
//                .background(Color.Green),
//            contentAlignment = Alignment.Center
//        ){
//            Text(
//                text = "Hello world this is a text",
//            )
//        }
    }
}

@Preview
@Composable
private fun SizeModifiersDemoPreview() {
    PLComposeMasterclassTheme {
        SizeModifiersDemo()
    }
}
