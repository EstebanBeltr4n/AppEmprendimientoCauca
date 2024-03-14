package com.example.appemprendimientocauca

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class EditProfileActivity : AppCompatActivity() {

    private lateinit var nameEditText: EditText
    private lateinit var emailEditText: EditText
    private lateinit var saveButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_profile)

        //nameEditText = findViewById(R.id.nameEditText)
        //emailEditText = findViewById(R.id.emailEditText)
        //saveButton = findViewById(R.id.saveButton)

        // Obtén los datos actuales del usuario desde una base de datos o una API
        //val user = getCurrentUser()
        //nameEditText.setText(user.name)
        //emailEditText.setText(user.email)

        saveButton.setOnClickListener {
            val name = nameEditText.text.toString()
            val email = emailEditText.text.toString()

            if (validateInput(name, email)) {
                saveChanges(name, email)
            } else {
                Toast.makeText(this, "Por favor, verifica tus datos", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun validateInput(name: String, email: String): Boolean {
        return !(name.isEmpty() || email.isEmpty())
    }

    private fun saveChanges(name: String, email: String) {

        finish()
    }
}


