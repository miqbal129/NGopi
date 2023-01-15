package com.example.ngopi

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.widget.Toast
import com.example.ngopi.databinding.ActivityLogin2Binding
import com.google.firebase.auth.FirebaseAuth

class login2 : AppCompatActivity() {


    lateinit var binding: ActivityLogin2Binding
    lateinit var auth : FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {

        binding = ActivityLogin2Binding.inflate(layoutInflater)

        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        auth = FirebaseAuth.getInstance()

        binding.toregister.setOnClickListener {
            val intent = Intent(this, register::class.java)
            startActivity(intent)
        }

        binding.buttonlogin.setOnClickListener {
            val email = binding.emaillogin.text.toString()
            val password = binding.passwordlogin.text.toString()

            if (email.isEmpty()) {
                binding.emaillogin.error = "Isi Email"
                binding.emaillogin.requestFocus()
                return@setOnClickListener
            }

            if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                binding.emaillogin.error = "Isi Email Terlebih dahulu"
                binding.emaillogin.requestFocus()
                return@setOnClickListener
            }

            if (password.isEmpty()) {
                binding.passwordlogin.error = "Isi Password"
                binding.passwordlogin.requestFocus()
                return@setOnClickListener
            }
            LoginFirebase(email,password)
        }
    }

    private fun LoginFirebase(email: String, password: String) {
        auth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener(this){
                if (it.isSuccessful){
                    Toast.makeText(this, "Welcome Back $email", Toast.LENGTH_SHORT).show()
                    val intent = Intent(this,home   ::class.java)
                    startActivity(intent)
                }else{
                    Toast.makeText(this, "${it.exception?.message}",Toast.LENGTH_SHORT).show()
                }
            }
    }
}