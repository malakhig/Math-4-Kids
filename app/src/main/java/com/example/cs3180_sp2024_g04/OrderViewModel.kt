package com.example.cs3180_sp2024_g04

import androidx.lifecycle.ViewModel
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavHostController
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update


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

    fun cancelAndNavigateToSelectScreen(
        navController: NavHostController
    ) {
        navController.popBackStack(LoginScreen.Login.name, inclusive = false)
    }

    fun navigateToGame() {
        _loginState.value = LoginState.Game
    }
}

class GameViewModel : ViewModel() {

    data class Flashcard(
        val question: String,
        val answer: Int
    )

    private val _gameState = MutableStateFlow<GameScreenState>(GameScreenState.Input)
    val gameState: StateFlow<GameScreenState> = _gameState.asStateFlow()

    private val flashcards: List<Flashcard> = listOf(
        Flashcard("2 + 2", 4),
        Flashcard("5 - 3", 2)
        //more flashcards here
    )

    private var currentFlashcardIndex: Int = 0

    fun startNewGame() {
        currentFlashcardIndex = 0
        showNextFlashcard()
    }

     private fun showNextFlashcard() {
         if (currentFlashcardIndex < flashcards.size) {
             val flashcard = flashcards[currentFlashcardIndex]
             _gameState.value = GameScreenState.Play(flashcard.question, flashcard.answer)
         } else {
             _gameState.value = GameScreenState.GameOver
         }
     }


    fun checkAnswer(answer: Int) {
        val currentFlashcard = flashcards[currentFlashcardIndex]
        val isCorrect = answer == currentFlashcard.answer
        _gameState.value = GameScreenState.Result(isCorrect)
    }

    fun moveToNextFlashcard() {
        currentFlashcardIndex++
        showNextFlashcard()
    }
}



