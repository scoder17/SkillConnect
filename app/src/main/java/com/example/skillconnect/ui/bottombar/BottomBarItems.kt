package com.example.skillconnect.ui.bottomBar


import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FolderOpen
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Message
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.ui.graphics.vector.ImageVector

sealed class BottomBarItem (
    val label: String,
    val icon: ImageVector,
    val route:String,
) {
    object HomeScreen: BottomBarItem(
        label = "Home",
        icon = Icons.Default.Home,
        route ="homeScreen"
    )
    object ProjectScreen: BottomBarItem(
        label = "Find Projects",
        icon = Icons.Default.Search,
        route = "searchScreen"
    )
//    object MessageListScreen : BottomBarItem(
//        label = "Messages",
//        icon = Icons.Default.Message,
//        route ="messageListScreen"
//    )
    object ProfileScreen: BottomBarItem(
        label = "Profile",
        icon = Icons.Default.Person,
        route ="profileScreen"
    )
}

