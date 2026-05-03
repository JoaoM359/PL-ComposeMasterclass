package com.example.plcomposemasterclass.statemanagement.homeworkassignment2

import com.example.plcomposemasterclass.statemanagement.homeworkassignment1.Todo

data class TodoListState(
    val todos: List<Todo> = (1..15).map {
        Todo(
            title = "Todo item $it",
            description = "Todo description $it",
            isChecked = false
        )
    },
    val newTodoTitle: String = "",
    val newTodoDescription: String = "",
)
