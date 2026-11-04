package com.example.fitnessapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.fitnessapp.Screens.BookingScreen
import com.example.fitnessapp.Screens.ChatScreen
import com.example.fitnessapp.Screens.HomeScreen
import com.example.fitnessapp.Screens.LoginScreen
import com.example.fitnessapp.Screens.ProfileScreen
import com.example.fitnessapp.Screens.RegisterScreen
import com.example.fitnessapp.Screens.ScheduleScreen
import com.example.fitnessapp.Screens.WelcomeScreen

@Composable
fun AppNavHost(navController: NavHostController) {
    NavHost(navController, startDestination = Destination.Welcome.route) {
        composable(Destination.Welcome.route) {
            WelcomeScreen(
                { navController.navigate(Destination.Login.route) },
                { navController.navigate(Destination.Register.route) })
        }
        composable(Destination.Login.route) {
            LoginScreen(
                { navController.popBackStack() },
                { navController.navigate(Destination.Home.route) {
                    popUpTo(Destination.Welcome.route) {
                        inclusive = true
                    }
                }
            }, { navController.navigate(Destination.Register.route) })
        }
        composable(Destination.Register.route) {
            RegisterScreen(
                { navController.popBackStack() },
                { navController.navigate(Destination.Login.route)})
        }
//        composable(Destination.Home.route) {
//            HomeScreen(
//                { navController.navigate(Destination.Booking.createRoute(1)) },
//                { navController.navigate(Destination.Schedule.route) },
//                { navController.goTopLevel(it) })
//        }
//        composable(Destination.Schedule.route) {
//            ScheduleScreen(
//                { navController.navigate(Destination.Booking.createRoute(it)) },
//                { navController.goTopLevel(it) })
//        }
//        composable(Destination.Booking.route, arguments = listOf(navArgument("trainingId") { type = NavType.IntType })) { entry ->
//            BookingScreen(
//                entry.arguments?.getInt("trainingId") ?: 1,
//                { navController.popBackStack() },
//                {
//                    navController.navigate(Destination.Schedule.route) { popUpTo(Destination.Home.route) }
//                })
//        }
//        composable(Destination.Chat.route) { ChatScreen { navController.goTopLevel(it) } }
//        composable(Destination.Profile.route) { ProfileScreen { navController.goTopLevel(it) } }
    }
}
private fun NavHostController.goTopLevel(route: String) {
    navigate(route) {
        popUpTo(Destination.Home.route) { saveState = true }
        launchSingleTop = true
        restoreState = true
    }
}