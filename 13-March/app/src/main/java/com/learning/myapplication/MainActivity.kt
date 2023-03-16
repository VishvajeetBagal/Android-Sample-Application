package com.learning.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.TextView
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class MainActivity : AppCompatActivity()
{
    // Take 2 TextView for display date and time
    private lateinit var dateTextView: TextView
    private lateinit var timeTextView: TextView

    // viewModel la nintr initialize krto
    private lateinit var viewModel: MyViewModel

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel=ViewModelProvider(this).get(MyViewModel::class.java)

        // attach text view
        dateTextView = findViewById(R.id.idTVCurrentDate)
        timeTextView = findViewById(R.id.idTVCurrentTime)

        viewModel.timeStringMutableLiveData.observe(this) { time ->
            timeTextView.text = time.toString()
        }

        viewModel.dateStringMutableLiveData.observe(this){date->
            dateTextView.text=date.toString()
        }

        val handler = Handler(Looper.getMainLooper())
        // posts a Runnable to the message queue
        handler.post(object : Runnable
        {
            //  run() will be called by the handler every 1 second
            override fun run()
            {
                handler.postDelayed(this, 1000)
                viewModel.getMyTimeString()
            }
        })
    }
}
