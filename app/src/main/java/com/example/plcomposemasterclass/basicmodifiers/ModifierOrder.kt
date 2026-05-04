package com.example.plcomposemasterclass.basicmodifiers

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.plcomposemasterclass.ui.theme.PLComposeMasterclassTheme

@Composable
fun ModifierOrderDemo(modifier: Modifier = Modifier) {

    Box(
        modifier = modifier,
        contentAlignment = Alignment.Center
    ) {
        Text("Hello World")
    }
}

@Preview
@Composable
private fun ModifierOrderDemoBackgroundBeforePreview() {
    PLComposeMasterclassTheme {
        ModifierOrderDemo(
            modifier = Modifier
                .size(100.dp)
                .background(Color.Red)
                .padding(16.dp)
                .clip(CircleShape),
        )
    }
}

@Preview
@Composable
private fun ModifierOrderDemoPaddingBeforePreview() {
    PLComposeMasterclassTheme {
        ModifierOrderDemo(
            modifier = Modifier
                .size(100.dp)
                .padding(16.dp)
                .background(Color.Red)
                .clip(CircleShape),
        )
    }
}

@Preview
@Composable
private fun ModifierOrderDemoClipBeforePreview() {
    PLComposeMasterclassTheme {
        ModifierOrderDemo(
            modifier = Modifier
                .size(100.dp)
                .clip(CircleShape)
                .background(Color.Red)
                .padding(16.dp),
        )
    }
}

@Preview
@Composable
private fun ModifierOrderDemoMultipleClipPreview() {
    PLComposeMasterclassTheme {
        ModifierOrderDemo(
            modifier = Modifier
                .size(100.dp)
                .clip(CircleShape)
                .background(Color.Red)
                .padding(16.dp)
                .clip(CircleShape)
                .background(Color.Green),
        )
    }
}
