package com.pindex.main.home

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.RecyclerView
import com.pindex.main.R
import com.pindex.main.decorators.MarginItemDecoration

class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val itemsList = Datasource(this).getItemsList()

        val recyclerView: RecyclerView = findViewById(R.id.recycler_view)
        recyclerView.addItemDecoration(MarginItemDecoration(
                resources.getDimension(R.dimen.default_padding).toInt()))
        val adapter = ItemAdapter(itemsList)
        recyclerView.adapter = adapter

        adapter.onItemClick = { word ->
            val intent = Intent(this, TourActivity::class.java)
            intent.putExtra("title", word)
            startActivity(intent)
        }
    }

}