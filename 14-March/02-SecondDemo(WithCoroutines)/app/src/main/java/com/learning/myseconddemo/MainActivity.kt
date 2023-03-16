package com.learning.myseconddemo

import android.content.ContentValues
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import kotlinx.coroutines.*
import kotlin.concurrent.thread

// step 2:- here we create our coroutines with different scopes scenario
class MainActivity : AppCompatActivity()
{
    //private val TAG : String="Coroutines"
    lateinit var  couterText: TextView
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        couterText=findViewById(R.id.counter)
        Log.d(ContentValues.TAG,"${Thread.currentThread().name}")
    }

    fun updateCounter(view: View)
    {
        Log.d(ContentValues.TAG,"${Thread.currentThread().name}")
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
        CoroutineScope(Dispatchers.IO).launch{
            Log.d(ContentValues.TAG,"1-${Thread.currentThread().name}")
        }

        GlobalScope.launch(Dispatchers.Main)
        {
            Log.d(ContentValues.TAG,"2-${Thread.currentThread().name}")
        }
        MainScope().launch(Dispatchers.Default)
        {
            Log.d(ContentValues.TAG,"3-${Thread.currentThread().name}")
        }
    }
}