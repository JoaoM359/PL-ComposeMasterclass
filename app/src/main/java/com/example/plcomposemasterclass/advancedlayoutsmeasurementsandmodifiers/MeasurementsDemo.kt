package com.example.plcomposemasterclass.advancedlayoutsmeasurementsandmodifiers

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.plcomposemasterclass.ui.theme.PLComposeMasterclassTheme

@Composable
fun MeasurementsDemo(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .background(Color.Red)
            .padding(16.dp)
    ) {
        Text(
            text = "This is a text",
            modifier = Modifier
                .background(Color.Yellow)
        )

        Text(
            text = "This is another text",
            modifier = Modifier
                .background(Color.Green)
        )

    }
}

@Preview
@Composable
private fun MeasurementsDemoPreview() {
    PLComposeMasterclassTheme {
        MeasurementsDemo()
    }
}
