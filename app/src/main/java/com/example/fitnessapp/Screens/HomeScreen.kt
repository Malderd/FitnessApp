package com.example.fitnessapp.Screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.fitnessapp.navigation.Destination
import com.example.fitnessapp.ui.theme.FitnessAppTheme
import com.example.fitnessapp.R
import com.example.fitnessapp.ui.theme.HomeGreetingStyle
import com.example.fitnessapp.ui.theme.HomeSectionTitleStyle
import com.example.fitnessapp.ui.theme.HomeSubtitleStyle
import com.example.fitnessapp.ui.theme.HomeTitleStyle


@Composable
fun HomeScreen(
    onTrainingClick: (Int) -> Unit = {},
    onNavigate: (String) -> Unit = {}
) {
    PageScaffold(currentRoute = Destination.Home.route, onNavigate = onNavigate) {
        Text(
            text = stringResource(R.string.home_greeting),
            style = HomeGreetingStyle,
            color = MaterialTheme.colorScheme.onBackground,
            modifier = Modifier.padding(top = 25.dp)
        )

        Card(Modifier
            .fillMaxWidth()
            .padding(top = 18.dp),
            shape = RoundedCornerShape(18.dp),
            colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.primary)
        ) {
            Column(Modifier.padding(20.dp)) {
                Text(
                    text = stringResource(R.string.home_promo_title),
                    style = HomeTitleStyle,
                    color = MaterialTheme.colorScheme.onPrimary
                )

                Spacer(modifier = Modifier.height(5.dp))

                Text(
                    text = stringResource(R.string.home_promo_subtitle),
                    style = HomeSubtitleStyle,
                    color = MaterialTheme.colorScheme.onPrimary
                )
            }
        }

        Row(Modifier.fillMaxWidth()
            .padding(top = 18.dp, bottom = 10.dp), verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = stringResource(R.string.home_upcoming_trainings),
                style = HomeSectionTitleStyle,
                color = MaterialTheme.colorScheme.onBackground
            )
        }
        TrainingCard(
            title = stringResource(R.string.training_strength),
            time = stringResource(R.string.training_strength_time),
            room = stringResource(R.string.training_strength_room),
            image = painterResource(R.drawable.strength_training),
            onClick = {
                onTrainingClick(1)
            }
        )

        // Вторая тренировка
        TrainingCard(
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

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    FitnessAppTheme {
        HomeScreen()
    }
}