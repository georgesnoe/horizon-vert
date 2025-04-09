package com.example.horizonvert

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EcranBienvenue(
    onAcceuilButtonClicked: () -> Unit,
    onPanierButtonClicked: () -> Unit,
    onRechercherButtonClicked: () -> Unit,
    utilisateur: String = ""
) {
    val element_1 = intArrayOf(
        R.mipmap.serre_bache,
        R.mipmap.serre_plexiglas
    )
    val element_2 = arrayOf(
        "Bâche",
        "Plexiglas"
    )
    val element_3 = arrayOf(
        "Serre agricole avec Bâche",
        "Serre agricole en Plexiglas"
    )

    val context = LocalContext.current
    Scaffold(
        modifier = Modifier,
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "Acceuil"
                    )
                },
            )
        },
        bottomBar = {
            NavigationBar {
                NavigationBarItem(
                    selected = true,
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
                    selected = false,
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
            Text(
                text = "Bonjour $utilisateur",
                style = TextStyle(
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold
                )
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = "Meilleure offre du jour",
                style = TextStyle(
                    fontWeight = FontWeight.SemiBold,
                    color = Color.Green
                )
            )
            Spacer(modifier = Modifier.height(16.dp))
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Top,
            ) {

                Column(
                    horizontalAlignment = Alignment.End
                ) {
                    Image(
                        painter = painterResource(id = R.mipmap.serre_bache),
                        contentDescription = "Bache",
                        modifier = Modifier.fillMaxWidth()
                            .border(2.dp, Color.White),
                        contentScale = ContentScale.FillWidth
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        text = "Serre agricole en bâche",
                        modifier = Modifier.fillMaxWidth()
                    )
                    TextButton(
                        onClick = {
                            val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://horizon-vert-seic.vercel.app"))
                            context.startActivity(intent)
                        }
                    ) {
                        Text("En savoir plus")
                    }
                }
            }
            Spacer(modifier = Modifier.height(8.dp))
        }
    }
}