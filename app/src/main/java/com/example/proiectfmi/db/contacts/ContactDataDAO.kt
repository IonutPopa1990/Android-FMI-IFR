package com.example.proiectfmi.db.contacts

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface ContactDataDao {

    @Insert
    fun insert(contact: ContactData)

    @Query("DELETE FROM contact_table")
    fun deleteAll()

    @Query("SELECT * FROM contact_table ORDER BY lastName ASC")
    fun getAll(): LiveData<List<ContactData>>
}