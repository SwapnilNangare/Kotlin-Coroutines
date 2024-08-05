package com.example.kotlincoroutines

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivity4 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main4)
        GlobalScope.launch(Dispatchers.Main) {
            executeTask()
        }

    }

    private suspend fun executeTask() {
        Log.d("TAG", "Before")
        withContext(Dispatchers.IO) {
            delay(1000)
            Log.d("TAG", "Inside")

        }
        Log.d("TAG", "After")

    }
}