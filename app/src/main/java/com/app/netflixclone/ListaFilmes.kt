package com.app.netflixclone

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.GridLayout
import androidx.recyclerview.widget.GridLayoutManager
import com.app.netflixclone.Adapter.FilmesAdapter
import com.app.netflixclone.Model.addFilmes
import com.app.netflixclone.OnClick.OnItemClickListener
import com.app.netflixclone.OnClick.addOnItemClickListener
import com.app.netflixclone.databinding.ActivityListaFilmesBinding
import com.google.firebase.auth.FirebaseAuth

class ListaFilmes : AppCompatActivity() {

    private lateinit var binding: ActivityListaFilmesBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityListaFilmesBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val recycle_filme = binding.recyclerview
        recycle_filme.adapter = FilmesAdapter(addFilmes())
        recycle_filme.layoutManager = GridLayoutManager(applicationContext,3)


        recycle_filme.addOnItemClickListener(object: OnItemClickListener{
            override fun onItemClicked(position: Int, view: View) {

                when{
                    position == 0 -> DetalhesFilmes()
                    position == 1 -> DetalhesFilmes()
                }
            }
        })

    }

    private fun DetalhesFilmes(){
        val intent = Intent(this, DetalhesFilmes::class.java)
        startActivity(intent)
    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflate = menuInflater
        inflate.inflate(R.menu.menu_principal, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when(item.itemId){

            R.id.deslogar -> {
                FirebaseAuth.getInstance().signOut()
                VoltarTelaLogin()
            }
        }

        return super.onOptionsItemSelected(item)
    }

    private fun VoltarTelaLogin(){

        val intent = Intent(this, FormLogin::class.java)
        startActivity(intent)
        finish()
    }
}