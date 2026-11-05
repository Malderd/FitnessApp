package com.example.fitnessapp.navigation

sealed class Destination(val route: String) {
    data object Welcome : Destination("welcome")
    data object Login : Destination("login")
    data object Register : Destination("register")
    data object Home : Destination("home")
    data object Schedule : Destination("schedule")
    data object Booking : Destination("booking/{trainingId}") {
        fun createRoute(id: Int) = "booking/$id"
    }
    data object Chat : Destination("chat")
    data object Profile : Destination("profile")
    data object PersonalData : Destination("personal_data")
    data object Subscriptions : Destination("subscriptions")
    data object VisitHistory : Destination("visit_history")
    data object Notifications : Destination("notifications")
}