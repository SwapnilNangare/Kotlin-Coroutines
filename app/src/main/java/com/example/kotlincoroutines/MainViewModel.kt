package com.example.kotlincoroutines

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {

    init {
        viewModelScope.launch {

            while (true) {
                delay(500)
                Log.d("TAG", "Hello There ")

            }
        }

    }

    override fun onCleared() {
        super.onCleared()
        Log.d("TAG", "Viewmodel distorted ")
    }
}