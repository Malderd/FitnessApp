package com.example.fitnessapp.navigation

import android.widget.Toast
import androidx.activity.compose.BackHandler
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.navArgument
import com.example.fitnessapp.Screens.BookingScreen
import com.example.fitnessapp.Screens.ChatScreen
import com.example.fitnessapp.Screens.HomeScreen
import com.example.fitnessapp.Screens.LoginScreen
import com.example.fitnessapp.Screens.NotificationsScreen
import com.example.fitnessapp.Screens.PersonalDataScreen
import com.example.fitnessapp.Screens.ProfileScreen
import com.example.fitnessapp.Screens.RegisterScreen
import com.example.fitnessapp.Screens.ScheduleScreen
import com.example.fitnessapp.Screens.SubscriptionsScreen
import com.example.fitnessapp.Screens.VisitHistoryScreen
import com.example.fitnessapp.Screens.WelcomeScreen

@Composable
fun AppNavHost(navController: NavHostController) {
    val context = LocalContext.current

    val currentRoute = navController.currentBackStackEntryAsState()
        .value?.destination?.route

    BackHandler(
        enabled = currentRoute == Destination.Home.route ||
                currentRoute == Destination.Welcome.route
    ) {
        Toast.makeText(
            context,
            "Возврат назад невозможен",
            Toast.LENGTH_SHORT
        ).show()
    }

    NavHost(navController, startDestination = Destination.Welcome.route) {
        composable(Destination.Welcome.route) {
            WelcomeScreen(
                { navController.navigate(Destination.Login.route) },
                { navController.navigate(Destination.Register.route) })
        }
        composable(Destination.Login.route) {
            LoginScreen(
                onLoginSuccess = {
                    navController.navigate(Destination.Home.route) {
                        popUpTo(Destination.Welcome.route) {
                            inclusive = true
                        }
                        launchSingleTop = true
                    }
                },
                onRegister = {
                    navController.navigate(Destination.Register.route)
                }
            )
        }
        composable(Destination.Register.route) {
            RegisterScreen(
                { navController.popBackStack() },
                { navController.navigate(Destination.Login.route)})
        }

        composable(Destination.Home.route) {
            HomeScreen(
                { navController.navigate(
                        Destination.Booking.createRoute(it)
                    )
                },
                {
                    navController.navigate(it) {
                        launchSingleTop = true
                    }
                }
            )
        }

        composable(Destination.Schedule.route) {
            ScheduleScreen(
                { navController.navigate(
                    Destination.Booking.createRoute(it)
                    )
                },
                {
                    navController.navigate(it) {
                        launchSingleTop = true
                    }
                }
            )
        }

        composable(Destination.Booking.route, arguments = listOf(navArgument("trainingId") { type = NavType.IntType })) { entry ->
            BookingScreen(
                entry.arguments?.getInt("trainingId"),
                { navController.popBackStack() },
                {
                    navController.navigate(Destination.Schedule.route) { popUpTo(Destination.Home.route) }
                })
        }
       composable(Destination.Chat.route) {
           ChatScreen {
               navController.navigate(it) {
                   launchSingleTop = true
               }
           }
       }

       composable(Destination.Profile.route) {
           ProfileScreen(
               onNavigate = {
                   navController.navigate(it) {
                       launchSingleTop = true
                   }
               },
               onLogout = {
                   navController.navigate(Destination.Welcome.route) {
                       popUpTo(Destination.Home.route) {
                           inclusive = true
                       }
                       launchSingleTop = true
                   }
               }
           )
       }

        composable(Destination.PersonalData.route) {
            PersonalDataScreen(
                onNavigate = {
                    navController.navigate(it) {
                        launchSingleTop = true
                    }
                },
                onBack = { navController.popBackStack() }
            )
        }

        composable(Destination.Subscriptions.route) {
            SubscriptionsScreen(
                onNavigate = {
                    navController.navigate(it) {
                        launchSingleTop = true
                    }
                },
                onBack = { navController.popBackStack() }
            )
        }

        composable(Destination.VisitHistory.route) {
            VisitHistoryScreen(
                onNavigate = {
                    navController.navigate(it) {
                        launchSingleTop = true
                    }
                },
                onBack = { navController.popBackStack() }
            )
        }

        composable(Destination.Notifications.route) {
            NotificationsScreen(
                onNavigate = {
                    navController.navigate(it) {
                        launchSingleTop = true
                    }
                },
                onBack = { navController.popBackStack() }
            )
        }
    }
}