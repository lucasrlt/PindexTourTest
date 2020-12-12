package com.pindex.main.home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView
import com.pindex.main.R

class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val itemsList = Datasource(this).getItemsList()

        val recyclerView: RecyclerView = findViewById(R.id.recycler_view)
        recyclerView.adapter = ItemAdapter(itemsList)
    }

}