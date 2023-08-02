package com.ragoju.latest.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.google.firebase.auth.FirebaseUser
import com.ragoju.login.repository.AuthenticationRepository

class AuthViewModel(application: Application) : AndroidViewModel(application) {
    private val repository: AuthenticationRepository
    val userData: MutableLiveData<FirebaseUser?>
    val loggedStatus: MutableLiveData<Boolean>

    init {
        repository = AuthenticationRepository(application)
        userData = repository.firebaseUserMutableLiveData
        loggedStatus = repository.userLoggedMutableLiveData
    }

    fun register(email: String?, pass: String?) {
        repository.register(email, pass)
    }

    fun signIn(email: String?, pass: String?) {
        repository.login(email, pass)
    }

    fun signOut() {
        repository.signOut()
    }
}