package com.example.cs3180_sp2024_g04

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


@Composable
fun flashCard(modifier: Modifier = Modifier, operator: Boolean, operand1:Int, operand2:Int){
    Column (modifier = Modifier,
        horizontalAlignment = Alignment.End){
        Row(
            modifier = Modifier,
        )
        {
            Text(modifier = Modifier,
                text = operand1.toString()
            )
        }
        Row {

            Row() {
                if (operator) {
                    Text(text = "+")
                }
                else {
                    Text(text = "-")
                }

            }
            Spacer(Modifier.width(7.dp))

            Row() {
                Text(text = operand2.toString())

            }
        }


    }

}


@Preview(showBackground = true)
@Composable
fun gamePreview(){
    flashCard(operator = true, operand1 = 60, operand2 = 10)
}

