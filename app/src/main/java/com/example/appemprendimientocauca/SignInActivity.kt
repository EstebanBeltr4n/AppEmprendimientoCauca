package com.example.appemprendimientocauca

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.R
import com.example.appemprendimientocauca.R.layout

class SignInActivity : AppCompatActivity() {

    private lateinit var emailEditText: EditText
    private lateinit var passwordEditText: EditText
    private lateinit var signInButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //Se nececita corregir esta parte del codigo
        setContentView(R.layout.custom_dialog)

        emailEditText = findViewById(R.id.text)
        passwordEditText = findViewById(R.id.text2)
        signInButton = findViewById(R.id.edit_text_id)

        signInButton.setOnClickListener {
            val email = emailEditText.text.toString()
            val password = passwordEditText.text.toString()

            if (validateInput(email, password)) {
                signIn(email, password)
            } else {
                Toast.makeText(this, "Por favor, verifica tus credenciales", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun validateInput(email: String, password: String): Boolean {
        return !(email.isEmpty() || password.isEmpty())
    }

    private fun signIn(email: String, password: String) {

        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()
    }
}