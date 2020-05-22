package com.example.xtrememovieapp.API

import com.example.xtrememovieapp.Model.Favoritos
import com.example.xtrememovieapp.Model.Peliculas
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiClient {
    val BASE_URL: String = "https://api.themoviedb.org/3/search/"
    val apiService:ApiService

    constructor(){
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        apiService = retrofit.create(ApiService::class.java)
    }

    fun fecthAllResults(api_key:String,query:String): Call<Peliculas> {
        return apiService.fecthAllResults(api_key,query)
    }
}