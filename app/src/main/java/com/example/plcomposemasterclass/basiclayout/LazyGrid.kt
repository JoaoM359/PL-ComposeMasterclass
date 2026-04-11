package com.example.plcomposemasterclass.basiclayout

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.plcomposemasterclass.ui.theme.PLComposeMasterclassTheme
import kotlin.random.Random
import kotlin.random.nextInt

@Composable
fun LazyGridDemo(modifier: Modifier = Modifier) {
    LazyVerticalStaggeredGrid(
        modifier = modifier.fillMaxSize(),
        columns = StaggeredGridCells.Fixed(5),
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        verticalItemSpacing = 16.dp,
    ) {
        items(100) {
            Box(
                modifier = Modifier
                    .height(
                        height = Random.nextInt(
                            1..200
                        ).dp
                    )
                    .clip(RoundedCornerShape(10.dp))
                    .background(Color(Random.nextInt()))
            )
        }
    }
}

@Preview
@Composable
private fun LazyGridDemoPreview() {
    PLComposeMasterclassTheme {
        LazyGridDemo()
    }
}