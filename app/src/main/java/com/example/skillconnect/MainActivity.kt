package com.example.skillconnect

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.skillconnect.ui.bottombar.BottomBar
import com.example.skillconnect.ui.navigation.NavigationGraph
import com.example.skillconnect.ui.theme.SkillConnectTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SkillConnectTheme {

                var buttonsVisible by remember { mutableStateOf(false) }
                val navController: NavHostController = rememberNavController()

                Scaffold(
                    modifier = Modifier
                        .fillMaxSize(),
                    bottomBar = {
                        // Show bottom bar only if buttonsVisible is true
                        if (buttonsVisible) {
                            BottomBar(
                                navController = navController,
                                state = buttonsVisible,
                                modifier = Modifier
                            )
                        }
                    }
                ) { innerPadding ->
                    Box(
                        modifier = Modifier.padding(innerPadding)
                    ) {
                        // Background Image, if any
//                        Image(
//                            painter = painterResource(R.drawable.background_image), // Replace with your image resource
//                            contentDescription = "Background Image",
//                            modifier = Modifier.fillMaxSize(),
//                            contentScale = ContentScale.FillBounds
//                        )
                        // Pass the lambda to NavigationGraph
                        NavigationGraph(navController = navController) { isVisible ->
                            // Update the visibility state of the bottom bar
                            buttonsVisible = isVisible
                        }
                    }
                }
            }
        }
    }
}
