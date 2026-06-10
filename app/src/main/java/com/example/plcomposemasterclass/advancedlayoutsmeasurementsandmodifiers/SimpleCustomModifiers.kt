package com.example.plcomposemasterclass.advancedlayoutsmeasurementsandmodifiers

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.plcomposemasterclass.ui.theme.PLComposeMasterclassTheme

fun Modifier.applyIf(
    condition: Boolean,
    modifier: Modifier.() -> Modifier
): Modifier {
    return if (condition) {
        this.then(modifier())
    } else this
}

@Composable
fun SimpleCustomModifierDemo(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .size(100.dp)
            .applyIf(true) {
                background(Color.Red)
                    .padding(16.dp)
            }
    )
}

@Preview
@Composable
private fun SimpleCustomModifierDemoPreview() {
    PLComposeMasterclassTheme {
        SimpleCustomModifierDemo()
    }
}
