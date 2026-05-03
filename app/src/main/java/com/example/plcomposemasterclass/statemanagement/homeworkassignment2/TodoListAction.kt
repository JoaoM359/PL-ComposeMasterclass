package com.example.plcomposemasterclass.statemanagement.homeworkassignment2

import com.example.plcomposemasterclass.statemanagement.homeworkassignment1.Todo

sealed interface TodoListAction {
    data object OnAddTodoClick : TodoListAction
    data class OnDeleteTodoClick(val todo: Todo) : TodoListAction
    data class OnToggleTodo(val todo: Todo) : TodoListAction
    data class OnTitleChange(val title: String) : TodoListAction
    data class OnDescriptionChange(val description: String) : TodoListAction
}
