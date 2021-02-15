package com.example.desafiomuxi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions

class TelaFruta : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tela_fruta)

        val intent = intent

        val nomefruta : TextView = findViewById<TextView>(R.id.nomefruta)

        val dadosfruta: TextView = findViewById<TextView>(R.id.dadosfruta)

        val nome = intent.getStringExtra("nome")

        val text = intent.getStringExtra("text")

        val imag = intent.getStringExtra("imag")

        Glide.with(this).load(imag)
            .apply(RequestOptions().diskCacheStrategy(DiskCacheStrategy.ALL))
            .into(findViewById<ImageView>(R.id.img_fruta))

        dadosfruta.text = "$text"

        nomefruta.text = "$nome"


    }
}