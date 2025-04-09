package com.example.horizonvert

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.horizonvert.ui.theme.HorizonVertTheme

class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            HorizonVertTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Navigation()
                }
            }
        }
    }
}

@Composable
fun Navigation() {
    val navController = rememberNavController()
    val context = LocalContext.current
    NavHost(
        navController = navController,
        startDestination = Screen.Acceuil
    ) {
        composable(Screen.Acceuil) {
            EcranDemarrage(
                onDemarrerButtonClicked = {
                    navController.navigate(Screen.Connexion)
                }
            )
        }
        composable(Screen.Connexion) {
            EcranConnexion(
                context = context,
                onConnectClicked = {
                    navController.navigate(Screen.Bienvenue)
                }
            )
        }
        composable(Screen.Bienvenue) {
            EcranBienvenue(
                onAcceuilButtonClicked = {
                    navController.navigate(Screen.Bienvenue)
                },
                onPanierButtonClicked = {
                    navController.navigate(Screen.Panier)
                },
                onRechercherButtonClicked = {
                    navController.navigate(Screen.Rechercher)
                }
            )
        }
        composable(Screen.Panier) {
            EcranPanier(
                onAcceuilButtonClicked = {
                    navController.navigate(Screen.Bienvenue)
                },
                onPanierButtonClicked = {
                    navController.navigate(Screen.Panier)
                },
                onRechercherButtonClicked = {
                    navController.navigate(Screen.Rechercher)
                }
            )
        }
        composable(Screen.Rechercher) {
            EcranRechercher(
                onAcceuilButtonClicked = {
                    navController.navigate(Screen.Bienvenue)
                },
                onPanierButtonClicked = {
                    navController.navigate(Screen.Panier)
                },
                onRechercherButtonClicked = {
                    navController.navigate(Screen.Rechercher)
                }
            )
        }
    }
}

@Preview
@Composable
fun ShowPreview() {
    Navigation()
}
