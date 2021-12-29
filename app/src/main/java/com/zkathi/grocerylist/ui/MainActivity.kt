package com.zkathi.grocerylist.ui

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.navigation.Navigation
import com.zkathi.grocerylist.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    companion object {
        const val ADD_TASK_REQUEST_KEY = "AddTaskRequestKey"
        const val ADD_TASK_IS_ADDED = "AddTaskIsAdded"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem) = when (item.itemId) {
        R.id.action_add_grocery -> {
            val controller = Navigation.findNavController(this, R.id.nav_host_fragment)
            controller.navigate(R.id.action_groceryListFragment_to_newGroceryFragment)
            true
        }
        else -> {
            super.onOptionsItemSelected(item)
        }
    }
}