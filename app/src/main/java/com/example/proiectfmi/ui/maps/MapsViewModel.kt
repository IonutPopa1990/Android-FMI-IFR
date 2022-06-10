package com.example.proiectfmi.ui.maps

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MapsViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "Adresa din Google Maps"
    }
    val text: LiveData<String> = _text
}