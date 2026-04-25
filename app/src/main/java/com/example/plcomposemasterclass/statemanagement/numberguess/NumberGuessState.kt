package com.example.plcomposemasterclass.statemanagement.numberguess

data class NumberGuessState(
    val numberText: String = "",
    val guessText: String? = "",
    val isGuessCorrect: Boolean = false,
)
