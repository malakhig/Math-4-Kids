package com.example.cs3180_sp2024_g04


sealed class LoginState {
    object Input : LoginState()
    object Select : LoginState()
}


enum class Operation {
    Addition,
    Subtraction
}


sealed class GameScreenState {
    object Input : GameScreenState()
    data class Play(val number1: Int, val number2: Int) : GameScreenState()
    data class Result(val isCorrect: Boolean) : GameScreenState()
}