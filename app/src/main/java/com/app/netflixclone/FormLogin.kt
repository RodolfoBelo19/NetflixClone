package com.app.netflixclone

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.app.netflixclone.databinding.ActivityFormLoginBinding

class FormLogin : AppCompatActivity() {

    lateinit var binding: ActivityFormLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFormLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar!!.hide()

        val cadastro = binding.txtTelaCadastro
        val mensagem = binding.mensagemError
        val entrar = binding.btEntrar

        entrar.setOnClickListener {
            val email = binding.editEmail.text.toString()
            val senha = binding.editSenha.text.toString()

            if (email.isEmpty() && senha.isEmpty()) {
                mensagem.setText("Informe o email e senha!")
            }

        }


        cadastro.setOnClickListener {

            val intent = Intent(this, CadastroLogin::class.java)
            startActivity(intent)

        }


    }
}