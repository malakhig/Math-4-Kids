package com.example.cs3180_sp2024_g04

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.cs3180_sp2024_g04.ui.theme.CS3180_SP2024_G04Theme

@Composable
fun ShowMathProblem (AddOrSub: Boolean = true, MaxValue: Int = 10) {
    var Op1 = getRandomNumber(MaxValue)
    var Op2 = getRandomNumber(MaxValue)
    flashCard(AddOrSub, Op1, Op2)
}


@Composable
fun getRandomNumber(MaxValue: Int = 10): Int {
    var randomValues = Math.random() % MaxValue
    var anInt = (randomValues).toInt()
    return anInt
}

@Preview(showBackground = true, device = "id:Nexus One", showSystemUi = true)
@Composable
fun GameScreenPreview() {
    CS3180_SP2024_G04Theme {
        ShowMathProblem(true, 10)
    }
}