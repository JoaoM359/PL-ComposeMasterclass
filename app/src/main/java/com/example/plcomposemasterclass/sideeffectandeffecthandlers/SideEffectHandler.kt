package com.example.plcomposemasterclass.sideeffectandeffecthandlers

import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.Modifier

@Composable
fun SideEffectHandlerDemo(modifier: Modifier = Modifier) {
    SideEffect {
        // Called after every successful recomposition
    }
}
