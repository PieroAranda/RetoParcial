package com.example.xtrememovieapp.Activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.xtrememovieapp.R
import com.example.xtrememovieapp.room.xtrememovieappDatabase

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        xtrememovieappDatabase.get(application)
    }

    fun moveToBuscar(view: View)
    {
        val intent = Intent(this, BuscarActivity::class.java)
        startActivity(intent)
    }

    fun moveToFavoritos(view: View)
    {
        val intent = Intent(this, FavoritosActivity::class.java)
        startActivity(intent)
    }
}
