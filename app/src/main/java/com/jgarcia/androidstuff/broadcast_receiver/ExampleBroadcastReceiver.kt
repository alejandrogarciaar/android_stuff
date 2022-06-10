package com.jgarcia.androidstuff.broadcast_receiver

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast

class ExampleBroadcastReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context?, intent: Intent?) {
        intent?.let {
            val userId = it.extras?.getString(EXAMPLE_1_USER_ID)
            val userName = it.extras?.getString(EXAMPLE_1_USER_NAME)
            Toast.makeText(context, "UserId: $userId, UserName: $userName", Toast.LENGTH_LONG).show()
            clearAbortBroadcast()
        }
    }

    companion object {
        const val EXAMPLE_1_USER_ID = "EXAMPLE_1_USER_ID"
        const val EXAMPLE_1_USER_NAME = "EXAMPLE_1_USER_NAME"
    }
}
