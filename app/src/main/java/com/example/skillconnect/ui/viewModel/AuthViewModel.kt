package com.example.skillconnect.ui.viewModel

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.skillconnect.data.CLIENT_NODE
import com.example.skillconnect.data.FREELANCER_NODE
import com.example.skillconnect.model.ClientData
import com.example.skillconnect.model.FreeLancerData
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
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

    fun logout() {
        isLoggedIn.value = false
        auth.signOut()
    }


}