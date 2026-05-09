package com.example.plcomposemasterclass.advancedlayoutsmeasurementsandmodifiers.utils

import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.layout

fun Modifier.printConstraints(tag: String): Modifier {
    return layout { measurable, constraints ->
        println("$tag: $constraints")
        val placeable = measurable.measure(constraints)

        layout(placeable.width, placeable.height) {
            placeable.place(0, 0)
        }
    }
}
