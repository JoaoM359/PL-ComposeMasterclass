package com.example.plcomposemasterclass.statemanagement

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.plcomposemasterclass.ui.theme.PLComposeMasterclassTheme

@Composable
fun CounterDemo(
    counter: Int,
    onCounterButtonClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier,
        contentAlignment = Alignment.Center,
    ) {
        Button(
            onClick = onCounterButtonClick
        ) {
            Text(text = "Count: $counter")
        }
    }
}

@Composable
fun StateHoistingDemo(modifier: Modifier = Modifier) {
    var counter by rememberSaveable {
        mutableIntStateOf(0)
    }

    Column(
        modifier = modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        CounterDemo(
            counter = counter,
            onCounterButtonClick = {
                counter += 2
            }
        )

        Button(
            onClick = {
                counter = 0
            }
        ) {
            Text(text = "Reset counter")
        }
    }
}

@Preview(
    showBackground = true
)
@Composable
private fun StateHoistingDemoPreview() {
    PLComposeMasterclassTheme {
        StateHoistingDemo()
    }
}



