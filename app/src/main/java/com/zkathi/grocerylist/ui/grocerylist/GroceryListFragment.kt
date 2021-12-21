package com.zkathi.grocerylist.ui.grocerylist

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.zkathi.grocerylist.R
import com.zkathi.grocerylist.ui.GroceryFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class GroceryListFragment : GroceryFragment() {

    private lateinit var viewModel: GroceryListViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.fragment_grocery_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this)[GroceryListViewModel::class.java]
        val adapter = GroceryListAdapter()
        val list = view.findViewById<RecyclerView>(R.id.grocery_list_main_list)
        list.adapter = adapter
        viewModel.groceries.observe(viewLifecycleOwner) { groceries ->
            adapter.updateList(groceries)
        }
    }

}