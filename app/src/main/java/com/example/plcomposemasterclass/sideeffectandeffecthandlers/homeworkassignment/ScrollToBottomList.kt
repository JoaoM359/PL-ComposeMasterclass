package com.example.plcomposemasterclass.sideeffectandeffecthandlers.homeworkassignment

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.snapshotFlow
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

class ScrollToBottomViewModel: ViewModel() {
    val snackbarState = SnackbarHostState()
    val lazyListState = LazyListState()

    init {
        snapshotFlow {
            val layoutInfo = lazyListState.layoutInfo
            layoutInfo.visibleItemsInfo.lastOrNull()?.index == layoutInfo.totalItemsCount - 1
        }.onEach { isScrolledToEnd ->
            if(isScrolledToEnd) {
                snackbarState.showSnackbar("Scrolled to the bottom!")
            }
        }.launchIn(viewModelScope)
    }
}

@Composable
fun LazyColumnRoot() {
    val viewModel = viewModel<ScrollToBottomViewModel>()
    ScrollToBottomLazyColumn(
        snackbarHostState = viewModel.snackbarState,
        lazyListState = viewModel.lazyListState,
        items = List(30) {
            "Item $it"
        },
        modifier = Modifier
            .fillMaxSize()
    )
}

@Composable
fun ScrollToBottomLazyColumn(
    snackbarHostState: SnackbarHostState,
    lazyListState: LazyListState,
    items: List<String>,
    modifier: Modifier = Modifier
) {
    Scaffold(
        modifier = modifier,
        snackbarHost = {
            SnackbarHost(snackbarHostState)
        }
    ) { innerPadding ->
        LazyColumn(
            state = lazyListState,
            contentPadding = innerPadding,
            modifier = Modifier
                .fillMaxSize()
        ) {
            items(items) {
                Text(
                    text = it,
                    modifier = Modifier
                        .fillParentMaxWidth()
                        .padding(16.dp)
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun ScrollToEndLazyColumnPreview() {
    LazyColumnRoot()
}
