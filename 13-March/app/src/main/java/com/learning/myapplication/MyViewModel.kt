package com.learning.myapplication

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import java.text.SimpleDateFormat
import java.util.*

class MyViewModel : ViewModel()
{
    var timeStringMutableLiveData = MutableLiveData<String>()
    var dateStringMutableLiveData = MutableLiveData<String>()

    fun getMyTimeString()
    {
        val currentDateTime = Calendar.getInstance().time
        val dateFormatter = SimpleDateFormat.getDateInstance()
        val timeFormatter = SimpleDateFormat.getTimeInstance()

        dateStringMutableLiveData.value=(dateFormatter.format(currentDateTime))
        timeStringMutableLiveData.value=(timeFormatter.format(currentDateTime))
    }
}