package com.example.sunriseproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val login= findViewById<Button>(R.id.login)
        val register= findViewById<Button>(R.id.register)

        login.setOnClickListener{
            val intent1= Intent(this, Login::class.java)
            startActivity(intent1)
        }
        register.setOnClickListener{
            val intent2= Intent(this, Register::class.java)
            startActivity(intent2)
        }
    }
}