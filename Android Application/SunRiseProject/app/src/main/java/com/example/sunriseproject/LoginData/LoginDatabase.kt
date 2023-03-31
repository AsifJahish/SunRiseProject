package com.example.sunriseproject.LoginData

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Customer :: class], version = 1,)
abstract class LoginDatabase : RoomDatabase() {

    abstract fun CustomerDao() : CustomerDao

    companion object{

        @Volatile
        private var INSTANCE : LoginDatabase? = null

        fun LoginDatabase(context: Context): LoginDatabase{

            val tempInstance = INSTANCE
            if(tempInstance != null){
                return tempInstance
            }
            synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    LoginDatabase::class.java,
                    "Customer"
                ).build()
                INSTANCE = instance
                return instance
            }

        }

    }

}