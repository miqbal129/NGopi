package com.example.ngopi

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class onprofile : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_onprofile)
    }
    fun profile(view: View?) {
        val i = Intent(applicationContext, profile::class.java)
        startActivity(i)
    }
    fun home(view: View?) {
        val i = Intent(applicationContext, home::class.java)
        startActivity(i)
    }
}