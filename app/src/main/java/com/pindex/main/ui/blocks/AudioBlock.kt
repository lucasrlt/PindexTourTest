package com.pindex.main.ui.blocks

import android.content.Context
import android.media.AudioAttributes
import android.media.MediaPlayer
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.FrameLayout
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatImageView
import com.pindex.main.R
import com.pindex.main.utils.MediaLoader

/**
 * Custom View for the Audio block.
 */
class AudioBlock @JvmOverloads constructor(
        audioName: String?,
        audioPath: String?,
        imagePath: String?,
        context: Context,
        attrs: AttributeSet? = null,
        defStyle: Int = 0
) : FrameLayout(context, attrs, defStyle) {

    // Background image
    private val imageView: AppCompatImageView

    // Button (icon + text)
    private val buttonView: AppCompatButton

    /**
     * Setup this View components.
     */
    init {
        // Inflate the XML layout to this View
        LayoutInflater.from(context).inflate(R.layout.audio_block, this, true)

        imageView = findViewById(R.id.audio_block_image)
        buttonView = findViewById(R.id.audio_block_button)

        // Set the background image
        MediaLoader.loadImageFromFirebase(imagePath!!, imageView)

        // Set the audio text
        buttonView.text = audioName

        // Set the button on click event
        buttonView.setOnClickListener {
            // Play the audio file
            val mediaPlayer = MediaPlayer().apply {
                setAudioAttributes(
                        AudioAttributes.Builder()
                                .setContentType(AudioAttributes.CONTENT_TYPE_MUSIC)
                                .setUsage(AudioAttributes.USAGE_MEDIA)
                                .build()
                )
                setDataSource(audioPath)
                prepare()
                start()
            }
        }
    }

}
