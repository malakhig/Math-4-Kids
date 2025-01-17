package com.example.cs3180_sp2024_g04
import androidx.compose.foundation.background
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.cs3180_sp2024_g04.ui.theme.CS3180_SP2024_G04Theme

@Composable
fun SelectOptionScreen(
    onAdditionButtonClicked: () -> Unit = {},
    onSubtractionButtonClicked: () -> Unit = {},
    modifier: Modifier = Modifier,
    navigateToGameScreen: () -> Unit
) {
    var selectedValue by rememberSaveable { mutableStateOf("") }

    Column(
        modifier = Modifier.fillMaxWidth()
            .fillMaxSize()
            .background(color = MaterialTheme.colorScheme.primary)
        //verticalArrangement = Arrangement.SpaceBetween


    ) {
            Button(
                onClick = navigateToGameScreen,
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.LightGray),
                modifier = Modifier.weight(1f)
                    .width(200.dp)
                    .align(alignment = Alignment.CenterHorizontally)
                    .padding(horizontal = 10.dp, vertical = 70.dp)
            ) {
                Text(
                    text = "Addition\n" +
                            "+",
                    fontSize = 30.sp,
                    color = Color.DarkGray,
                    textAlign = TextAlign.Center,
                    lineHeight = 2.5.em,
                    modifier = modifier.size(150.dp).padding(top = 27.dp))
            }
            Button(
                onClick = onSubtractionButtonClicked,
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.LightGray),
                modifier = Modifier.weight(1f)
                    .width(200.dp)
                    .align(alignment = Alignment.CenterHorizontally)
                    .padding(horizontal = 10.dp, vertical = 70.dp)
            ) {
                Text(
                    text = "Subtraction",
                    fontSize = 25.sp,
                    color = Color.DarkGray,
                    textAlign = TextAlign.Center,
                    modifier = modifier.size(150.dp).padding(top = 30.dp))
            }
            }
        }




@Composable
fun SelectOptionPreview( navigateToGameScreen: () -> Unit) {
    CS3180_SP2024_G04Theme {
        SelectOptionScreen(
            modifier = Modifier.fillMaxHeight(),
            navigateToGameScreen = navigateToGameScreen
        )
    }
}
