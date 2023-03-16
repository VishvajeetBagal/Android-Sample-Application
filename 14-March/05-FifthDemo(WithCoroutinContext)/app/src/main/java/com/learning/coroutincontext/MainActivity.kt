package com.learning.coroutincontext

import android.os.AsyncTask.execute
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity()
{
    private val TAG : String = "Coroutine"
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        GlobalScope.launch(Dispatchers.Main) {
            execute()
        }

    }
    private suspend fun execute()
    {
        val parentJob = GlobalScope.launch(Dispatchers.Main) {
            Log.d(TAG,"Parent - $coroutineContext")

            val childJob = launch(Dispatchers.IO) {
                Log.d(TAG,"Child - $coroutineContext")
            }
        }
    }


}