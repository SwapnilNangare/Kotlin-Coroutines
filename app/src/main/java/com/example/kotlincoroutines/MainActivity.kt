package com.example.kotlincoroutines

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.yield
import kotlin.concurrent.thread

class MainActivity : AppCompatActivity() {
    lateinit var clickButton: Button
    var TAG = "Kotlin"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        clickButton = findViewById(R.id.btn)

        clickButton.setOnClickListener {

            //   Log.d(TAG, "Button CLick ${Thread.currentThread().name}")
        }

        CoroutineScope(Dispatchers.Main).launch {
            task1()
        }
        CoroutineScope(Dispatchers.Main).launch {
            task2()
        }


    }


    fun doAction(view: View) {

        CoroutineScope(Dispatchers.IO).launch {
            Log.d(TAG, "doAction 1: ${Thread.currentThread().name}")
        }
        GlobalScope.launch(Dispatchers.Main) {
            Log.d(TAG, "doAction 2: ${Thread.currentThread().name}")
        }
        MainScope().launch(Dispatchers.Default) {
            Log.d(TAG, "doAction 3: ${Thread.currentThread().name}")
        }

    }


    suspend fun task1() {
        Log.d(TAG, "STARTING TASK 1")
        yield()
        Log.d(TAG, "ENDING  TASK 1")

    }

    suspend fun task2() {
        Log.d(TAG, "STARTING TASK 2")
        yield()
        Log.d(TAG, "ENDING  TASK 2")

    }


}

