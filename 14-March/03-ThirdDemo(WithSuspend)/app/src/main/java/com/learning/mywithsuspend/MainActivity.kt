package com.learning.mywithsuspend

import android.content.ContentValues.TAG
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.coroutines.*

class MainActivity : AppCompatActivity()
{
    private val TAG : String = "Coroutine"
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        CoroutineScope(Dispatchers.Main).launch {
            task1()
        }

        CoroutineScope(Dispatchers.Main).launch {
            task2()
        }
    }

    suspend fun task1()
    {
        Log.d(TAG,"Starting Task1")
        // Coroutine la suspend krnar aani aajun Coroutine aahe ka
        // check karun to execution la ghetla jato
        //yield()

        // delay() he function pn suspentation point mhanun use karu shakto
        delay(1000)
        Log.d(TAG,"Ending Task1")
    }


    suspend fun task2()
    {
        Log.d(TAG,"Starting Task2")
       //yield()
        delay(2000)
        Log.d(TAG,"Ending Task2")
    }
}