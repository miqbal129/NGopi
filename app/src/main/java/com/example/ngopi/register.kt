package com.example.ngopi


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.widget.Toast
import com.example.ngopi.databinding.ActivityRegisterBinding
import com.google.firebase.auth.FirebaseAuth


class register : AppCompatActivity() {

    lateinit var binding: ActivityRegisterBinding
    lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {

        binding = ActivityRegisterBinding.inflate(layoutInflater)

        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        auth = FirebaseAuth.getInstance()



        binding.buttonlogin.setOnClickListener {
            val email = binding.emailcreate.text.toString()
            val password = binding.passwordcreate.text.toString()

            if (email.isEmpty()) {
                binding.emailcreate.error = "Isi Email"
                binding.emailcreate.requestFocus()
                return@setOnClickListener
            }

            if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                binding.emailcreate.error = "Diisi Dulu Ngab"
                binding.emailcreate.requestFocus()
                return@setOnClickListener
            }

            if (password.isEmpty()) {
                binding.passwordcreate.error = "Isi Password"
                binding.passwordcreate.requestFocus()
                return@setOnClickListener
            }

            if (password.length < 6) {
                binding.passwordcreate.error = "Password Minimal 8 Karakter"
                binding.passwordcreate.requestFocus()
                return@setOnClickListener
            }

            RegisterFirebase(email,password)

        }

    }

    private fun RegisterFirebase(email: String, password: String) {
        auth.createUserWithEmailAndPassword(email,password)
            .addOnCompleteListener(this){
                if (it.isSuccessful){
                    Toast.makeText(this, "Create Account Berhasil", Toast.LENGTH_SHORT).show()
                    val intent = Intent(this,login2::class.java)
                    startActivity(intent)
                }else{
                    Toast.makeText(this, "${it.exception?.message}",Toast.LENGTH_SHORT).show()
                }
            }
    }
}
