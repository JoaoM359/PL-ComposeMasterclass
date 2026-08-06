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
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.plcomposemasterclass.basicmodifiers.TriangleShape
import com.example.plcomposemasterclass.compositionlocals.LocalShape
import com.example.plcomposemasterclass.performanceoptimization.ReducingOverdrawDemo
import com.example.plcomposemasterclass.ui.theme.PLComposeMasterclassTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PLComposeMasterclassTheme {
                CompositionLocalProvider(LocalShape provides TriangleShape) {
                    Scaffold(
                        modifier = Modifier.fillMaxSize(),
                    ) { innerPadding ->
                        ReducingOverdrawDemo(
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(innerPadding)
                        )
                    }
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
