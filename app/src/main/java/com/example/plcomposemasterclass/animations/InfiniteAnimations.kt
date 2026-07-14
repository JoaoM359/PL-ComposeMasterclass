package com.example.plcomposemasterclass.animations

import androidx.compose.animation.animateColor
import androidx.compose.animation.core.RepeatMode.Reverse
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.plcomposemasterclass.ui.theme.PLComposeMasterclassTheme

@Composable
fun InfiniteAnimations(modifier: Modifier = Modifier) {
    val transition = rememberInfiniteTransition(
        label = "Infinite transition"
    )
    val ratio by transition.animateFloat(
        initialValue = 0f,
        targetValue = 1f,
        animationSpec = infiniteRepeatable(
            animation = tween(durationMillis = 3000),
            repeatMode = Reverse,
        ),
        label = "Ratio animation"
    )
    val color by transition.animateColor(
        initialValue = Color.Red,
        targetValue = Color.Green,
        animationSpec = infiniteRepeatable(
            animation = tween(3000),
            repeatMode = Reverse
        ),
        label = "Color animation"
    )
    Box(
        modifier = modifier
            .graphicsLayer {
                rotationZ = ratio * 360f
                scaleX = ratio
                scaleY = ratio
            }
            .size(100.dp)
            .drawBehind {
                drawRect(color = color)
            }
    )
}

@Preview(
    showBackground = true
)
@Composable
private fun InfiniteAnimationsPreview() {
    PLComposeMasterclassTheme {
        InfiniteAnimations()
    }
}
