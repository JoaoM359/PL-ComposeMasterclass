package com.example.plcomposemasterclass.statemanagement.homeworkassignment2

import androidx.lifecycle.ViewModel
import com.example.plcomposemasterclass.statemanagement.homeworkassignment1.Todo
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class TodoListViewModel : ViewModel() {

    private val _state = MutableStateFlow(TodoListState())
    val state = _state.asStateFlow()

    fun onAction(action: TodoListAction) {
        when (action) {
            TodoListAction.OnAddTodoClick -> {
                val title = state.value.newTodoTitle
                val description = state.value.newTodoDescription
                if (title.isNotBlank()) {
                    val newTodo = Todo(
                        title = title.trim(),
                        description = description.trim(),
                        isChecked = false
                    )
                    _state.update {
                        it.copy(
                            todos = it.todos + newTodo,
                            newTodoTitle = "",
                            newTodoDescription = ""
                        )
                    }
                }
            }

            is TodoListAction.OnDeleteTodoClick -> {
                _state.update { todoListState ->
                    todoListState.copy(
                        todos = todoListState.todos.filter { it != action.todo }
                    )
                }
            }

            is TodoListAction.OnDescriptionChange -> {
                _state.update {
                    it.copy(
                        newTodoDescription = action.description
                    )
                }
            }

            is TodoListAction.OnTitleChange -> {
                _state.update {
                    it.copy(
                        newTodoTitle = action.title
                    )
                }
            }

            is TodoListAction.OnToggleTodo -> {
                _state.update { todoListState ->
                    todoListState.copy(
                        todos = todoListState.todos.map { todo ->
                            if (todo == action.todo) {
                                todo.copy(isChecked = !todo.isChecked)
                            } else todo
                        }
                    )
                }
            }
        }
    }
}