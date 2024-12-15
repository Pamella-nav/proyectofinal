package com.example.morsecodeconverter

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import com.example.morsecodeconverter.ui.theme.MorsecodeconverterTheme
import com.example.morsecodeconverter.MorseConverter
import androidx.compose.ui.unit.sp  // Importa esto para ajustar el tamaño

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MorsecodeconverterTheme {
                MorseConverterApp()
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MorseConverterApp() {
    var inputText by remember { mutableStateOf("") }
    var resultText by remember { mutableStateOf("") }

    Scaffold(
        topBar = {
            TopAppBar(title = { Text("Conversor Morse") })
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .padding(16.dp)
                .fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Text("Introduce texto o código Morse:")

            BasicTextField(
                value = inputText,
                onValueChange = { inputText = it },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
            )

            Row(
                horizontalArrangement = Arrangement.SpaceEvenly,
                modifier = Modifier.fillMaxWidth()
            ) {
                Button(onClick = {
                    resultText = MorseConverter.convertirTextoAMorse(inputText)
                }) {
                    Text("Texto a Morse")
                }

                Button(onClick = {
                    resultText = MorseConverter.convertirMorseATexto(inputText)
                }) {
                    Text("Morse a Texto")
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = resultText,
                fontSize = 32.sp,  // Tamaño grande
                modifier = Modifier.padding(8.dp)
            )

        }
    }
}

