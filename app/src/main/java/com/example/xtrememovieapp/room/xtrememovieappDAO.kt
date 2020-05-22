package com.example.xtrememovieapp.room

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.xtrememovieapp.Model.Favoritos

@Dao
interface xtrememovieappDAO {
    @Insert
    fun insertFavoritos(favoritos: Favoritos)

    @Query("select *from Favoritos")
    fun getFavoritos(): List<Favoritos>

    @Query("select *from Favoritos where id =:id")
    fun findFavorite(id:Int):List<Favoritos>

    @Query("delete from Favoritos where id=:id")
    fun deleteFavorite(id:Int)
}