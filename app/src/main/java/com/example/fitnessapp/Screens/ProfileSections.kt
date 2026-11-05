package com.example.fitnessapp.Screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CreditCard
import androidx.compose.material.icons.filled.History
import androidx.compose.material.icons.filled.NotificationsNone
import androidx.compose.material.icons.filled.PersonOutline
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.fitnessapp.R
import com.example.fitnessapp.navigation.Destination

// Личные данные
@Composable
fun PersonalDataScreen(
    onNavigate: (String) -> Unit = {},
    onBack: () -> Unit = {}
) {
    PageScaffold(
        title = stringResource(R.string.profile_personal_data),
        currentRoute = Destination.Profile.route,
        onNavigate = onNavigate,
        onBack = onBack
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 20.dp)
        ) {
            ProfileSectionHeader(
                icon = {
                    Icon(
                        imageVector = Icons.Default.PersonOutline,
                        contentDescription = null,
                        modifier = Modifier.size(48.dp),
                        tint = colorResource(R.color.primary)
                    )
                },
                title = stringResource(R.string.personal_data_header)
            )

            Spacer(modifier = Modifier.height(20.dp))

            ProfileInfoItem(
                title = stringResource(R.string.personal_data_name),
                value = stringResource(R.string.profile_name)
            )

            ProfileInfoItem(
                title = stringResource(R.string.personal_data_email),
                value = stringResource(R.string.profile_email)
            )

            ProfileInfoItem(
                title = stringResource(R.string.personal_data_phone),
                value = stringResource(R.string.personal_data_phone_empty)
            )
        }
    }
}

// Мои абонементы
@Composable
fun SubscriptionsScreen(
    onNavigate: (String) -> Unit = {},
    onBack: () -> Unit = {}
) {
    PageScaffold(
        title = stringResource(R.string.profile_subscriptions),
        currentRoute = Destination.Profile.route,
        onNavigate = onNavigate,
        onBack = onBack
    ) {
        ProfileEmptyState(
            icon = {
                Icon(
                    imageVector = Icons.Default.CreditCard,
                    contentDescription = null,
                    modifier = Modifier.size(64.dp),
                    tint = colorResource(R.color.primary)
                )
            },
            title = stringResource(R.string.subscriptions_empty_title),
            description = stringResource(R.string.subscriptions_empty_description)
        )
    }
}

// История посещений
@Composable
fun VisitHistoryScreen(
    onNavigate: (String) -> Unit = {},
    onBack: () -> Unit = {}
) {
    PageScaffold(
        title = stringResource(R.string.profile_visit_history),
        currentRoute = Destination.Profile.route,
        onNavigate = onNavigate,
        onBack = onBack
    ) {
        ProfileEmptyState(
            icon = {
                Icon(
                    imageVector = Icons.Default.History,
                    contentDescription = null,
                    modifier = Modifier.size(64.dp),
                    tint = colorResource(R.color.primary)
                )
            },
            title = stringResource(R.string.history_empty_title),
            description = stringResource(R.string.history_empty_description)
        )
    }
}

// Уведомления
@Composable
fun NotificationsScreen(
    onNavigate: (String) -> Unit = {},
    onBack: () -> Unit = {}
) {
    PageScaffold(
        title = stringResource(R.string.profile_notifications),
        currentRoute = Destination.Profile.route,
        onNavigate = onNavigate,
        onBack = onBack
    ) {
        ProfileEmptyState(
            icon = {
                Icon(
                    imageVector = Icons.Default.NotificationsNone,
                    contentDescription = null,
                    modifier = Modifier.size(64.dp),
                    tint = colorResource(R.color.primary)
                )
            },
            title = stringResource(R.string.notifications_empty_title),
            description = stringResource(R.string.notifications_empty_description)
        )
    }
}

// Заголовок раздела
@Composable
fun ProfileSectionHeader(
    icon: @Composable () -> Unit,
    title: String
) {
    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        icon()

        Spacer(modifier = Modifier.height(12.dp))

        Text(
            text = title,
            style = MaterialTheme.typography.titleLarge,
            color = colorResource(R.color.text_primary)
        )
    }
}

// Карточка личных данных
@Composable
fun ProfileInfoItem(
    title: String,
    value: String
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 6.dp),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(
            containerColor = colorResource(R.color.surface)
        ),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 1.dp
        )
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Text(
                text = title,
                style = MaterialTheme.typography.bodySmall,
                color = colorResource(R.color.text_secondary)
            )

            Spacer(modifier = Modifier.height(6.dp))

            Text(
                text = value,
                style = MaterialTheme.typography.bodyLarge,
                color = colorResource(R.color.text_primary)
            )
        }
    }
}

// Пустое состояние раздела
@Composable
fun ProfileEmptyState(
    icon: @Composable () -> Unit,
    title: String,
    description: String
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        icon()

        Spacer(modifier = Modifier.height(20.dp))

        Text(
            text = title,
            style = MaterialTheme.typography.titleLarge,
            color = colorResource(R.color.text_primary)
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = description,
            style = MaterialTheme.typography.bodyMedium,
            color = colorResource(R.color.text_secondary)
        )
    }
}