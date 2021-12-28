package com.zkathi.grocerylist.ui.grocerylist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.setFragmentResultListener
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.zkathi.grocerylist.R
import com.zkathi.grocerylist.ui.GroceryFragment
import com.zkathi.grocerylist.ui.MainActivity
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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setFragmentResultListener(MainActivity.ADD_TASK_REQUEST_KEY) { _, bundle ->
            val isAdded = bundle.getBoolean(MainActivity.ADD_TASK_IS_ADDED)
            if (isAdded) {
                viewModel.refreshList()
            }
        }
    }

}