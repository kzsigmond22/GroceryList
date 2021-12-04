package com.zkathi.grocerylist.ui.grocerylist

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.zkathi.grocerylist.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class GroceryListFragment : Fragment() {

    companion object {
        fun newInstance() = GroceryListFragment()
    }

    private lateinit var viewModel: GroceryListViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.main_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this).get(GroceryListViewModel::class.java)
    }

}