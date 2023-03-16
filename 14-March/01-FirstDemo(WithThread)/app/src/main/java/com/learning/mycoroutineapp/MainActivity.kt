package com.learning.mycoroutineapp

import android.content.ContentValues.TAG
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import kotlin.concurrent.thread

// step 1:- here we create our blocking code or generate blocking scenario
class MainActivity : AppCompatActivity()
{
    lateinit var  couterText:TextView
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        couterText=findViewById(R.id.counter)
        Log.d(TAG,"${Thread.currentThread().name}")
    }

    fun updateCounter(view:View)
    {
        Log.d(TAG,"${Thread.currentThread().name}")
        couterText.text="${couterText.text.toString().toInt()+1}"
    }

    private fun executeLongRunningTask()
    {
        for(i in 1..100000L)
        {

        }
    }

    fun doAction(view: View)
    {
        thread (start=true)
        {
            executeLongRunningTask()
        }
    }
}