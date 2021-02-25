package com.pindex.main.home

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.pindex.main.R
import com.pindex.main.auth.PindexFirebase
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Anonymously log in the user to Firebase
        PindexFirebase.signInAnonymously(this)
    }

}