package com.pindex.main

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

/**
 * This class is used by Hilt in order to
 * inject dependencies.
 */
@HiltAndroidApp
class MainApplication : Application() {
}