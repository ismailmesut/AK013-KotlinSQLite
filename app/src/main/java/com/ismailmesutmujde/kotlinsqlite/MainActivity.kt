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
            // create database : Musicians
            val myDatabase = this.openOrCreateDatabase("Musicians", Context.MODE_PRIVATE, null)
            // create table : musicians, columns : name, age
            myDatabase.execSQL("CREATE TABLE IF NOT EXISTS musicians (name VARCHAR, age INT)")
            // insert
            //myDatabase.execSQL("INSERT INTO musicians (name, age) VALUES ('James', 50)")

            val cursor = myDatabase.rawQuery("SELECT * FROM musicians", null)

            val nameIx = cursor.getColumnIndex("name")
            val ageIx = cursor.getColumnIndex("age")

            while (cursor.moveToNext()) {
                println("Name: " + cursor.getString(nameIx))
                println("Age: " + cursor.getInt(ageIx))
            }
            cursor.close()

        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}