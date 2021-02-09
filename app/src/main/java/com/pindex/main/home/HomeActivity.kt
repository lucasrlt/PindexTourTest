package com.pindex.main.home

import android.media.AudioAttributes
import android.media.MediaPlayer
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.pindex.main.R
import com.pindex.main.auth.PindexFirebase

class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Anonymously log in the user to Firebase
        PindexFirebase.signInAnonymously(this)



        // Test audio

        val playerBtn = findViewById<Button>(R.id.player)
        playerBtn.setOnClickListener {
            /*
            var mediaPlayer = MediaPlayer.create(this, R.raw.acid)
            mediaPlayer.start()
            */

            val url = "https://safmarket.srvz-webapp.he-arc.ch/api/sample/file/1/0"
            val mediaPlayer = MediaPlayer().apply {
                setAudioAttributes(
                    AudioAttributes.Builder()
                        .setContentType(AudioAttributes.CONTENT_TYPE_MUSIC)
                        .setUsage(AudioAttributes.USAGE_MEDIA)
                        .build()
                )
                setDataSource((url))
                prepare()
                start()
            }
        }
    }

}
