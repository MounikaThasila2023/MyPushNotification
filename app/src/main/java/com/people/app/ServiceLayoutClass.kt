package com.people.app

import android.annotation.SuppressLint
import android.content.Intent
import android.media.MediaPlayer
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class ServiceLayoutClass : AppCompatActivity(), View.OnClickListener {

    //      Service Implementation example
    private var start: Button? = null
    private var stop: Button? = null

    lateinit var mediaPlayerObject: MediaPlayer
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        Log.e("onCreate()","In MainActivity is executed")
        super.onCreate(savedInstanceState)
        setContentView(R.layout.service_example)

        start = findViewById(R.id.start_media)
        stop = findViewById(R.id.stop_media)

        start!!.setOnClickListener(this)
        stop!!.setOnClickListener(this)
    }

    override fun onClick(view: View?) {
        if (view === start) {
            Log.e("onClick()"," MainActivity start is executed")
            startService(Intent(this, ServiceLifeCycleMusicPlayer::class.java))
        } else if (view === stop) {
            Log.e("onClick()","MainActivity stop is executed")
            stopService(Intent(this, ServiceLifeCycleMusicPlayer::class.java))
        }
    }
}