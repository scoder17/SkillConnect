package com.example.skillconnect.ui.bottombar

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Message
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.ui.graphics.vector.ImageVector
import com.example.skillconnect.ui.bottomBar.BottomBarItem

sealed class ClientBottomBarItem (
    val label: String,
    val icon: ImageVector,
    val route:String,
) {
    object HomeScreen: ClientBottomBarItem(
        label = "Home",
        icon = Icons.Default.Home,
        route ="clientHomeScreen"
    )
    object ProjectScreen: ClientBottomBarItem(
        label = "Find Projects",
        icon = Icons.Default.Search,
        route = "clientSearchScreen"
    )
    object MessageListScreen : ClientBottomBarItem(
        label = "Messages",
        icon = Icons.Default.Message,
        route ="messageListScreen"
    )
    object ProfileScreen: ClientBottomBarItem(
        label = "Profile",
        icon = Icons.Default.Person,
        route ="profileScreen"
    )
}

