package com.example.plcomposemasterclass.statemanagement.homeworkassignment1

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Text
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
import com.example.plcomposemasterclass.ui.theme.PLComposeMasterclassTheme


@Composable
fun TodoScreenRoot(
    modifier: Modifier = Modifier
) {
    val viewModel = viewModel<TodoViewModel>()
    val state by viewModel.state.collectAsStateWithLifecycle()

    TodoScreen(
        modifier = modifier,
        state = state,
        onClick = viewModel::onClick,
    )
}

@Composable
fun TodoScreen(
    modifier: Modifier = Modifier,
    state: Todo,
    onClick: (Boolean) -> Unit
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
                text = state.title,
                textDecoration = if (state.isChecked) {
                    TextDecoration.LineThrough
                } else {
                    TextDecoration.None
                },
                fontWeight = FontWeight.Bold
            )

            Spacer(Modifier.height(4.dp))

            Text(
                text = state.description,
                textDecoration = if (state.isChecked) {
                    TextDecoration.LineThrough
                } else {
                    TextDecoration.None
                },
            )
        }

        Checkbox(
            checked = state.isChecked,
            onCheckedChange = onClick
        )
    }
}

@Preview(
    showBackground = true
)
@Composable
private fun TodoScreenPreview() {
    PLComposeMasterclassTheme {
        TodoScreen(
            state = Todo(
                title = "Bring out the trash",
                description = "Better do this before wife comes home.",
                isChecked = false
            ),
            onClick = {}
        )
    }
}
