package com.example.skillconnect.ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.ElevatedSuggestionChip
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.skillconnect.ui.viewModel.AuthViewModel

@Composable
fun Tag(tagText: String) {
    Card(
        modifier = Modifier
            .padding(horizontal = 8.dp, vertical = 5.dp)
            .clip(RoundedCornerShape(100.dp))
//            .border(
//                BorderStroke(1.dp, Color(0xFF018786)), shape = RoundedCornerShape(100.dp)
//            )
//            .padding(12.dp)
    ) {
        Text(
            text = tagText,
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.bodyLarge,
            fontWeight = FontWeight.SemiBold,
            fontSize = 14.sp,
            modifier = Modifier.padding(vertical = 10.dp, horizontal = 15.dp)
        )
    }
}

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun ChipsComponent(
    authViewModel: AuthViewModel
){
    val currentFreelancer = authViewModel.currentfreelancer?.skills?: emptyList()

    FlowRow(
    ) {
        currentFreelancer.forEach() { item ->

            Tag(item)
        }
    }
}
@Composable
@Preview(showBackground = true, showSystemUi = true)
fun ChipsComponentPreview(){
    val skillsList = listOf("Web Development", "JavaScript", "UI/UX Design", "Machine Learning", "Data Science")

//    ChipsComponent(skillsList)
}