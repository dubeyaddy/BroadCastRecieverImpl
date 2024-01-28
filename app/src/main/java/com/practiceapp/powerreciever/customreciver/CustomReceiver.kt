package com.practiceapp.powerreciever.customreciver

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast
import com.practiceapp.powerreciever.BuildConfig

class CustomReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context, intent: Intent) {
        val intentAction = intent.action
        if (intentAction != null) {
            var toastMessage = "unknown intent action"
            when (intentAction) {
                Intent.ACTION_POWER_CONNECTED -> toastMessage = "Power Connected"
                Intent.ACTION_POWER_DISCONNECTED -> toastMessage = "Power Disconnected"
                ACTION_CUSTOM_BROADCAST -> toastMessage = "Custom Broadcast Sent"
            }
            Toast.makeText(context, toastMessage, Toast.LENGTH_SHORT).show()
        }
    }

    companion object {
        private const val ACTION_CUSTOM_BROADCAST =
            BuildConfig.APPLICATION_ID + ".ACTION_CUSTOM_BROADCAST"
    }
}