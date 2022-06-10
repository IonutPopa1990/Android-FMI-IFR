package com.example.proiectfmi.db.contacts

import android.text.Editable
import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "contact_table")
data class ContactData(

    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "lastName")
    val lastName: String,

    @NonNull
    @ColumnInfo(name = "firstName")
    val firstName: String

)