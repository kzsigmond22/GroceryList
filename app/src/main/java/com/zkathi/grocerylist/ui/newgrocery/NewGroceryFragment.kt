package com.zkathi.grocerylist.ui.newgrocery

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.View
import android.view.ViewGroup
import com.zkathi.grocerylist.R
import com.zkathi.grocerylist.ui.GroceryFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class NewGroceryFragment : GroceryFragment() {

    companion object {
        fun newInstance() = NewGroceryFragment()
    }

    private lateinit var viewModel: NewGroceryViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        return inflater.inflate(R.layout.new_grocery_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this)[NewGroceryViewModel::class.java]
    }
}