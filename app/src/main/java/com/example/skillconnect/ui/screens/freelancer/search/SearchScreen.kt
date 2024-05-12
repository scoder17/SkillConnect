package com.example.skillconnect.ui.screens.freelancer.search

import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SearchBar
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.skillconnect.R
import com.example.skillconnect.model.ProjectData
import com.example.skillconnect.ui.screens.client.clientProject.ClientProjectList
import com.example.skillconnect.ui.screens.client.clientProject.ProjectListItem
import com.example.skillconnect.ui.screens.client.clientProject.ProjectScreenTopBar
import com.example.skillconnect.ui.screens.client.searchScreen.noRippleClickable
import com.example.skillconnect.ui.viewModel.AuthViewModel
import com.example.skillconnect.ui.viewModel.SearchViewModel

@Composable
fun SearchScreen(
    modifier: Modifier = Modifier,
//    viewModel: SearchViewModel = androidx.lifecycle.viewmodel.compose.viewModel(),
//    onSkillClicked: (String) -> Unit = {},
    authViewModel: AuthViewModel
){
    var projectList by remember { mutableStateOf(emptyList<ProjectData>()) }
    LaunchedEffect(key1 = Unit) {
        val fetchedProjects = authViewModel.getClientProjects()
        projectList = fetchedProjects
    }
//    Scaffold(
//        topBar = { SearchScreenTopBar() }
//    ) {
//        Spacer(modifier = Modifier.height(20.dp))
        SearchScreen2(authViewModel = authViewModel, projectList = projectList)
//    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchScreenTopBar(modifier: Modifier = Modifier) {
    TopAppBar(title = { Text(text = "Search for Projects") })
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchScreen2(
    viewModel: SearchViewModel = androidx.lifecycle.viewmodel.compose.viewModel(),
    onSkillClicked: (String) -> Unit = {},
    authViewModel: AuthViewModel,
    projectList: List<ProjectData>
) {
    val searchText by viewModel.searchText.collectAsState()
    val skills = authViewModel.currentfreelancer?.skills
    var active by remember {
        mutableStateOf(false)
    }
    Column {
        SearchBar(
            modifier = Modifier.fillMaxWidth(),
            query = searchText,
            onQueryChange = viewModel::onSearchTextChange,
            onSearch = {
                active = false
//                viewModel.searchTracks()
            },
            active = active,
            onActiveChange = { active = it },
            placeholder = { Text(text = "Enter tech stack") },
            leadingIcon = {
                if (active) {
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                        contentDescription = null,
                        modifier = Modifier.clickable { active = false })
                } else {
                    Icon(imageVector = Icons.Default.Search, contentDescription = null)
                }
            },
            trailingIcon = {
                if (active && searchText.isNotBlank()) {
                    Icon(
                        imageVector = Icons.Default.Close,
                        contentDescription = null,
                        modifier = Modifier.noRippleClickable {
                            viewModel.clearSearchText()
                        })
                }
            }
        ) {}

        if (viewModel.isSearching.collectAsState().value) {
            Box(contentAlignment = Alignment.Center, modifier = Modifier.fillMaxSize()) {
                CircularProgressIndicator()
            }
        } else {
            Log.d("freelancer ka skills", " $skills")
            Log.d("project me skills required", " $projectList")

            if (skills == emptyList<String>() && searchText.isNotBlank()) {
                Text(
                    text = "Try searching for something else",
                    modifier = Modifier.fillMaxSize(),
                    textAlign = TextAlign.Center
                )
            } else {
                LazyColumn(contentPadding = PaddingValues(8.dp)) {
                    items(projectList.filter { project ->
                        project.requiredSkills.contains(searchText)
                    }) { project ->
                        ProjectListItem(
                            image = R.drawable.ic_launcher_foreground,
                            title = project.title,
                            description = project.description,
                            deadlineDate = project.deadline,
                            payment = project.budget,
                            projectStatus = project.status,
                            modifier = Modifier.padding(16.dp)
                        )
                    }
                }

            }
        }
    }
}

@Composable
fun Modifier.noRippleClickable(
    onClick: () -> Unit
): Modifier = this then
        clickable(
            indication = null,
            interactionSource = remember { MutableInteractionSource() }
        ) {
            onClick()
        }
//
//@Composable
//fun AudioItem(
//    skill: String,
//    onItemClick: () -> Unit
//) {
//    Row(
//        modifier = Modifier
//            .fillMaxWidth()
//            .padding(8.dp)
//            .clickable { onItemClick() },
//        verticalAlignment = Alignment.CenterVertically
//    ) {
//        AsyncImage(
//            model = ImageRequest.Builder(LocalContext.current)
//                .data(audio.albumArtUri)
//                .error(R.drawable.musicbackground)
//                .build(),
//            contentDescription = "Song Image",
//            contentScale = ContentScale.Crop,
//            modifier = Modifier
//                .size(64.dp)
//                .aspectRatio(1f)
//        )
//        Column {
//            Column(
//                modifier = Modifier.padding(16.dp)
//            ) {
//                Text(
//                    text = audio.displayName,
//                    fontWeight = FontWeight.Bold,
//                    maxLines = 1,
//                    style = MaterialTheme.typography.bodyLarge,
//                    overflow = TextOverflow.Clip,
//                )
//                Spacer(modifier = Modifier.size(4.dp))
//                Text(
//                    text = audio.artist,
//                    fontWeight = FontWeight.Normal,
//                    style = MaterialTheme.typography.bodySmall,
//                    overflow = TextOverflow.Clip,
//                )
//            }
//        }
//    }
//}