package com.pindex.main.home

import android.content.Context
import com.pindex.main.R

class Datasource(val context: Context) {

    fun getItemsList(): Array<String> {
        return context.resources.getStringArray(R.array.mock_activities_names)

    }

}