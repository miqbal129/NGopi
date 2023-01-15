package com.example.ngopi

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class payment : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_payment)
    }
    fun menu(view: View?) {
        val i = Intent(applicationContext, Menu::class.java)
        startActivity(i)
    }
    fun status(view: View?) {
        val i = Intent(applicationContext, statusorder::class.java)
        startActivity(i)
    }
}