package com.example.sunriseproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.room.Room
import com.example.sunriseproject.LoginData.Customer
import com.example.sunriseproject.LoginData.LoginDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class Register : AppCompatActivity() {
    lateinit var emailEdit: EditText
    lateinit var nameEdit: EditText
    lateinit var addressEdit: EditText
    lateinit var passwordEdit: EditText
    lateinit var phoneNumber: EditText
    lateinit var logindata: LoginDatabase
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)




        logindata = Room.databaseBuilder(applicationContext, LoginDatabase::class.java, "Customer").build()

        val sign1 = findViewById<Button>(R.id.register1)
        emailEdit = findViewById(R.id.email)
        nameEdit = findViewById(R.id.name)
        addressEdit = findViewById(R.id.address)
        passwordEdit = findViewById(R.id.password)
        phoneNumber= findViewById(R.id.number)
        sign1.setOnClickListener {
            if (validateInputs()) {
                val customer = Customer(
                    id = null,
                    name = nameEdit.text.toString(),
                    email = emailEdit.text.toString(),
                    address = addressEdit.text.toString(),
                    phoneNumber= phoneNumber.text.toString().toInt(),
                    password = passwordEdit.text.toString()
                )
                saveCustomer(customer)
                Toast.makeText(this, "Your data has been saved", Toast.LENGTH_SHORT).show()
                val intent = Intent(this, Login::class.java)
                startActivity(intent)
            } else {
                Toast.makeText(this, "Please fill all the fields", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun validateInputs(): Boolean {
        return !emailEdit.text.toString().trim().isEmpty() &&
                !nameEdit.text.toString().trim().isEmpty() &&
                !addressEdit.text.toString().trim().isEmpty() &&
                !phoneNumber.text.toString().trim().isEmpty()&&
                !passwordEdit.text.toString().trim().isEmpty()
    }

    private fun saveCustomer(customer: Customer) {
        CoroutineScope(Dispatchers.IO).launch {
            logindata.CustomerDao().insert(customer)
        }
    }

    override fun onDestroy() {
        logindata.close()
        super.onDestroy()
    }
}