package com.example.cs3180_sp2024_g04
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

enum class CurrentScreen(){
    Login,
    Select,
    Addition,
    Subtraction
}

@Composable
fun MathApp(
    viewModel: OrderViewModel = viewModel(),
    navController: NavHostController = rememberNavController()
) {
    // Get current back stack entry
    val backStackEntry by navController.currentBackStackEntryAsState()
    // Get the name of the current screen
    val currentScreen = CurrentScreen.valueOf(
        backStackEntry?.destination?.route ?: CurrentScreen.Login.name
    )

    Scaffold(
    ) { innerPadding ->
        val uiState by viewModel.uiState.collectAsState()

        NavHost(
            navController = navController,
            startDestination = CurrentScreen.Login.name,
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(innerPadding)
        ) {
            composable(route = CurrentScreen.Select.name) {
                SelectOptionScreen(
                    onSubtractionButtonClicked = {
                        viewModel.setQuantity(it)
                        navController.navigate(CurrentScreen.Addition.name)
                    },
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(dimensionResource(R.dimen.padding_medium))
                )
            }
        }
    }
}
@Composable
fun SelectOptionScreen(
    onSelectionChanged: (String) -> Unit = {},
    onAdditionButtonClicked: () -> Unit = {},
    onSubtractionButtonClicked: () -> Unit = {},
    modifier: Modifier = Modifier
) {
    var selectedValue by rememberSaveable { mutableStateOf("") }

    Column(
        modifier = Modifier.fillMaxWidth(),
        //verticalArrangement = Arrangement.SpaceBetween


    ) {
        /*Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(dimensionResource(R.dimen.padding_medium)),
            horizontalArrangement = Arrangement.spacedBy(dimensionResource(R.dimen.padding_medium)),
            verticalAlignment = Alignment.Bottom
        )*/
            Button(
                enabled = selectedValue.isNotEmpty(),
                onClick = onAdditionButtonClicked,
                modifier = Modifier.weight(1f)
                    .width(200.dp)
                    .align(alignment = Alignment.CenterHorizontally)
                    .padding(horizontal = 10.dp, vertical = 70.dp)
            ) {
                Text(
                    text = "Addition",
                    fontSize = 30.sp,
                    color = Color.DarkGray,
                    textAlign = TextAlign.Center,
                    lineHeight = 2.5.em,
                    modifier = modifier.size(150.dp).padding(top = 27.dp))
            //Text(stringResource(R.string.cancel))
            }
            Button(
                // the button is enabled when the user makes a selection
                enabled = selectedValue.isNotEmpty(),
                onClick = onSubtractionButtonClicked,
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
                //Text(stringResource(R.string.next))
            }
        }



@Preview(showBackground = true, device = "id:Nexus One", showSystemUi = true)
@Composable
fun SelectOptionPreview() {
    CS3180_SP2024_G04Theme {
        SelectOptionScreen(
            modifier = Modifier.fillMaxHeight()
        )
    }
}
