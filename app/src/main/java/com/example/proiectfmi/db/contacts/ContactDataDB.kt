package com.example.proiectfmi.db.contacts

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.proiectfmi.BuildConfig.VERSION_CODE

@Database(entities = [ContactData::class], version = VERSION_CODE, exportSchema = false)
abstract class ContactDataRoomDatabase : RoomDatabase() {
    abstract fun contactDataDao(): ContactDataDao
}