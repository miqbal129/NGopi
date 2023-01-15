package com.example.ngopi

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class onboard3 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_onboard3)
    }
    fun login2(view: View?) {
        val i = Intent(applicationContext, login2::class.java)
        startActivity(i)
    }
}