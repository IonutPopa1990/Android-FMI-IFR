package com.example.proiectfmi.ui.actions

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ActionsViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "Actiuni"
    }

    val text: LiveData<String> = _text
}