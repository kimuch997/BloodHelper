package com.example.bloodhelper.navigation

import com.example.bloodhelper.R

sealed class Screen(
    val route: String
) {
    object Splash : Screen("splash_screen")
}

sealed class BottomBar(
    val route: String,
    val title: String,
    val icon: Int,
    val icon_focused: Int
) {



    // for Home
    object Home: BottomBar(
        route = "home",
        title = "Home",
        icon = R.drawable.baseline_home_24,
        icon_focused = R.drawable.baseline_home_24
    )

    // for Donor
    object Donor: BottomBar(
        route = "donor",
        title = "Find My Donor",
        icon = R.drawable.baseline_blooddonor_24,
        icon_focused = R.drawable.baseline_blooddonor_24
    )
    // for receiver
    object Receiver: BottomBar(
        route = "receiver",
        title = "My Donors",
        icon = R.drawable.twotone_supervised_user_circle_24,
        icon_focused = R.drawable.twotone_supervised_user_circle_24
    )
    object Logout: BottomBar(
        route = "logout",
        title = "Logout",
        icon = R.drawable.baseline_logout_24,
        icon_focused = R.drawable.baseline_logout_24
    )

}

