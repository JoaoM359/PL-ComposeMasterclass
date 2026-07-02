package com.example.plcomposemasterclass.compositionlocals.homeworkassignment

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.Modifier
import kotlinx.coroutines.launch

val LocalSnackbarState = staticCompositionLocalOf { SnackbarHostState() }

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val state = LocalSnackbarState.current
            val scope = rememberCoroutineScope()

            Scaffold(
                snackbarHost = { SnackbarHost(state) }
            ) { innerPadding ->
                Button(
                    modifier = Modifier.padding(innerPadding),
                    onClick = {
                        scope.launch {
                            state.showSnackbar("Hello world!")
                        }
                    }
                ) {
                    Text("Click me")
                }
            }
        }
    }
}
