package com.pindex.main.home

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.RecyclerView
import com.pindex.main.R
import com.pindex.main.decorators.MarginItemDecoration

class HomeActivity : AppCompatActivity() {

    private lateinit var itemsList: Array<String>
    private lateinit var adapter: ItemAdapter
    private lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupData()

        setRecyclerViewOnItemClick()
    }

    // Setup the main activity data
    private fun setupData() {
        // Get fake data from a XML file
        itemsList = Datasource(this).getItemsList()

        // Create the adapter
        adapter = ItemAdapter(itemsList)

        // Find the recycler view and bind it to the adapter
        recyclerView = findViewById(R.id.recycler_view)
        recyclerView.addItemDecoration(MarginItemDecoration(
                resources.getDimension(R.dimen.default_padding).toInt()))
        recyclerView.adapter = adapter
    }

    // Set the on click event to the recycler view items
    private fun setRecyclerViewOnItemClick() {
        adapter.onItemClick = { word ->
            val intent = Intent(this, TourActivity::class.java)
            intent.putExtra("title", word)

            // Display the tour activity
            startActivity(intent)
        }
    }

}