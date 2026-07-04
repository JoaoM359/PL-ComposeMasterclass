package com.example.plcomposemasterclass.thedrawingphaseandcanvasbasics

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawWithCache
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.plcomposemasterclass.ui.theme.PLComposeMasterclassTheme

@Composable
fun CanvasModifiersDemo(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .fillMaxSize()
            .background(Color.Green)
            .drawWithCache {
                val veryComplexResult = (1..1000000).map { it * it }
                onDrawWithContent {
                    drawCircle(Color.Red)
                    drawContent()
                    drawCircle(
                        color = Color.Yellow,
                        radius = 10.dp.toPx()
                    )
                }
            },
//            .drawWithContent {
//
//            },
//            .drawBehind {
//                withTransform(
//                    transformBlock = {
//                        rotate(degrees = 90f)
//                    },
//                    drawBlock = {
//
//                        drawLine(
//                            brush = Brush.verticalGradient(
//                                colors = listOf(
//                                    Color.Yellow,
//                                    Color.Red
//                                )
//                            ),
//                            start = Offset.Zero,
//                            end = center,
//                            strokeWidth = 10.dp.toPx()
//                        )
//                    }
//                )
//
//            },
        contentAlignment = Alignment.Center
    ) {
        Text("Hello World")
    }
}

@Preview(
    showBackground = true
)
@Composable
private fun CanvasModifiersDemoPreview() {
    PLComposeMasterclassTheme {
        CanvasModifiersDemo()
    }
}
