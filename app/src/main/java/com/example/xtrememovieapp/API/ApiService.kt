package com.example.xtrememovieapp.API

import com.example.xtrememovieapp.Model.Peliculas
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("movie")
    fun fecthAllResults(@Query("api_key") api_key:String,@Query("query") query:String): Call<Peliculas>
}