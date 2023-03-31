package com.example.sunriseproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class Login : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val login1= findViewById<Button>(R.id.login)

        login1.setOnClickListener {
            val intent4= Intent(this, Home::class.java)
            startActivity(intent4)
        }
    }
}