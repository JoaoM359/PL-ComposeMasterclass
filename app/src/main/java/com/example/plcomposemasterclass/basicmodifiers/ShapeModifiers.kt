package com.example.plcomposemasterclass.basicmodifiers

import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Outline
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.LayoutDirection
import com.example.plcomposemasterclass.R
import com.example.plcomposemasterclass.ui.theme.PLComposeMasterclassTheme

@Composable
fun ShapeModifiersDemo(modifier: Modifier = Modifier) {
    Image(
        painter = painterResource(R.drawable.kermit),
        contentDescription = null,
        contentScale = ContentScale.Crop,
        modifier = modifier
            .clip(
                TriangleShape
            )
    )
}

data object TriangleShape : Shape {
    override fun createOutline(
        size: Size,
        layoutDirection: LayoutDirection,
        density: Density
    ): Outline {
        return Outline.Generic(
            path = Path().apply {
                moveTo(
                    x = size.width / 2f,
                    y = 0f
                )
                lineTo(
                    x = 0f,
                    y = size.height
                )
                lineTo(
                    x = size.width,
                    y = size.height
                )
                close()
            }
        )
    }
}

@Preview(
    showBackground = true
)
@Composable
private fun ShapeModifiersDemoPreview() {
    PLComposeMasterclassTheme {
        ShapeModifiersDemo()
    }
}
