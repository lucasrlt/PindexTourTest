package com.pindex.main.ui.fragments

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.pindex.main.R
import com.pindex.main.adapters.ExperienceAdapter
import com.pindex.main.home.ExperienceActivity
import com.pindex.main.utils.Constants
import com.pindex.main.viewmodels.ExperienceViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

@AndroidEntryPoint
class ExperienceFragment : Fragment(R.layout.fragment_experiences_list) {

    private lateinit var rvActivity: RecyclerView
    private lateinit var viewModel: ExperienceViewModel
    private lateinit var adapter: ExperienceAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Setup the ViewModel and the Adapter
        viewModel = defaultViewModelProviderFactory.create(ExperienceViewModel::class.java)
        adapter = ExperienceAdapter()

        // Setup the RecyclerView
        rvActivity = view.findViewById(R.id.recycler_view)
        rvActivity.layoutManager = LinearLayoutManager(context)
        rvActivity.adapter = adapter

        // Setup the Pager
        lifecycleScope.launch {
            viewModel.flow.collect {
                adapter.submitData(it)
            }
        }

        // Set the on click event to the recycler view items
        setRecyclerViewOnItemClick()
    }

    /**
     * Display the clicked item activity.
     */
    private fun setRecyclerViewOnItemClick() {
        adapter.onItemClick = { experience ->
            val intent = Intent(activity, ExperienceActivity::class.java)
            intent.putExtra(Constants.ACTIVITY_EXPERIENCE_EXTRA_NAME, experience)

            // Display the clicked experience activity
            startActivity(intent)
        }
    }
}
