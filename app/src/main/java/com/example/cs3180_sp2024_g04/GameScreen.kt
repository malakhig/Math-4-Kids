package com.example.cs3180_sp2024_g04

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.foundation.layout.Column
//import androidx.compose.foundation.layout.FlowRowScopeInstance.align
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.cs3180_sp2024_g04.ui.theme.CS3180_SP2024_G04Theme
import kotlin.random.Random




@Composable
fun flashCard(modifier: Modifier = Modifier, operator: Boolean, operand1:Int, operand2:Int){

    Column(modifier = Modifier
        .fillMaxWidth()
        .padding(50.dp),
        horizontalAlignment = Alignment.End) {
        Row(modifier = Modifier,) {
            Text(modifier = Modifier,text = operand1.toString(), fontSize = 50.sp
            )
        }
        Row {
            Row() {
                if (operator) {
                    Text(text = "+", fontSize = 50.sp)
                } else {
                    Text(text = "-", fontSize = 50.sp)
                }
            }
            Spacer(Modifier.width(20.dp))
            Row() {
                Text(text = operand2.toString(), fontSize = 50.sp)
            }
        }
    }
}




@Composable
fun gamePreview(navigateBack: () -> Unit){
    CS3180_SP2024_G04Theme {
        ShowMathProblem(value = "Answer", onChange = {}, navigateBack = navigateBack)
    }

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ShowMathProblem (
    AddOrSub: Boolean = true,
    MaxValue: Int = 10,
    value: String = "",
    onChange: (String) -> Unit = {},
    navigateBack: () -> Unit
) {
    var Op1 by remember{mutableStateOf(getRandomNumber())}
    var Op2 by remember{mutableStateOf(getRandomNumber())}
    var text by remember { mutableStateOf("") }
    var myVal by remember { mutableStateOf("") }
    var isCorrect by remember { mutableStateOf(true) } // Track whether the answer is correct
    var text2 by remember { mutableStateOf("") }
    var next by remember { mutableStateOf(false) }


    Button(onClick = navigateBack ) {
        Text("Exit")
    }

    Column(modifier = Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally ) {
        flashCard(Modifier, AddOrSub, Op1, Op2)

        Row(
            modifier = Modifier.padding(vertical = 16.dp),
            horizontalArrangement = Arrangement.Center
        ){
            OutlinedTextField(
                modifier = Modifier.fillMaxWidth(0.8f),
                value = text,
                onValueChange = { text = it},
                label = { Text("Answer") },
                colors = if (isCorrect) TextFieldDefaults.outlinedTextFieldColors() else TextFieldDefaults.outlinedTextFieldColors(
                    unfocusedBorderColor = Color.Red,
                    focusedBorderColor = Color.Red
                )
            )
        }
        Text(text = text2,
            style = if (!isCorrect) TextStyle(color = Color.Red) else TextStyle.Default,
            )

        Button(onClick = {
            if (text.isNotEmpty()) {
                try {
                    myVal = text
                    isCorrect = checkRandomAnswer(Op1, Op2, myVal.toInt())
                    if (isCorrect) {
                        text2 = "Correct!"
                        next = true
                    } else {
                        text2 = "Wrong. Try Again"
                    }
                } catch (e: NumberFormatException) {
                    var invalidInput = true
                    text2 = "Invalid input. Please enter a valid integer."
                }
            } else {
                text2= "Enter a number."
            }
        }) {
            Text(text = "Check")
        }

        Button(
            onClick = {
                Op1 = getRandomNumber(MaxValue)
                Op2 = getRandomNumber(MaxValue)
                text = ""
                isCorrect = true
                next = false
            },
            enabled = next,
            modifier = Modifier.padding(vertical = 16.dp)
        ) {
            Text("Next")
        }
    }
}




fun getRandomNumber(MaxValue: Int = 10): Int {
    return Random.nextInt(0, 10)
}

fun checkRandomAnswer(x: Int, y: Int, answer:Int ): Boolean {
    val check = x + y
    return check == answer.toInt()
}

