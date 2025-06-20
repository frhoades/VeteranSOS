package com.example.veteransos.services

import android.app.*
import android.content.Context
import android.content.Intent
import android.os.IBinder
import com.example.veteransos.PanicActivity

class PanicService : Service() {

    override fun onCreate() {
        super.onCreate()
        sendTestNotification()
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        sendTestNotification()
        return START_STICKY
    }

    private fun sendTestNotification() {
        val notificationIntent = Intent(this, PanicActivity::class.java)
        val pendingIntent = PendingIntent.getActivity(this, 0, notificationIntent, PendingIntent.FLAG_IMMUTABLE)

        val notification = Notification.Builder(this, "panic_channel")
            .setContentTitle("Test Panic Trigger")
            .setContentText("Tap to simulate a panic event.")
            .setSmallIcon(android.R.drawable.ic_dialog_alert)
            .setContentIntent(pendingIntent)
            .build()

        val manager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        val channel = NotificationChannel("panic_channel", "Panic Alerts", NotificationManager.IMPORTANCE_HIGH)
        manager.createNotificationChannel(channel)
        startForeground(1, notification)
    }

    override fun onBind(intent: Intent?): IBinder? = null
}