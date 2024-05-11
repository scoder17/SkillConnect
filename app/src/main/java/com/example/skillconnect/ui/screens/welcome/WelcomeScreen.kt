package com.example.skillconnect.ui.screens.welcome

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.skillconnect.ui.navigation.Routes
import kotlinx.coroutines.delay


@Composable
fun WelcomeScreen(navigateToNext:(String)->Unit) {
    var showElement1 by remember { mutableStateOf(false) }
    var showElement2 by remember { mutableStateOf(false) }
    var showElement3 by remember { mutableStateOf(false) }

    // Animated alpha values for fading in each element
    val alphaElement1 by animateFloatAsState(
        targetValue = if (showElement1) 1f else 0f,
        animationSpec = tween(durationMillis = 1000)
    )
    val alphaElement2 by animateFloatAsState(
        targetValue = if (showElement2) 1f else 0f,
        animationSpec = tween(durationMillis = 1000)
    )
    val alphaElement3 by animateFloatAsState(
        targetValue = if (showElement3) 1f else 0f,
        animationSpec = tween(durationMillis = 1000)
    )

    // Start showing elements one by one
    LaunchedEffect(Unit) {
        showElement1 = true
        delay(1000)
        showElement2 = true
//        showElement1 = false
        delay(1000)
        showElement3 = true
//        showElement2 = false
        delay(1500)
        navigateToNext(Routes.GetStartedScreen.route)
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Welcome",
            color = MaterialTheme.colorScheme.primary.copy(alpha = alphaElement1),
            fontSize = 24.sp,
            modifier = Modifier.padding(bottom = 8.dp)
        )
        Text(
            text = "To SkillConnect!",
            color = MaterialTheme.colorScheme.primary.copy(alpha = alphaElement2),
            fontSize = 24.sp,
            modifier = Modifier.padding(bottom = 8.dp)
        )
        Text(
            text = "Search clients or freelancers!",
            color = MaterialTheme.colorScheme.primary.copy(alpha = alphaElement3),
            fontSize = 24.sp,
            modifier = Modifier.padding(bottom = 8.dp)
        )
    }
}

@Preview
@Composable
fun PreviewWelcomeScreen() {
    WelcomeScreen({})
}
