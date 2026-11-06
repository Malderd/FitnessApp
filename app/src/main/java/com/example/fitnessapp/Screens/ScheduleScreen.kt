package com.example.fitnessapp.Screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.fitnessapp.R
import com.example.fitnessapp.navigation.Destination
import com.example.fitnessapp.ui.theme.FitnessAppTheme
import com.example.fitnessapp.ui.theme.ScheduleDayStyle
import androidx.compose.foundation.lazy.items
import com.example.fitnessapp.ui.theme.ScheduleDateTitleStyle

data class ScheduleDay(
    val label: String,
    val fullDate: String,
    val trainingIds: List<Int>
)

@Composable
fun ScheduleScreen(
    onTrainingClick: (Int) -> Unit = {},
    onNavigate: (String) -> Unit = {}
) {
    var selected by rememberSaveable { mutableIntStateOf(0) }

    val days = listOf(
        ScheduleDay("Пн 3.11", "3 ноября", listOf(1,2)),
        ScheduleDay("Вт 4.11", "4 ноября", listOf(2)),
        ScheduleDay("Ср 5.11", "5 ноября", listOf(1)),
        ScheduleDay("Чт 6.11", "6 ноября", listOf(1,2)),
        ScheduleDay("Пт 7.11", "7 ноября", listOf(2))
    )

    val currentDay = days[selected]

    PageScaffold(stringResource(R.string.schedule_title), Destination.Schedule.route, onNavigate) {
        LazyRow(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(3.dp),
            contentPadding = PaddingValues(
                horizontal = 2.dp,
                vertical = 8.dp
            )
        ) {
            items(days.size) { index ->
                val day = days[index]
                val isSelected = selected == index

                Surface(
                    modifier = Modifier
                        .width(90.dp)
                        .height(48.dp)
                        .clickable {
                            selected = index
                        },
                    shape = RoundedCornerShape(14.dp),
                    color = if (isSelected) {
                        MaterialTheme.colorScheme.primary
                    } else {
                        MaterialTheme.colorScheme.surface
                    },
                    shadowElevation = if (isSelected) 3.dp else 0.dp
                ) {
                    Box(
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = day.label,
                            style = ScheduleDayStyle,
                            color = if (isSelected) {
                                MaterialTheme.colorScheme.onPrimary
                            } else {
                                MaterialTheme.colorScheme.onSurface
                            }
                        )
                    }
                }
            }
        }

        Spacer(modifier = Modifier.height(20.dp))

        Text(
            text = stringResource(
                R.string.schedule_trainings,
                currentDay.fullDate
            ),
            style = ScheduleDateTitleStyle,
            color = MaterialTheme.colorScheme.onBackground
        )

        Spacer(modifier = Modifier.height(16.dp))

        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f),
            verticalArrangement = Arrangement.spacedBy(14.dp),
            contentPadding = PaddingValues(bottom = 16.dp)
        ) {
            items(currentDay.trainingIds) { trainingId ->

                when (trainingId) {

                    1 -> TrainingCard(
                        title = stringResource(R.string.training_strength),
                        time = stringResource(R.string.training_strength_time),
                        room = stringResource(R.string.training_strength_room),
                        image = painterResource(R.drawable.strength_training),
                        onClick = {
                            onTrainingClick(1)
                        }
                    )

                    2 -> TrainingCard(
                        title = stringResource(R.string.training_yoga),
                        time = stringResource(R.string.training_yoga_time),
                        room = stringResource(R.string.training_yoga_room),
                        image = painterResource(R.drawable.yoga),
                        onClick = {
                            onTrainingClick(2)
                        }
                    )
                }
            }
        }

    }
}

@Preview(showBackground = true)
@Composable
fun ScheduleScreenPreview() {
    FitnessAppTheme {
        ScheduleScreen()
    }
}