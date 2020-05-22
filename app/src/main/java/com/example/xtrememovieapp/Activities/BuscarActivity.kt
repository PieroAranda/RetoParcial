package com.example.xtrememovieapp.Activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.EditText
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.xtrememovieapp.API.ApiClient
import com.example.xtrememovieapp.API.ApiService
import com.example.xtrememovieapp.Model.Peliculas
import com.example.xtrememovieapp.R
import kotlinx.android.synthetic.main.activity_buscar.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

const val EXTRA_MESS = "com.example.xtrememovieapp"

class BuscarActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_buscar)
    }

    fun BuscarTituloPelicula(view: View)
    {
        val editText = findViewById<EditText>(R.id.editText)
        val pelicula = editText.text.toString()



        val apiClient = ApiClient()
        apiClient.fecthAllResults("3cae426b920b29ed2fb1c0749f258325", pelicula).enqueue(object :
            Callback<Peliculas> {
            override fun onFailure(call: Call<Peliculas>, t: Throwable) {
                Log.d("Fallo", "Falle")
            }

            override fun onResponse(call: Call<Peliculas>, response: Response<Peliculas>) {
                showData(response.body()!!)
                Log.d("Avengers", "OnResponse")
            }

        })
    }

    private fun showData (results: Peliculas){
        recyclerView.apply {
            layoutManager = LinearLayoutManager(this@BuscarActivity)
            adapter = ResultsAdapter(results.results,application)
        }
    }

}
