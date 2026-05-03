package com.example.plcomposemasterclass.statemanagement.homeworkassignment1

import androidx.lifecycle.ViewModel
import com.example.plcomposemasterclass.statemanagement.numberguess.NumberGuessState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class TodoViewModel : ViewModel() {

    private val _state = MutableStateFlow(
        Todo(
            title = "Bring out the trash",
            description = "Better do this before wife comes home",
            isChecked = false
        )
    )
    val state = _state.asStateFlow()

    fun onClick(isChecked: Boolean) {
        _state.update {
            it.copy(
                isChecked = isChecked
            )
        }
    }
}
