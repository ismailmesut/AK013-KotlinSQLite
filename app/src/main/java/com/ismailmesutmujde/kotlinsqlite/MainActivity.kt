package com.ismailmesutmujde.kotlinsqlite

import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        // SQLITE DATABASE

        try {
            val myDatabase = this.openOrCreateDatabase("Musicians", Context.MODE_PRIVATE, null)
            myDatabase.execSQL("CREATE TABLE IF NOT EXISTS musicians (name VARCHAR, age INT)")

        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}