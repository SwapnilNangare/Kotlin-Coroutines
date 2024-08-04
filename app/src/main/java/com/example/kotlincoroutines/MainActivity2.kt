package com.example.kotlincoroutines

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.job
import kotlinx.coroutines.launch

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        CoroutineScope(Dispatchers.IO).launch {
            printFollowers()
        }
    }

    private suspend fun printFollowers() {

        /*      val fb = CoroutineScope(Dispatchers.IO).async {
            getFbFollowers()

        }
        Log.d("TAG", "printFollowers: ${fb.await()}")
    }

*/

        CoroutineScope(Dispatchers.IO).launch {
            var fb = async { getFbFollowers() }
            var insta = async { getInstaFollowers() }
            Log.d("TAG", "FB - ${fb.await()}, Insta- ${insta.await()}")
        }


    }

    private suspend fun getFbFollowers(): Int {
        delay(1000)
        return 54
    }

    private suspend fun getInstaFollowers(): Int {
        delay(1000)
        return 111
    }
}