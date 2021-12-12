package com.materialuiux.navigation_components_example

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController

class MainActivity : AppCompatActivity() {

    private val navController by lazy {
        findNavController(R.id.flowHostFragment)
    }

    // If no custom behavior was handled perform the default action.
    val appBarConfiguration by lazy {
        AppBarConfiguration(navController.graph)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // This line is only necessary if using the default action bar.
        setupActionBarWithNavController(navController, appBarConfiguration)
    }

    /**
     * If using the default action bar this must be overridden.
     * This will handle back actions initiated by the the back arrow
     * at the start of the action bar.
     */
    override fun onSupportNavigateUp(): Boolean {
        // Handle the back button event and return true to override
        // the default behavior the same way as the OnBackPressedCallback.
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }
}