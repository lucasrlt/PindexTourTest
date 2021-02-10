package com.pindex.main.home

import android.os.Bundle
import android.widget.FrameLayout
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import com.pindex.main.R
import com.pindex.main.auth.PindexFirebase
import com.pindex.main.models.blocks.AudioBlockDto
import com.pindex.main.ui.blocks.AudioBlock
import com.pindex.main.utils.Converter

class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Anonymously log in the user to Firebase
        PindexFirebase.signInAnonymously(this)



        // Test audio


        val audio: AudioBlockDto = AudioBlockDto(
                "https://safmarket.srvz-webapp.he-arc.ch/api/sample/file/1/0",
                "",
                "Name",
                "sectionTitle"
        )

        var params: FrameLayout.LayoutParams = FrameLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                Converter.dpToPixels(60, this),
        )

        var audioBlock: AudioBlock = AudioBlock(this)
        audioBlock.layoutParams = params

        findViewById<FrameLayout>(R.id.home_view).addView(audioBlock)



        /*
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
         */
    }

}
