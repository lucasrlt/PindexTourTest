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

    // Audio player
    private var mediaPlayer: MediaPlayer? = null

    /**
     * Setup this View components.
     */
    init {
        // Inflate the XML layout to this View
        LayoutInflater.from(context).inflate(R.layout.audio_block, this, true)

        imageView = findViewById(R.id.audio_block_image)
        buttonView = findViewById(R.id.audio_block_button)

        // Set the background image
        imagePath?.let {
            MediaLoader.loadImageFromFirebase(imagePath, imageView)
        }

        // Set the audio text
        setAudioText(audioName)

        // Set the button on click event
        buttonView.setOnClickListener {

            // First click: setup the media player
            if (mediaPlayer == null) {

                // Display the loading text
                setAudioText(resources.getString(R.string.loading))

                mediaPlayer = MediaPlayer().apply {

                    // When the audio file is ready
                    setOnPreparedListener {
                        setPauseIcon()
                        // Display the audio name back
                        setAudioText(audioName)

                        start()
                    }

                    // When the audio file ends
                    setOnCompletionListener {
                        setPlayIcon()
                    }

                    // Setup the audio player
                    setAudioAttributes(
                            AudioAttributes.Builder()
                                    .setContentType(AudioAttributes.CONTENT_TYPE_MUSIC)
                                    .setUsage(AudioAttributes.USAGE_MEDIA)
                                    .build()
                    )

                    // Audio file URL
                    setDataSource(audioPath)

                    // To avoid blocking the UI: MediaPlayer.OnPreparedListener is called when ready
                    prepareAsync()
                }
            }
            // Media Player already setup: play/pause
            else {
                mediaPlayer?.let {
                    // Pause
                    if (it.isPlaying) {
                        setPlayIcon()
                        it.pause()
                    }
                    // Play
                    else {
                        setPauseIcon()
                        it.start()
                    }
                }
            }
        }
    }

    /**
     * Display the given [text] in the component.
     */
    private fun setAudioText(text: String?) {
        buttonView.text = text
    }

    /**
     * Display the play icon in the component.
     */
    private fun setPlayIcon() {
        val icon = R.drawable.ic_baseline_play_arrow
        buttonView.setCompoundDrawablesWithIntrinsicBounds(icon, 0, 0, 0)
    }

    /**
     * Display the pause icon in the component.
     */
    private fun setPauseIcon() {
        val icon = R.drawable.ic_baseline_pause
        buttonView.setCompoundDrawablesWithIntrinsicBounds(icon, 0, 0, 0)
    }

}
