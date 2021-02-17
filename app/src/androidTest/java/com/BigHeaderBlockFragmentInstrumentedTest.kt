package com

import androidx.core.os.bundleOf
import androidx.fragment.app.testing.launchFragment
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.pindex.main.ui.fragments.blocks.BigHeaderBlockFragment
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class BigHeaderBlockFragmentInstrumentedTest {

    @Test
    fun testBigHeaderBlockFragment() {
        val fragmentArgs = bundleOf("title" to "Street Parade 2021")
        val scenario = launchFragment<BigHeaderBlockFragment>(fragmentArgs)
    }

}