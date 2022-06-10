package com.example.proiectfmi.ui.contact_add

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ContactAddViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "Adauga un contact"
    }
    val text: LiveData<String> = _text
}