package com.example.cs3180_sp2024_g04


sealed class LoginState {
    data object Input : LoginState()
    data object Select : LoginState()
    data object Game : LoginState()
}


enum class Operation {
    Addition,
    Subtraction
}


sealed class GameScreenState {
    data object Input : GameScreenState()
    data class Play(val question: String, val answer: Int) : GameScreenState()
    data class Result(val isCorrect: Boolean) : GameScreenState()
    data object GameOver : GameScreenState()
}