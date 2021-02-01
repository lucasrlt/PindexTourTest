package com.pindex.main.home

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.pindex.main.R

class TourActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tour)

        val title = intent.getStringExtra("title")
        val titleView = findViewById<TextView>(R.id.tour_title)
        titleView.text = title
    }

}