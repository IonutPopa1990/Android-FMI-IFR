package com.example.proiectfmi.db.contacts;

import java.lang.System;

@androidx.room.Dao()
@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\'J\u0014\u0010\u0004\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u0005H\'J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u0007H\'\u00a8\u0006\n"}, d2 = {"Lcom/example/proiectfmi/db/contacts/ContactDataDao;", "", "deleteAll", "", "getAll", "Landroidx/lifecycle/LiveData;", "", "Lcom/example/proiectfmi/db/contacts/ContactData;", "insert", "contact", "app_debug"})
public abstract interface ContactDataDao {
    
    @androidx.room.Insert()
    public abstract void insert(@org.jetbrains.annotations.NotNull()
    com.example.proiectfmi.db.contacts.ContactData contact);
    
    @androidx.room.Query(value = "DELETE FROM contact_table")
    public abstract void deleteAll();
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Query(value = "SELECT * FROM contact_table ORDER BY lastName ASC")
    public abstract androidx.lifecycle.LiveData<java.util.List<com.example.proiectfmi.db.contacts.ContactData>> getAll();
}