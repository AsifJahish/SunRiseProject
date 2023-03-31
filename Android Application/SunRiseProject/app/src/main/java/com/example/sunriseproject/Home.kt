package com.example.sunriseproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class Home : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        val contact= findViewById<Button>(R.id.contact)
        val order = findViewById<Button>(R.id.order)
        val research= findViewById<Button>(R.id.research)
        contact.setOnClickListener {
            val intent= Intent(this, Contact::class.java)
            startActivity(intent)

        }
        order.setOnClickListener {
            val intent1= Intent(this, Order::class.java)
            startActivity(intent1)

        }
        research.setOnClickListener {
            val intent2= Intent(this, Research::class.java)
            startActivity(intent2)
        }
    }
}