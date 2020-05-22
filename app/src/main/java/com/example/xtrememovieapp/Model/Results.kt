package com.example.xtrememovieapp.Model

class Results {
    val id:Int
    val title: String
    val overview: String

    constructor(id:Int, title: String, overview: String) {
        this.id=id
        this.title = title
        this.overview = overview
    }
}