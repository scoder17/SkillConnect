package com.example.skillconnect.ui.screens.freelancer.project

import androidx.lifecycle.ViewModel
import com.example.skillconnect.R
import com.example.skillconnect.model.ProjectDetails

class ProjectScreenViewModel: ViewModel() {
    val projectList: List<ProjectDetails> = listOf(
        ProjectDetails(
            image = R.drawable.profile_image,
            title = "Beats Logo Design",
            description = "by AI Hasanav",
            deadlineDate = "22 July 2023",
            payment = "$1000",
            paymentStatus = "last payment",
            projectStatus = "Active"
        ),
        ProjectDetails(
            image = R.drawable.profile_image,
            title = "Beats Logo Design",
            description = "by AI Hasanav",
            deadlineDate = "22 July 2023",
            payment = "$1000",
            paymentStatus = "last payment",
            projectStatus = "Active"
        ),
        ProjectDetails(
            image = R.drawable.profile_image,
            title = "Beats Logo Design",
            description = "by AI Hasanav",
            deadlineDate = "22 July 2023",
            payment = "$1000",
            paymentStatus = "last payment",
            projectStatus = "Active"
        ),
        ProjectDetails(
            image = R.drawable.profile_image,
            title = "Beats Logo Design",
            description = "by AI Hasanav",
            deadlineDate = "22 July 2023",
            payment = "$1000",
            paymentStatus = "last payment",
            projectStatus = "Active"
        ),
        ProjectDetails(
            image = R.drawable.profile_image,
            title = "Beats Logo Design",
            description = "by AI Hasanav",
            deadlineDate = "22 July 2023",
            payment = "$1000",
            paymentStatus = "last payment",
            projectStatus = "Completed"
        ),
        ProjectDetails(
            image = R.drawable.profile_image,
            title = "Beats Logo Design",
            description = "by AI Hasanav",
            deadlineDate = "22 July 2023",
            payment = "$1000",
            paymentStatus = "last payment",
            projectStatus = "Completed"
        ),
        ProjectDetails(
            image = R.drawable.profile_image,
            title = "Beats Logo Design",
            description = "by AI Hasanav",
            deadlineDate = "22 July 2023",
            payment = "$1000",
            paymentStatus = "last payment",
            projectStatus = "Completed"
        ),
        ProjectDetails(
            image = R.drawable.profile_image,
            title = "Beats Logo Design",
            description = "by AI Hasanav",
            deadlineDate = "22 July 2023",
            payment = "$1000",
            paymentStatus = "last payment",
            projectStatus = "Completed"
        ),
        ProjectDetails(
            image = R.drawable.twitter,
            title = "Beats Logo Design",
            description = "by AI Hasanav",
            deadlineDate = "22 July 2023",
            payment = "$1000",
            paymentStatus = "last payment",
            projectStatus = "Completed"
        ),
    )
}