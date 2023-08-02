package com.ragoju.latest.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.ragoju.latest.databinding.ActivityEditProfileScreenBinding

class EditProfileScreen : AppCompatActivity() {

    private lateinit var binding : ActivityEditProfileScreenBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEditProfileScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}