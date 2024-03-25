package com.example.cs3180_sp2024_g04

import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


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



@Preview(showBackground = true, device = "id:Nexus One", showSystemUi = true)
@Composable
fun gamePreview(){
    ShowMathProblem()
}

@Composable
fun ShowMathProblem (AddOrSub: Boolean = true, MaxValue: Int = 10) {
    var Op1 by remember{mutableStateOf(0)}
    var Op2 by remember{mutableStateOf(0)}


    Column(modifier = Modifier, horizontalAlignment = Alignment.CenterHorizontally ) {
        flashCard(Modifier, AddOrSub, Op1, Op2)

        Button(onClick = {
            Op1 = getRandomNumber(MaxValue)
            Op2 = getRandomNumber(MaxValue)}) {
            Text("Next")

        }
    }
}


fun getRandomNumber(MaxValue: Int = 10): Int {
    var randomValues = Math.random() % MaxValue
    var anInt = (randomValues).toInt()
    return anInt
}

