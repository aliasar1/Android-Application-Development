package com.example.myapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.myapp.models.Credential
import com.example.myapp.models.User
import com.example.myapp.utils.AppPreferences
import com.example.myapp.utils.DataHolder
import com.google.gson.Gson

class HomeActivity  : AppCompatActivity() {
    lateinit var txEmail:TextView
    lateinit var txPassword: TextView

    private lateinit var preferences: AppPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        txEmail = findViewById(R.id.emailTxt)
        txPassword = findViewById(R.id.passTxt)

        preferences = AppPreferences(this)


//        val email = intent.extras?.getString("email")
//        val password = intent.extras?.getString("password")
        //val user = intent.extras?.getSerializable("user") as User
        val user = DataHolder.user
        txEmail.text = user.email
        txPassword.text = user.password

        findViewById<Button>(R.id.logout_btn).setOnClickListener {
            preferences.clearAllData()
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

    }
}