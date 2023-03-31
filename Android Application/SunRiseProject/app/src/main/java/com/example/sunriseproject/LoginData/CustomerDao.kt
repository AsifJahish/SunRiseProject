package com.example.sunriseproject.LoginData

import androidx.room.Dao
import androidx.room.Insert

@Dao
interface CustomerDao {

    @Insert
    fun insert(customer: Customer)

}