package dev.eamoretti.appue.presentation.navigation

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import dev.eamoretti.appue.presentation.auth.LoginScreen
import dev.eamoretti.appue.presentation.auth.RegisterScreen
import dev.eamoretti.appue.presentation.home.HomeScreen
import dev.eamoretti.appue.presentation.permissions.GalleryPermissionsScreen

@Composable
fun AppNavGraph() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "login") {
        composable("login") { LoginScreen(navController) }
        composable("register") { RegisterScreen(navController) }
        composable("home") {
            DrawerScaffold(navController) {
                HomeScreen(navController)
            }
        }
        composable("permissions") {
            DrawerScaffold(navController) {
                GalleryPermissionsScreen()
            }
        }
        composable("Favorites") {
            DrawerScaffold(navController) {
                Text("Pantalla de favoritos próximamente")
            }
        }
    }
}