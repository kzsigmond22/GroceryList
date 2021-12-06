package com.zkathi.grocerylist.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.zkathi.grocerylist.R
import com.zkathi.grocerylist.ui.grocerylist.GroceryListFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, GroceryListFragment.newInstance())
                .commitNow()
        }
    }
}