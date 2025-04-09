package com.example.horizonvert

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.icons.outlined.ShoppingCart
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EcranPanier(
    onAcceuilButtonClicked: () -> Unit,
    onPanierButtonClicked: () -> Unit,
    onRechercherButtonClicked: () -> Unit,
    utilisateur: String = ""
) {
    Scaffold(
        modifier = Modifier,
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "Votre panier"
                    )
                },
            )
        },
        bottomBar = {
            NavigationBar {
                NavigationBarItem(
                    selected = false,
                    onClick = onAcceuilButtonClicked,
                    icon = {
                        Icon(
                            imageVector = Icons.Filled.Home,
                            contentDescription = "Acceuil"
                        )
                    },
                    label = {
                        Text("Acceuil")
                    }
                )
                NavigationBarItem(
                    selected = true,
                    onClick = onPanierButtonClicked,
                    icon = {
                        Icon(
                            imageVector = Icons.Filled.ShoppingCart,
                            contentDescription = "Panier"
                        )
                    },
                    label = {
                        Text("Panier")
                    }
                )
                NavigationBarItem(
                    selected = false,
                    onClick = onRechercherButtonClicked,
                    icon = {
                        Icon(
                            imageVector = Icons.Filled.Search,
                            contentDescription = "Rechercher"
                        )
                    },
                    label = {
                        Text("Rechercher")
                    }
                )
            }
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .padding(horizontal = 8.dp)
        ) {
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    "$utilisateur"
                )
                Text(
                    "0 FCFA"
                )
            }
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Icon(
                    imageVector = Icons.Outlined.ShoppingCart,
                    contentDescription = "Oups, votre panier est vide",
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp)
                )
                Text("Oups, votre panier est vide")
            }
        }
    }
}