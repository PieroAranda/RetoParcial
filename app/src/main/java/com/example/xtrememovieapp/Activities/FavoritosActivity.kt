package com.example.xtrememovieapp.Activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.xtrememovieapp.Model.Favoritos
import com.example.xtrememovieapp.Model.Peliculas
import com.example.xtrememovieapp.R
import com.example.xtrememovieapp.room.xtrememovieappDatabase
import kotlinx.android.synthetic.main.activity_buscar.*
import kotlinx.android.synthetic.main.activity_favoritos.*

class FavoritosActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_favoritos)
        val favoritos:MutableList<Favoritos> =  xtrememovieappDatabase.get(application).getxtrememovieappDAO().getFavoritos().toMutableList()
        showData(favoritos)
    }

    private fun showData (favoritos: MutableList<Favoritos>){
        recyclerViewFavorite.apply {
            layoutManager = LinearLayoutManager(this@FavoritosActivity)
            adapter = FavoritosAdapter(favoritos,application)
        }
    }
}
