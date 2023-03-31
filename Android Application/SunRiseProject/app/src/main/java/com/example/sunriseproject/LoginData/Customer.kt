package com.example.sunriseproject.LoginData

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Customer")
data class Customer(
    @PrimaryKey(autoGenerate = true)
    val id: Int?,
    @ColumnInfo(name = "name") val name: String?,
    @ColumnInfo(name = "Email") val email: String?,
    @ColumnInfo(name = "address") val address: String?,
    @ColumnInfo(name = "PhoneNumber") val phoneNumber: Int?,
    @ColumnInfo(name = "password") val password: String?

)