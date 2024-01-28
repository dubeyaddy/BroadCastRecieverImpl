package com.practiceapp.powerreciever

import android.content.Intent
import android.content.IntentFilter
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.localbroadcastmanager.content.LocalBroadcastManager
import com.example.toastlibrary.toastFile.ToastMessage
import com.practiceapp.powerreciever.customreciver.CustomReceiver

class MainActivity : AppCompatActivity() {
    private val mReceiver = CustomReceiver()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val toastMessage: ToastMessage? = null;
        if (toastMessage != null) {
            toastMessage.showMessageInToast(this, "Welcome in the app.")
        }
        val filter = IntentFilter()
        filter.addAction(Intent.ACTION_POWER_CONNECTED)
        filter.addAction(Intent.ACTION_POWER_DISCONNECTED)
        this.registerReceiver(mReceiver, filter)
        LocalBroadcastManager.getInstance(this).registerReceiver(
            mReceiver, IntentFilter(
                ACTION_CUSTOM_BROADCAST
            )
        )


    }

    override fun onDestroy() {
        unregisterReceiver(mReceiver)
        super.onDestroy()
        LocalBroadcastManager.getInstance(this).unregisterReceiver(mReceiver)
    }

    fun sendCustomBroadcast(view: View?) {
        val customBroadcastIntent = Intent(ACTION_CUSTOM_BROADCAST)
        LocalBroadcastManager.getInstance(this).sendBroadcast(customBroadcastIntent)
    }

    companion object {
        private const val ACTION_CUSTOM_BROADCAST =
            BuildConfig.APPLICATION_ID + ".ACTION_CUSTOM_BROADCAST"
    }
}