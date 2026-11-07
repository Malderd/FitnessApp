
package com.example.fitnessapp.Screens

import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Place
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.fitnessapp.R
import com.example.fitnessapp.ui.theme.FitnessAppTheme

data class TrainingInfo(
    val id: Int,
    @StringRes val title: Int,
    val image: Int,
    @StringRes val time: Int,
    @StringRes val room: Int,
    @StringRes val trainer: Int,
    @StringRes val description: Int
)

private val trainings = listOf(
    TrainingInfo(
        id = 1,
        title = R.string.training_strength,
        image = R.drawable.strength_training,
        time = R.string.training_strength_time,
        room = R.string.booking_strength_room,
        trainer = R.string.training_strength_trainer,
        description = R.string.training_strength_description
    ),
    TrainingInfo(
        id = 2,
        title = R.string.training_yoga,
        image = R.drawable.yoga,
        time = R.string.training_yoga_time,
        room = R.string.booking_yoga_room,
        trainer = R.string.training_yoga_trainer,
        description = R.string.training_yoga_description
    )
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BookingScreen(
    trainingId: Int? = null,
    onBack: () -> Unit = {},
    onBooked: () -> Unit = {}
) {
    val training = trainings.find {
        it.id == trainingId
    } ?: trainings.last()

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = stringResource(training.title),
                        style = MaterialTheme.typography.titleLarge
                    )
                },
                navigationIcon = {
                    IconButton(onClick = onBack) {
                        Icon(
                            imageVector = Icons.Default.ArrowBack,
                            contentDescription = stringResource(R.string.back)
                        )
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.background,
                    titleContentColor = MaterialTheme.colorScheme.onBackground,
                    navigationIconContentColor = MaterialTheme.colorScheme.onBackground
                )
            )
        },
        bottomBar = {
            Surface(
                color = MaterialTheme.colorScheme.background,
                shadowElevation = 8.dp
            ) {
                Button(
                    onClick = onBooked,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(
                            horizontal = 18.dp,
                            vertical = 12.dp
                        )
                        .height(52.dp),
                    shape = RoundedCornerShape(14.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = MaterialTheme.colorScheme.primary,
                        contentColor = MaterialTheme.colorScheme.onPrimary
                    )
                ) {
                    Text(
                        text = stringResource(R.string.booking_button),
                        style = MaterialTheme.typography.titleMedium
                    )
                }
            }
        },
        containerColor = MaterialTheme.colorScheme.background
    ) { paddingValues ->

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .verticalScroll(rememberScrollState())
                .padding(horizontal = 20.dp, vertical = 18.dp)
        ) {
            Image(
                painter = painterResource(training.image),
                contentDescription = stringResource(training.title),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(190.dp)
                    .clip(RoundedCornerShape(18.dp)),
                contentScale = ContentScale.Crop
            )

            Spacer(modifier = Modifier.height(22.dp))

            TrainingInfoRow(
                icon = {
                    Icon(imageVector = Icons.Default.DateRange,
                        contentDescription = null,
                        tint = MaterialTheme.colorScheme.primary
                    )
                },
                text = stringResource(training.time)
            )

            Spacer(modifier = Modifier.height(8.dp))

            TrainingInfoRow(
                icon = {
                    Icon(imageVector = Icons.Default.Place, contentDescription = null,
                        tint = MaterialTheme.colorScheme.primary
                    )
                },
                text = stringResource(training.room)
            )

            Spacer(modifier = Modifier.height(8.dp))

            TrainingInfoRow(
                icon = {
                    Icon(imageVector = Icons.Default.Person, contentDescription = null,
                        tint = MaterialTheme.colorScheme.primary
                    )
                },
                text = stringResource(
                    R.string.booking_trainer_prefix,
                    stringResource(training.trainer)
                )
            )

            Spacer(modifier = Modifier.height(22.dp))

            Text(
                text = stringResource(R.string.booking_description),
                style = MaterialTheme.typography.titleLarge,
                color = MaterialTheme.colorScheme.onBackground
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = stringResource(training.description),
                style = MaterialTheme.typography.bodyLarge,
                color = MaterialTheme.colorScheme.onBackground
            )

            Spacer(modifier = Modifier.height(16.dp))
        }
    }
}

@Composable
fun TrainingInfoRow(
    icon: @Composable () -> Unit,
    text: String
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(
            modifier = Modifier.size(48.dp),
            contentAlignment = Alignment.Center
        ) {
            icon()
        }

        Spacer(modifier = Modifier.width(12.dp))

        Text(
            text = text,
            style = MaterialTheme.typography.bodyLarge,
            color = MaterialTheme.colorScheme.onBackground
        )
    }
}

@Preview(showBackground = true)
@Composable
fun BookingScreenPreview() {
    FitnessAppTheme {
        BookingScreen()
    }
}
