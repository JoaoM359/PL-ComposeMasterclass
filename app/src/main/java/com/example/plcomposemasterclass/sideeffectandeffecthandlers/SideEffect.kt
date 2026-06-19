package com.example.plcomposemasterclass.sideeffectandeffecthandlers

import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.plcomposemasterclass.ui.theme.PLComposeMasterclassTheme

@Composable
fun SideEffectDemo(modifier: Modifier = Modifier) {
    var counter by remember {
        mutableIntStateOf(0)
    }

    Button(
        modifier = modifier,
        onClick = {
            counter++
        }
    ) {
        Text("Counter: $counter")
    }
}

@Preview
@Composable
private fun SideEffectDemoPreview() {
    PLComposeMasterclassTheme {
        SideEffectDemo()
    }
}
