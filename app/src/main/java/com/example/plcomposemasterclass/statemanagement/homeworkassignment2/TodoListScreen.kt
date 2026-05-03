package com.example.plcomposemasterclass.statemanagement.homeworkassignment2

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.plcomposemasterclass.statemanagement.homeworkassignment1.Todo
import com.example.plcomposemasterclass.ui.theme.PLComposeMasterclassTheme

@Composable
fun TodoListScreenRoot(
    viewModel: TodoListViewModel = viewModel(),
) {
    val state by viewModel.state.collectAsStateWithLifecycle()
    TodoListScreen(
        state = state,
        onAction = viewModel::onAction
    )
}

@Composable
fun TodoListScreen(
    state: TodoListState,
    onAction: (TodoListAction) -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxSize()
    ) {
        LazyColumn(
            contentPadding = PaddingValues(16.dp),
            modifier = Modifier
                .weight(1f)
        ) {
            items(state.todos) { todo ->
                TodoItem(
                    todo = todo,
                    onCheckedChange = { onAction(TodoListAction.OnToggleTodo(todo)) },
                    onDeleteClick = { onAction(TodoListAction.OnDeleteTodoClick(todo)) },
                    modifier = Modifier.fillMaxWidth()
                )
            }
        }
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .padding(16.dp)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f),
            ) {
                TextField(
                    value = state.newTodoTitle,
                    onValueChange = { onAction(TodoListAction.OnTitleChange(it)) },
                    modifier = Modifier
                        .fillMaxWidth(),
                    placeholder = {
                        Text(
                            text = "Title"
                        )
                    }
                )

                Spacer(modifier = Modifier.height(16.dp))

                TextField(
                    value = state.newTodoDescription,
                    onValueChange = { onAction(TodoListAction.OnDescriptionChange(it)) },
                    modifier = Modifier
                        .fillMaxWidth(),
                    placeholder = {
                        Text(
                            text = "Description"
                        )
                    }
                )
            }
            Spacer(
                modifier = Modifier
                    .width(16.dp)
            )
            Button(
                onClick = { onAction(TodoListAction.OnAddTodoClick) }
            ) {
                Text(
                    text = "Add"
                )
            }
        }
    }
}

@Composable
fun TodoItem(
    todo: Todo,
    onCheckedChange: (Boolean) -> Unit,
    onDeleteClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .padding(16.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column(
            modifier = Modifier
                .weight(1f)
        ) {
            Text(
                text = todo.title,
                fontWeight = FontWeight.Bold,
                textDecoration = if (todo.isChecked) {
                    TextDecoration.LineThrough
                } else TextDecoration.None
            )
            Spacer(Modifier.height(4.dp))
            Text(
                text = todo.description,
                textDecoration = if (todo.isChecked) {
                    TextDecoration.LineThrough
                } else TextDecoration.None
            )
        }
        IconButton(
            onClick = onDeleteClick
        ) {
            Icon(
                imageVector = Icons.Default.Delete,
                contentDescription = "Delete"
            )
        }
        Checkbox(
            checked = todo.isChecked,
            onCheckedChange = onCheckedChange
        )
    }
}

@Preview(
    showBackground = true
)
@Composable
private fun TodoItemPreview() {
    PLComposeMasterclassTheme {
        TodoListScreenRoot()
    }
}