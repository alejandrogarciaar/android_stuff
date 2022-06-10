package com.jgarcia.androidstuff.broadcast_receiver

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.jgarcia.androidstuff.broadcast_receiver.ExampleBroadcastReceiver.Companion.EXAMPLE_1_USER_ID
import com.jgarcia.androidstuff.broadcast_receiver.ExampleBroadcastReceiver.Companion.EXAMPLE_1_USER_NAME
import com.jgarcia.androidstuff.databinding.ActivityBroadcastReceiverBinding

class BroadcastReceiverActivity : AppCompatActivity() {

    // View Binding
    private var _activityBroadcastReceiverBinding: ActivityBroadcastReceiverBinding? = null
    private val activityBroadcastReceiverBinding: ActivityBroadcastReceiverBinding get() = _activityBroadcastReceiverBinding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _activityBroadcastReceiverBinding = ActivityBroadcastReceiverBinding.inflate(layoutInflater)
        setContentView(activityBroadcastReceiverBinding.root)
        setListeners()
    }

    private fun setListeners() {
        activityBroadcastReceiverBinding.startExample1.setOnClickListener {
            // Explicit Intent - No definition in AndroidManifest.xml
            val intent = Intent(this, ExampleBroadcastReceiver::class.java)
            // Another alternative
            // intent.setClass(this, ExampleBroadcastReceiver::class.java)
            // @Deprecated, Beginning Android 8.0, the system imposes additional restrictions on manifest-declared receivers.
            // intent.action = EXAMPLE_1_INTENT_FILTER
            intent.putExtras(getDefaultBundle())
            sendBroadcast(intent)
        }
    }

    private fun getDefaultBundle(): Bundle {
        return Bundle().apply {
            putString(EXAMPLE_1_USER_ID, "4324LXsS1")
            putString(EXAMPLE_1_USER_NAME, "Pepito Perez")
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _activityBroadcastReceiverBinding = null
    }
}
