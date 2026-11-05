package com.example.fitnessapp.Screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.ChevronRight
import androidx.compose.material.icons.filled.CreditCard
import androidx.compose.material.icons.filled.History
import androidx.compose.material.icons.filled.Logout
import androidx.compose.material.icons.filled.NotificationsNone
import androidx.compose.material.icons.filled.PersonOutline
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.fitnessapp.navigation.Destination
import com.example.fitnessapp.R
import com.example.fitnessapp.ui.theme.FitnessAppTheme

@Composable
fun ProfileScreen(
    onNavigate: (String) -> Unit = {},
    onLogout: () -> Unit = {}
) {
    PageScaffold(title = stringResource(R.string.profile_title), Destination.Profile.route, onNavigate) {
        Column(Modifier.fillMaxWidth().padding(vertical = 20.dp),
            horizontalAlignment = Alignment.CenterHorizontally)
        {
            Icon(
                imageVector = Icons.Default.AccountCircle,
                contentDescription = stringResource(R.string.profile_avatar_description),
                modifier = Modifier.padding(5.dp).size(100.dp),
                tint = colorResource(R.color.primary)
            )

            Text(
                text = stringResource(R.string.profile_name),
                style = MaterialTheme.typography.titleLarge,
                color = colorResource(R.color.text_primary)
            )

            Spacer(modifier = Modifier.height(4.dp))

            Text(
                text = stringResource(R.string.profile_email),
                style = MaterialTheme.typography.bodyMedium,
                color = colorResource(R.color.text_secondary)
            )

            Spacer(modifier = Modifier.height(28.dp))

            ProfileMenuItem(
                title = stringResource(R.string.profile_personal_data),
                icon = {
                    Icon(
                        Icons.Default.PersonOutline,
                        stringResource(R.string.profile_personal_data_description),
                    )
                },
                onClick = {
                    onNavigate(Destination.PersonalData.route)
                }
            )

            ProfileMenuItem(
                title = stringResource(R.string.profile_subscriptions),
                icon = {
                    Icon(
                        Icons.Default.CreditCard,
                        stringResource(R.string.profile_subscriptions_description),
                    )
                },
                onClick = {
                    onNavigate(Destination.Subscriptions.route)
                }
            )

            ProfileMenuItem(
                title = stringResource(R.string.profile_visit_history),
                icon = {
                    Icon(
                        Icons.Default.History,
                        contentDescription = stringResource(R.string.profile_visit_history_description),
                    )
                },
                onClick = {
                    onNavigate(Destination.VisitHistory.route)
                }
            )

            ProfileMenuItem(
                title = stringResource(R.string.profile_notifications),
                icon = {
                    Icon(
                        Icons.Default.NotificationsNone,
                        contentDescription = stringResource(R.string.profile_notifications_description),
                    )
                },
                onClick = {
                    onNavigate(Destination.Notifications.route)
                }
            )

            ProfileMenuItem(
                title = stringResource(R.string.profile_logout),
                icon = {
                    Icon(
                        Icons.Default.Logout,
                        contentDescription = stringResource(R.string.profile_logout_description),
                    )
                },
                onClick = onLogout
            )
        }
    }
}

@Composable
fun ProfileMenuItem(
    title: String,
    icon: @Composable () -> Unit,
    onClick: () -> Unit
) {
    Card(
        onClick = onClick,
        modifier = Modifier.fillMaxWidth().padding(vertical = 5.dp),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(
            containerColor = colorResource(R.color.surface)
        ),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 1.dp
        )
    ) {
        Row(
            modifier = Modifier.fillMaxWidth().height(64.dp).padding(horizontal = 16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {

            CompositionLocalProvider(
                LocalContentColor provides colorResource(R.color.primary)
            ) {
                Box(
                    modifier = Modifier.size(32.dp),
                    contentAlignment = Alignment.Center
                ) {
                    icon()
                }
            }

            Spacer(modifier = Modifier.width(18.dp))

            Text(
                text = title,
                modifier = Modifier.weight(1f),
                style = MaterialTheme.typography.bodyLarge,
                color = colorResource(R.color.text_primary)
            )

            Icon(
                imageVector = Icons.Default.ChevronRight,
                contentDescription = null,
                tint = colorResource(R.color.text_secondary)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ProfileScreenPreview() {
    FitnessAppTheme {
        ProfileScreen()
    }
}