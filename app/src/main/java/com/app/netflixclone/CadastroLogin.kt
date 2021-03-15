package com.app.netflixclone

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.app.netflixclone.databinding.ActivityCadastroLoginBinding

class CadastroLogin : AppCompatActivity() {

    private lateinit var binding: ActivityCadastroLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCadastroLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar!!.hide()

        val toolbar = binding.toolbarCadastro
        toolbar.setNavigationIcon(R.drawable.ic_netflix_official_logo)

    }
}