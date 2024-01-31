package amitapps.media.service

import android.app.Service
import android.content.Intent
import android.os.IBinder
import androidx.core.app.NotificationCompat

class ForegroundService : Service() {
    override fun onBind(p0: Intent?): IBinder? {
        return null
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        when(intent?.action) {
            Actions.START.toString() -> start()
            Actions.STOP.toString() -> stopSelf()
        }
        return super.onStartCommand(intent, flags, startId)
    }

    private fun start() {
        val notification = NotificationCompat.Builder(this, "active_notification")
            .setSmallIcon(R.drawable.ic_launcher_foreground)
            .setContentTitle("Service is running")
            .setContentText("Hi foreground service is running, pls play with audio")
            .build()

        startForeground(1, notification)
    }

    enum class Actions {
        START,
        STOP
    }
}