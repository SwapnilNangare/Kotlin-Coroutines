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

class MainActivity3 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)

        GlobalScope.launch(Dispatchers.Main) {
            execute()
        }
    }

    private suspend fun execute() {

        val parentJob = GlobalScope.launch(Dispatchers.Main) {
            Log.d("TAG", "Parent Started ")

            val childJob = launch(Dispatchers.IO) {
                Log.d("TAG", "Child Job Started ")
                delay(5000)
                Log.d("TAG", "Child Job Ended  ")


            }
            delay(3000)
            Log.d("TAG", "Child Job Cancelled ")
            childJob.cancel()
            Log.d("TAG", "Parent Ended ")
        }
        delay(1000)
        //  parentJob.cancel()
        parentJob.join()
        Log.d("TAG", "Parent Completed")

    }


    private suspend fun executeLongRunningTask() {

    }
}