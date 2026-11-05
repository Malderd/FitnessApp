package com.example.fitnessapp.Screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.fitnessapp.navigation.Destination
import com.example.fitnessapp.ui.theme.FitnessAppTheme
import com.example.fitnessapp.R

@Composable
fun ChatScreen(
    onNavigate: (String) -> Unit = {}
) {
    var message by remember { mutableStateOf("") }
    val messages = remember { mutableStateListOf("Привет! Я — фитнес-помощник FitLife. Чем могу помочь?", "Какая тренировка подойдёт новичку?", "Для начала рекомендую йогу, пилатес или лёгкие функциональные тренировки.") }
    PageScaffold(stringResource(R.string.chat_title), Destination.Chat.route, onNavigate) {
        LazyColumn(Modifier.weight(1f).fillMaxWidth(), verticalArrangement = Arrangement.spacedBy(10.dp)) {
            items(messages) { text -> Surface(color = colorResource(R.color.surface), shape = MaterialTheme.shapes.large) { Text(text, Modifier.padding(12.dp)) } }
        }
        Row(Modifier.fillMaxWidth().padding(vertical = 8.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            OutlinedTextField(message, { message = it },
                Modifier.weight(1f),
                placeholder =
                    {
                        Text(stringResource(R.string.chat_input_hint))
                    },
                singleLine = true)

            Button(onClick = {
            }) {
                Text(stringResource(R.string.chat_send_button))
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ChatScreenPreview() {
    FitnessAppTheme {
        ChatScreen()
    }
}