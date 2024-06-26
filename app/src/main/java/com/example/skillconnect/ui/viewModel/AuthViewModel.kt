package com.example.skillconnect.ui.viewModel

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.skillconnect.data.CLIENT_NODE
import com.example.skillconnect.data.FREELANCER_NODE
import com.example.skillconnect.data.PROJECT_NODE
import com.example.skillconnect.model.ClientData
import com.example.skillconnect.model.FreeLancerData
import com.example.skillconnect.model.ProjectData
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import kotlinx.coroutines.tasks.await
import javax.inject.Inject

@HiltViewModel
open class AuthViewModel @Inject constructor(
    private val auth: FirebaseAuth,
    private val db: FirebaseFirestore
) : ViewModel() {

    private val isLoggedIn = mutableStateOf(false)
    var inProgress by mutableStateOf(false)
    var currentfreelancer by mutableStateOf<FreeLancerData?>(null)

    private val isClientLoggedIn = mutableStateOf(false)
    var currentClient by mutableStateOf<ClientData?>(null)

    init {
        val currentUser = auth.currentUser
        viewModelScope.launch {
            currentUser?.uid?.let {
                getFreelancer(it).await()
            }
        }
        viewModelScope.launch {
            currentUser?.uid?.let {
                getClient(it).await()
            }
        }

    }

    fun checkIfLoggedIn(): Boolean {
        return isLoggedIn.value
    }

    fun signIn(email: String, password: String) {
        inProgress = true
        auth.signInWithEmailAndPassword(email, password).addOnSuccessListener {
            Log.d(
                "TAG",
                "signIn: signin success"
            )
            inProgress = false
            getFreelancer(it.user?.uid ?: "")
            isLoggedIn.value = true
        }
            .addOnFailureListener {
                inProgress = false
                Log.e("TAG", "signIn: signin failed ${it.localizedMessage}")
            }
    }

    fun signInClient(email: String, password: String) {
        inProgress = true
        auth.signInWithEmailAndPassword(email, password).addOnSuccessListener {
            Log.d(
                "TAG",
                "signIn: signin success"
            )
            inProgress = false
            isClientLoggedIn.value = true
        }
            .addOnFailureListener {
                inProgress = false
                Log.e("TAG", "signIn: signin failed ${it.localizedMessage}")
            }
    }

    fun checkIfClientLoggedIn(): Boolean {
        return isClientLoggedIn.value
    }


    fun signUp(
        name: String,
        email: String,
        password: String,
        linkedIn: String,
        github: String,
        twitter: String,
        skills: List<String>
    ) {
        inProgress = true
        auth.createUserWithEmailAndPassword(email, password).addOnSuccessListener {
            val freelancer = FreeLancerData(
                id = it.user?.uid ?: "",
                name = name,
                email = email,
                password = password,
                profileImage = it.user?.photoUrl.toString(),
                linkedIn = linkedIn,
                github = github,
                twitter = twitter,
                skills = skills
            )
            Log.d("TAG", "signUp:$freelancer ")
            createOrUpdateProfile(freelancer)
        }
            .addOnFailureListener {
                inProgress = false
                Log.e("TAG", "signUp: signup failed")
            }
    }

    fun signUpClient(
        name: String,
        email: String,
        password: String,
        linkedIn: String,
        twitter: String
    ) {
        inProgress = true
        auth.createUserWithEmailAndPassword(email, password).addOnSuccessListener {
            val client = ClientData(
                id = it.user?.uid ?: "",
                name = name,
                email = email,
                password = password,
                profileImage = it.user?.photoUrl.toString(),
                linkedIn = linkedIn,
                twitter = twitter
            )
            Log.d("TAG", "signUp:$client ")
            createOrUpdateClient(client)
        }
            .addOnFailureListener {
                inProgress = false
                Log.e("TAG", "signUp: signup failed")
            }
    }


    private fun createOrUpdateProfile(freelancer: FreeLancerData) {

        db.collection(FREELANCER_NODE).document(freelancer.id).get().addOnSuccessListener {
            if (it.exists()) {
                db.collection(FREELANCER_NODE).document(freelancer.id).set(freelancer)
            } else {
                db.collection(FREELANCER_NODE).document(freelancer.id).set(freelancer)
                inProgress = false
            }
        }
            .addOnFailureListener {
                inProgress = false
                Log.e("TAG", "createOrUpdateProfile: cannot retrieve user")
            }
    }

    private fun createOrUpdateClient(client: ClientData) {
        db.collection(CLIENT_NODE).document(client.id).get().addOnSuccessListener {
            if (it.exists()) {
                db.collection(CLIENT_NODE).document(client.id).set(client)
            } else {
                db.collection(CLIENT_NODE).document(client.id).set(client)
                inProgress = false
            }
        }
            .addOnFailureListener {
                inProgress = false
                Log.e("TAG", "createOrUpdateProfile: cannot retrieve user")
            }

    }


    private fun getFreelancer(id: String): Deferred<Unit> {
        inProgress = true
        return viewModelScope.async {
            db.collection(FREELANCER_NODE).document(id).addSnapshotListener { value, error ->
                if (error != null) {
                    inProgress = false
                    Log.e("TAG", "getFreelancer: ${error.localizedMessage}")
                }
                if (value != null) {
                    currentfreelancer = value.toObject(FreeLancerData::class.java)
                    isLoggedIn.value = true
                    Log.d("TAG", "getFreelancer: $currentfreelancer")
                    inProgress = false
                }
            }
        }
    }

    private fun getClient(id: String): Deferred<Unit> {
        inProgress = true

        return viewModelScope.async {
            db.collection(CLIENT_NODE).document(id).addSnapshotListener { value, error ->
                if (error != null) {
                    inProgress = false
                    Log.e("TAG", "getFreelancer: ${error.localizedMessage}")
                }
                if (value != null) {
                    currentClient = value.toObject(ClientData::class.java)
                    isClientLoggedIn.value = true
                    Log.d("TAG", "getFreelancer: $currentClient")
                    inProgress = false
                }
            }
        }

    }

    fun addProject(
        title: String,
        description: String,
        date: String,
        deadline: String,
        status: String,
        applicants: List<String>? = null,
        roles: String,
        requiredSkills: List<String>,
        budget: String,
        aboutCompany: String,
        clientId: String,
        freelancerId: String? = null,
    ) {
        // Create a new document reference with a randomly generated ID
        val documentReference = db.collection(PROJECT_NODE).document()

        // Create a new project object with the randomly generated ID
        val project = ProjectData(
            id = documentReference.id,
            title = title,
            description = description,
            date = date,
            deadline = deadline,
            status = status,
            applicants = applicants,
            roles = roles,
            requiredSkills = requiredSkills,
            budget = budget,
            aboutCompany = aboutCompany,
            clientId = clientId,
            freelancerId = freelancerId,
        )

        // Set the project object in the newly created document
        documentReference.set(project)
    }

//    fun getClientProjects(): List<ProjectData> {
//        val projects = mutableListOf<ProjectData>()
//        db.collection(PROJECT_NODE).whereEqualTo("clientId", currentClient?.id).get()
//            .addOnSuccessListener {
//                for (document in it) {
//                    val project = document.toObject(ProjectData::class.java)
//                    projects.add(project)
//                }
//            }
//            .addOnFailureListener {
//                Log.e("TAG", "getClientProjects: ${it.localizedMessage}")
//            }
//        return projects
//    }



    suspend fun getClientProjects(): List<ProjectData> {
        val projects = mutableListOf<ProjectData>()

        try {
            val querySnapshot = db.collection(PROJECT_NODE)
                .whereEqualTo("clientId", currentClient?.id)
                .get()
                .await()

            for (document in querySnapshot) {
                val project = document.toObject(ProjectData::class.java)
                projects.add(project)
            }
        } catch (e: Exception) {
            Log.e("TAG", "getClientProjects: ${e.localizedMessage}")
        }

        return projects
    }


    fun logout() {
        isLoggedIn.value = false
        auth.signOut()
    }

    fun logoutClient() {
        isClientLoggedIn.value = false
        auth.signOut()
    }


}