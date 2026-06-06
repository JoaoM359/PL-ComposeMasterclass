package com.example.plcomposemasterclass

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.IntOffset
import com.example.plcomposemasterclass.advancedlayoutsmeasurementsandmodifiers.LazyMindMap
import com.example.plcomposemasterclass.advancedlayoutsmeasurementsandmodifiers.MindMapItem
import com.example.plcomposemasterclass.ui.theme.PLComposeMasterclassTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PLComposeMasterclassTheme {
                Scaffold(
                    modifier = Modifier.fillMaxSize()
                ) { innerPadding ->
                    val mindMapItems = remember {
                        listOf(
                            MindMapItem(
                                title = "Hello World 1",
                                percentageOffset = Offset(
                                    x = 0f,
                                    y = 0f
                                )
                            ),
                            MindMapItem(
                                title = "Hello World 2",
                                percentageOffset = Offset(
                                    x = 1f,
                                    y = 0f
                                )
                            ),
                            MindMapItem(
                                title = "Hello World 3",
                                percentageOffset = Offset(
                                    x = 0.3f,
                                    y = -0.5f
                                )
                            ),
                            MindMapItem(
                                title = "Hello World 4",
                                percentageOffset = Offset(
                                    x = -0.2f,
                                    y = 1.5f
                                )
                            ),
                        )
                    }
                    var mindMapOffset by remember {
                        mutableStateOf(IntOffset.Zero)
                    }
                    LazyMindMap(
                        items = mindMapItems,
                        mindMapOffset = mindMapOffset,
                        onDrag = { delta ->
                            mindMapOffset += delta
                        },
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    PLComposeMasterclassTheme {
        Greeting("Android")
    }
}
