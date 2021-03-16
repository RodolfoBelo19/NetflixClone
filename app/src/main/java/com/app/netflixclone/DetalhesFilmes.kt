package com.app.netflixclone

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import com.app.netflixclone.Adapter.FilmesAdapter
import com.app.netflixclone.Model.Filmes
import com.app.netflixclone.Model.addFilmes
import com.app.netflixclone.databinding.ActivityDetalhesFilmesBinding
import com.squareup.picasso.Picasso

class DetalhesFilmes : AppCompatActivity() {

    private lateinit var binding: ActivityDetalhesFilmesBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetalhesFilmesBinding.inflate(layoutInflater)
        setContentView(binding.root)


        supportActionBar!!.hide()
        Toolbar()

        val recycler_outros_filmes = binding.recyclerOutrosFilmes
        recycler_outros_filmes.adapter = FilmesAdapter(addFilmes())
        recycler_outros_filmes.layoutManager = GridLayoutManager(applicationContext, 3)

        val capaTheWicther = "https://firebasestorage.googleapis.com/v0/b/netflixclone-10b75.appspot.com/o/video.jpg?alt=media&token=c47b2347-ca51-4f72-a002-a665d868dfc5"
        Picasso.get().load(capaTheWicther).fit().into(binding.capa)

        binding.playVideo.setOnClickListener {

            val intent = Intent(this, Video::class.java)
            startActivity(intent)
        }


    }

    private fun Toolbar(){

        val toolbar = binding.toolbarDetalhes
        toolbar.setNavigationIcon(R.drawable.ic_back)
        toolbar.setNavigationOnClickListener {

            val intent = Intent(this, Filmes::class.java)
            startActivity(intent)
        }
    }
}