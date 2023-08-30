package com.people.app

import android.app.Service
import android.content.Intent
import android.media.MediaPlayer
import android.os.IBinder
import android.util.Log
import android.widget.Toast

class ServiceLifeCycleMusicPlayer : Service(){


    lateinit var mediaPlayerObject: MediaPlayer
    var ringToneURL : String = "https://www.prokerala.com/downloads/ringtones/download.php?id=60462"

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        Log.e("onStartCommand()","is executed")

        Log.e("This is Thread","onStartCommand() is executed"+ Thread.currentThread())
//        mediaPlayerObject = MediaPlayer.create(this, Settings.System.DEFAULT_RINGTONE_URI)
        mediaPlayerObject = MediaPlayer.create(this,R.raw.song)
        mediaPlayerObject.isLooping = true
        mediaPlayerObject.start()
        Toast.makeText(this,"Start",Toast.LENGTH_SHORT).show()
        return START_STICKY  // Service will be restarted if it gets killed due to resource constraints
    }

    override fun onDestroy() {
        Log.e("onDestroy()","is executed")
        super.onDestroy()
        mediaPlayerObject.stop()
        Toast.makeText(this,"Stop",Toast.LENGTH_SHORT).show()
    }

    override fun onBind(intent: Intent?): IBinder? { // We don't need a bound service, so we return null
        Log.e("onBind()","is executed")
        return null
    }

}