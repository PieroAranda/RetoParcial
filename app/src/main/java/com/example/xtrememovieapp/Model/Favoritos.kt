package com.example.xtrememovieapp.Model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class Favoritos {
    @PrimaryKey val id:Int
    val title:String
    val overview:String

    constructor(id:Int, title: String, overview: String) {
        this.id=id
        this.title = title
        this.overview = overview
    }
}