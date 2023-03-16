package com.learning.mycobuilder

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

        val job= CoroutineScope(Dispatchers.IO).launch{
            printFollowers()

        }
    }

    // with launch
    /*private suspend fun printFollowers()
    {
        var fbFollowers = 0
        var instaFollowers = 0
        val job = CoroutineScope(Dispatchers.IO).launch {
            fbFollowers = getFbFollowers()
        }

        val job2 = CoroutineScope(Dispatchers.IO).launch {
            instaFollowers= getInstaFollowers()
        }
        // job coroutine cha handel aahe ya mule aapan join,stop,wait karu shakto
        // jo prentent varche coroutine complete exetute hot nahi to parent pude kahi
        // execute honar nahi ya mule join()
        job.join()
        job2.join()
        Log.d(TAG,"FB - $fbFollowers, Insta - $instaFollowers") // job complete hot nahi to parent wait kr
    }*/

    // with async() and awit()
   /* private suspend fun printFollowers()
    {
        val fb = CoroutineScope(Dispatchers.IO).async {
            getFbFollowers()
        }

        val insta = CoroutineScope(Dispatchers.IO).async {
            getInstaFollowers()
        }

        Log.d(TAG,"FB - ${fb.await()}, Insta - ${insta.await()}") // job complete hot nahi to parent wait kr
    }*/

    // third approach
    private suspend fun printFollowers()
    {
        CoroutineScope(Dispatchers.IO).launch {
            var fb = async {
                getFbFollowers()
            }
            var insta = async{
                getInstaFollowers()
            }
            Log.d(TAG,"FB - ${fb.await()}, Insta - ${insta.await()}")
        }

    }


    private suspend fun getFbFollowers():Int
    {
        delay(1000)
        return 600
    }

    private suspend fun getInstaFollowers():Int
    {
        delay(1000)
        return 400
    }


}