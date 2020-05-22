package com.example.xtrememovieapp.room

import android.app.Application
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.xtrememovieapp.Model.Favoritos

@Database(version = 2, entities = [Favoritos::class])
abstract class xtrememovieappDatabase: RoomDatabase() {
    companion object {
        fun get(application: Application): xtrememovieappDatabase{
            return Room.databaseBuilder(application,xtrememovieappDatabase::class.java,"xtrememovieapp")
                .allowMainThreadQueries()
                .fallbackToDestructiveMigration()
                .build()
        }
    }

    abstract fun getxtrememovieappDAO(): xtrememovieappDAO
}