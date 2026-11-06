package com.example.fitnessapp.navigation

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CalendarMonth
import androidx.compose.material.icons.filled.Chat
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import com.example.fitnessapp.R


data class BottomNavItem(
    val route: String,
    @StringRes val label: Int,
    val icon: ImageVector
)

@Composable
fun BottomNavigationBar(currentRoute: String?, onNavigate: (String) -> Unit) {
    val items = listOf(
        BottomNavItem(
            route = Destination.Home.route,
            label = R.string.nav_home,
            icon = Icons.Default.Home
        ),
        BottomNavItem(
            route = Destination.Schedule.route,
            label = R.string.nav_schedule,
            icon = Icons.Default.CalendarMonth
        ),
        BottomNavItem(
            route = Destination.Chat.route,
            label = R.string.nav_chat,
            icon = Icons.Default.Chat
        ),
        BottomNavItem(
            route = Destination.Profile.route,
            label = R.string.nav_profile,
            icon = Icons.Default.Person
        )
    )

    NavigationBar(
        containerColor = MaterialTheme.colorScheme.surface
    ) {
        items.forEach { item ->
            NavigationBarItem(
                selected = currentRoute == item.route,
                onClick = { onNavigate(item.route) },
                icon = {
                    Icon(imageVector = item.icon,
                        contentDescription = stringResource(item.label))
                },
                label = { Text(text = stringResource(item.label)) },
                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = MaterialTheme.colorScheme.primary,
                    selectedTextColor = MaterialTheme.colorScheme.primary,
                    unselectedIconColor = MaterialTheme.colorScheme.onSurfaceVariant,
                    unselectedTextColor = MaterialTheme.colorScheme.onSurfaceVariant,
                    indicatorColor = MaterialTheme.colorScheme.secondaryContainer
                )
            )
        }
    }
}