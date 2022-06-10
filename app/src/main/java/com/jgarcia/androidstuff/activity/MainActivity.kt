package com.jgarcia.androidstuff.activity

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.jgarcia.androidstuff.broadcast_receiver.BroadcastReceiverActivity
import com.jgarcia.androidstuff.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private var _activityMainBinding: ActivityMainBinding? = null
    private val activityMainBinding: ActivityMainBinding get() = _activityMainBinding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _activityMainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(activityMainBinding.root)
        setListeners()
    }

    private fun setListeners() {
        activityMainBinding.broadcast.setOnClickListener {
            startActivity(Intent(this, BroadcastReceiverActivity::class.java))
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _activityMainBinding = null
    }
}