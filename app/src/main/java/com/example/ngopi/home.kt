package com.example.ngopi

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.View
import com.example.ngopi.view.MainActivity

class home : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
    }

    fun menu (view: View?) {
    val i = Intent(applicationContext, MainActivity::class.java)
    startActivity(i)

    }
    fun about (view: View?) {
        val i = Intent(applicationContext, about::class.java)
        startActivity(i)

    }
    fun onprofile (view: View?) {
        val i = Intent(applicationContext, onprofile::class.java)
        startActivity(i)

    }
    fun status (view: View?) {
        val i = Intent(applicationContext, statusorder::class.java)
        startActivity(i)

    }
    fun login2 (view: View?) {
        val i = Intent(applicationContext, login2::class.java)
        startActivity(i)

    }
    fun payment (view: View?) {
        val i = Intent(applicationContext, payment::class.java)
        startActivity(i)

    }

}