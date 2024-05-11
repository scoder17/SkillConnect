package com.example.skillconnect.ui.screens.client.addProjectScreen

data class AddNewProjectScreenUIState(
    val title:String="",
    val description:String="",
    val budget:String="",
    val deadline:String="",
    val skills:List<String> = emptyList(),
    val experience:Number = 0,
    val jobRequirements:String="",
    val aboutClient:String="",
    val rolesAndResponsibilities:String="",
)