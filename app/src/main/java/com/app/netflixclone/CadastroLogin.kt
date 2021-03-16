package com.app.netflixclone

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import android.widget.Toolbar
import com.app.netflixclone.databinding.ActivityCadastroLoginBinding
import com.google.firebase.FirebaseNetworkException
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException
import com.google.firebase.auth.FirebaseAuthUserCollisionException
import com.google.firebase.auth.FirebaseAuthWeakPasswordException

class CadastroLogin : AppCompatActivity() {

    private lateinit var binding: ActivityCadastroLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCadastroLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar!!.hide()
        Toolbar()

        binding.btCadastrar.setOnClickListener {

            val email = binding.editEmail.text.toString()
            val senha = binding.editSenha.text.toString()
            val mensagem = binding.mensagemError

            if (email.isEmpty() || senha.isEmpty()){
                mensagem.setText("Preencha todos os campos!")
            }else{
                CadastrarUsuario()
            }
        }
    }

    private fun CadastrarUsuario(){
        val email = binding.editEmail.text.toString()
        val senha = binding.editSenha.text.toString()
        val mensagem = binding.mensagemError

        FirebaseAuth.getInstance().createUserWithEmailAndPassword(email,senha).addOnCompleteListener {
            if (it.isSuccessful){
                Toast.makeText(this, "Usuário cadastrado com sucesso!", Toast.LENGTH_SHORT).show()
                binding.editEmail.setText("")
                binding.editSenha.setText("")
                mensagem.setText("")
            }
        }.addOnFailureListener {

            var erro = it

            when{
                erro is FirebaseAuthWeakPasswordException -> mensagem.setText("Digite uma senha com no mínimo 6 caracteres!")
                erro is FirebaseAuthUserCollisionException -> mensagem.setText("Email já cadastrado!")
                erro is FirebaseNetworkException -> mensagem.setText("Sem conexão com a internet")
                else -> mensagem.setText("Erro ao cadastrar usuário")
            }
        }
    }

    private fun Toolbar(){
        val toolbar = binding.toolbarCadastro
        toolbar.setNavigationIcon(R.drawable.ic_netflix_official_logo)
    }


}