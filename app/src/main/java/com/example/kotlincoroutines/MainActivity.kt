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
import kotlin.concurrent.thread

class MainActivity : AppCompatActivity() {
    lateinit var clickButton: Button
    var TAG = "Kotlin"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        clickButton = findViewById(R.id.btn)
        Log.d(TAG, "Button CLick ${Thread.currentThread().name}")

        clickButton.setOnClickListener {

            //   Log.d(TAG, "Button CLick ${Thread.currentThread().name}")
        }


    }

    private fun executeLogRunningTask() {
        for (i in 0..10000000000L) {
            Log.d(TAG, "Button CLick ${Thread.currentThread().name}")
        }

    }

    fun doAction(view: View) {

//        thread(start = true) {
//            executeLogRunningTask()
//        }

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


}

