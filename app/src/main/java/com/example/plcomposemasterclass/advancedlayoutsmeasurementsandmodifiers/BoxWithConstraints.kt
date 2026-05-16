package com.example.plcomposemasterclass.advancedlayoutsmeasurementsandmodifiers

import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.plcomposemasterclass.ui.theme.PLComposeMasterclassTheme

@Composable
fun BoxWithConstraintsDemo(modifier: Modifier = Modifier) {
    BoxWithConstraints(
        modifier = modifier,
        ) {
        Text(
            text = if (constraints.hasFixedWidth) "Fixed width!" else "Dynamic width!"
        )
    }
}

@Preview(
    showBackground = true
)
@Composable
private fun BoxWithConstraintsDemoFixedWidthPreview() {
    PLComposeMasterclassTheme {
        BoxWithConstraintsDemo(
            modifier = Modifier.width(200.dp)
        )
    }
}

@Preview(
    showBackground = true
)
@Composable
private fun BoxWithConstraintsDemoDynamicWidthPreview() {
    PLComposeMasterclassTheme {
        BoxWithConstraintsDemo()
    }
}
