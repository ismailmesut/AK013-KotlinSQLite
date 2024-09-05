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
            myDatabase.execSQL("CREATE TABLE IF NOT EXISTS musicians (id INTEGER PRIMARY KEY, name VARCHAR, age INT)")
            // insert
            //myDatabase.execSQL("INSERT INTO musicians (name, age) VALUES ('James', 50)")
            //myDatabase.execSQL("INSERT INTO musicians (name, age) VALUES ('Lars', 60)")
            //myDatabase.execSQL("INSERT INTO musicians (name, age) VALUES ('Kirk', 55)")

            // update
            //myDatabase.execSQL("UPDATE musicians SET age = 61 WHERE name = 'Lars'")
            //myDatabase.execSQL("UPDATE musicians SET name = 'Kirk Hammett' WHERE id = 3")

            // delete
            //myDatabase.execSQL("DELETE FROM musicians WHERE name ='Lars'")

            // filtering
            val cursor = myDatabase.rawQuery("SELECT * FROM musicians", null)
            //val cursor = myDatabase.rawQuery("SELECT * FROM musicians WHERE name = 'James'", null)
            //val cursor = myDatabase.rawQuery("SELECT * FROM musicians WHERE id = 3", null)
            //val cursor = myDatabase.rawQuery("SELECT * FROM musicians WHERE name LIKE '%s'", null)
            //val cursor = myDatabase.rawQuery("SELECT * FROM musicians WHERE name LIKE 'K%'", null)

            val idIx = cursor.getColumnIndex("id")
            val nameIx = cursor.getColumnIndex("name")
            val ageIx = cursor.getColumnIndex("age")

            while (cursor.moveToNext()) {
                println("Id: " + cursor.getInt(idIx))
                println("Name: " + cursor.getString(nameIx))
                println("Age: " + cursor.getInt(ageIx))
            }
            cursor.close()

        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}