package com.example.plcomposemasterclass.statemanagement.numberguess

sealed interface NumberGuessAction {
    data object OnGuessClick : NumberGuessAction
    data class OnNumberTextChange(val numberText: String) : NumberGuessAction
    data object OnStartNewGameButton : NumberGuessAction
}
