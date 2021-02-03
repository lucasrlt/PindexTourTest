package com.pindex.main.home

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.pindex.main.R

class ExperienceActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_experience)

        // Set the title
        val titleView = findViewById<TextView>(R.id.tour_title)
        val title = intent.getStringExtra("title")

        // Do not display the title when there is none
        if (title?.isBlank()!!) {
            titleView.text = ""
            titleView.visibility = View.GONE
        } else {
            titleView.text = title
            titleView.visibility = View.VISIBLE
        }
    }

}