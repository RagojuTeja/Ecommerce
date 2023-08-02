package com.ragoju.latest.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.ragoju.latest.R
import com.ragoju.latest.databinding.ActivitySignUpScreenBinding
import com.ragoju.latest.viewmodel.AuthViewModel

class SignUpScreen : AppCompatActivity() {

    private lateinit var binding: ActivitySignUpScreenBinding

    private lateinit var emailEdit: EditText
    private lateinit var passEdit: EditText
    private lateinit var signInText: TextView
    private lateinit var signUpBtn: Button
    private lateinit var viewModel: AuthViewModel
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignUpScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        loginMethod()

        emailEdit = binding.emailEtSignUpPage
        passEdit = binding.PassEtSignUpPage
        signInText = binding.signInTvSignUpPage
        signUpBtn = binding.signUpBtnSignUpPage

//        navController = Navigation.findNavController(view)
        signInText.setOnClickListener { startActivity(Intent(this, LoginScreen::class.java)) }

        signUpMethod()

    }

    private fun loginMethod(){

        viewModel = ViewModelProvider(this, ViewModelProvider.AndroidViewModelFactory.getInstance(this.application)
        ).get(
            AuthViewModel::class.java
        )
        viewModel.userData.observe(this) { firebaseUser ->
            if (firebaseUser != null) {
                startActivity(Intent(this, MainActivity::class.java))
            }
        }
    }

    private fun signUpMethod(){

        signUpBtn.setOnClickListener {
            val email = emailEdit.text.toString()
            val pass = passEdit.text.toString()
            if (email.isNotEmpty() && pass.isNotEmpty()) {
                viewModel.register(email, pass)
            }
        }
    }
}