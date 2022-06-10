package com.example.proiectfmi.db.contacts;

import java.lang.System;

@androidx.room.Database(entities = {com.example.proiectfmi.db.contacts.ContactData.class}, version = com.example.proiectfmi.BuildConfig.VERSION_CODE, exportSchema = false)
@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\'\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H&\u00a8\u0006\u0005"}, d2 = {"Lcom/example/proiectfmi/db/contacts/ContactDataRoomDatabase;", "Landroidx/room/RoomDatabase;", "()V", "contactDataDao", "Lcom/example/proiectfmi/db/contacts/ContactDataDao;", "app_debug"})
public abstract class ContactDataRoomDatabase extends androidx.room.RoomDatabase {
    
    public ContactDataRoomDatabase() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.example.proiectfmi.db.contacts.ContactDataDao contactDataDao();
}