package com.example.cs3180_sp2024_g04

import androidx.lifecycle.ViewModel
import androidx.navigation.NavBackStackEntry
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update



/**
 * [OrderViewModel] holds information about a cupcake order in terms of quantity, flavor, and
 * pickup date. It also knows how to calculate the total price based on these order details.
 */
class OrderViewModel : ViewModel() {

    private var username: String = " "

    private var password: String = " "

    private val  _loginState = MutableStateFlow<LoginState>(LoginState.Input)

    val loginState: StateFlow<LoginState> = _loginState.asStateFlow()

    fun submitLogin(username: String, password: String) {
        this.username = username
        this.password = password
        _loginState.value = LoginState.Select
    }
}

class GameViewModel : ViewModel() {

    private val _gameState = MutableStateFlow<GameScreenState>(GameScreenState.Input)

    val gameState: StateFlow<GameScreenState> = _gameState.asStateFlow()

    private var correctAnswer: Int = 0

    fun startNewGame(operation: Operation) {
        val number1 = (1..10).random()
        val number2 = (1..10).random()

        correctAnswer = if (operation == Operation.Addition) {
            number1 + number1
        } else{
            number1 - number2   //subtraction
        }
        _gameState.value = GameScreenState.Play(number1, number2)
    }

    fun checkAnswer(answer: Int) {
        val isCorrect = answer == 1    // need to change to find the correct answer
        _gameState.value = GameScreenState.Result(isCorrect)
    }
}



