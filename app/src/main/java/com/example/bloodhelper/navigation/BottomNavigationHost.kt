package com.example.bloodhelper.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.bloodhelper.ui.theme.pages.animatedSplashScreen.AnimatedSplashScreen
import com.example.bloodhelper.ui.theme.pages.donor.FindMyDonorScreen
import com.example.bloodhelper.ui.theme.pages.home.HomeScreen
import com.example.bloodhelper.ui.theme.pages.login.LoginScreen
import com.example.bloodhelper.ui.theme.pages.receiver.MyDonorScreen
import com.example.bloodhelper.ui.theme.pages.signup.SignUpScreen

@Composable
fun BottomNavigation(navController: NavHostController){
    NavHost(
        navController = navController,
        startDestination = Screen.Splash.route
    ) {
        composable(route = Screen.Splash.route) {
            AnimatedSplashScreen(navController = navController)
        }
        composable(route = BottomBar.Home.route)
        {
            HomeScreen()
        }
        composable(route = BottomBar.Receiver.route)
        {
            MyDonorScreen()
        }
        composable(route = BottomBar.Donor.route)
        {
            FindMyDonorScreen()
        }
        composable(route = ROUTE_HOME){
            HomeScreen()
        }
        composable(route = ROUTE_LOGIN_PAGE){
            LoginScreen()
        }
        composable(route= ROUTE_SIGNUP_PAGE){
            SignUpScreen(navController)
        }
    }


}