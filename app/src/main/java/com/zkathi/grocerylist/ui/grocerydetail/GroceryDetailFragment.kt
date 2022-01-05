package com.zkathi.grocerylist.ui.grocerydetail

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import com.zkathi.grocerylist.R
import com.zkathi.grocerylist.databinding.FragmentGroceryDetailBinding
import com.zkathi.grocerylist.ui.GroceryFragment

class GroceryDetailFragment : GroceryFragment() {

    private lateinit var viewModel: GroceryDetailViewModel
    private lateinit var binding: FragmentGroceryDetailBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_grocery_detail, container, false
        )
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this)[GroceryDetailViewModel::class.java]
        binding.lifecycleOwner = this
        binding.viewmodel = viewModel
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onPrepareOptionsMenu(menu: Menu) {
        val item: MenuItem? = menu.findItem(R.id.action_add_grocery)
        if (item != null) {
            item.isVisible = false
        }
    }

}