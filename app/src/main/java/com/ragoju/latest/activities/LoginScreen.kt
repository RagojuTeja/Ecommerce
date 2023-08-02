package com.ragoju.latest.activities

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import com.ragoju.latest.databinding.ActivityLoginScreenBinding
import com.ragoju.latest.viewmodel.AuthViewModel

class LoginScreen : AppCompatActivity() {

    private lateinit var binding: ActivityLoginScreenBinding

    private lateinit var emailEdit: EditText
    private lateinit var passEdit: EditText
    private lateinit var signUpText: TextView
    private lateinit var signInBtn: Button
    private lateinit var viewModel: AuthViewModel
    private lateinit var navController: NavController

//    private lateinit var loadingDialog: LoadingDialog

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        loginViewModelMethod()


        emailEdit = binding.emailEt
        passEdit = binding.PassEt
        signUpText = binding.signUpTv
        signInBtn = binding.loginBtn

//        loadingDialog = LoadingDialog(requireActivity())

        signUpText.setOnClickListener { startActivity(Intent(this, SignUpScreen::class.java)) }

        signInMethod()

    }

    private fun loginViewModelMethod(){

        viewModel = ViewModelProvider(
            this,
            ViewModelProvider.AndroidViewModelFactory.getInstance(this.application)
        ).get(
            AuthViewModel::class.java
        )
        viewModel.userData.observe(this) { firebaseUser ->
            if (firebaseUser != null) {
                startActivity(Intent(this, MainActivity::class.java))
                finish()
            }
        }
    }

    private fun signInMethod(){

        signInBtn.setOnClickListener {
//            loadingDialog.startLoadingDialog()

            val email = emailEdit.text.toString()
            val pass = passEdit.text.toString()

            if (email.isEmpty() && pass.isEmpty()){
                emailEdit.error = "Please enter mail"
            }

            if (!email.isEmpty() && !pass.isEmpty()) {
                viewModel.signIn(email, pass)
//                loadingDialog.dismissDialog()
            }
        }

    }
}