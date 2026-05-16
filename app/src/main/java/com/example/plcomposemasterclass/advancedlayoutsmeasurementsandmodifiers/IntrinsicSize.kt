package com.example.plcomposemasterclass.advancedlayoutsmeasurementsandmodifiers

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.plcomposemasterclass.ui.theme.PLComposeMasterclassTheme

@Composable
fun IntrinsicSizeDemoMax(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .width(intrinsicSize = IntrinsicSize.Max),
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                text = "Option 1 is now the longer option"
            )

            Checkbox(
                checked = true,
                onCheckedChange = {}
            )
        }

        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                text = "Option 1, but in way longer"
            )

            Checkbox(
                checked = false,
                onCheckedChange = {}
            )
        }
    }
}

@Composable
fun IntrinsicSizeDemoMin(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .width(intrinsicSize = IntrinsicSize.Min)

    ) {
        Text(
            text = "Hello world I am some kind of longer text",
            modifier = Modifier.fillMaxWidth()
        )
    }
}

@Preview(
    showBackground = true
)
@Composable
private fun IntrinsicSizeDemoMaxPreview() {
    PLComposeMasterclassTheme {
        IntrinsicSizeDemoMax()
    }
}

@Preview(
    showBackground = true
)
@Composable
private fun IntrinsicSizeDemoMinPreview() {
    PLComposeMasterclassTheme {
        IntrinsicSizeDemoMin()
    }
}
