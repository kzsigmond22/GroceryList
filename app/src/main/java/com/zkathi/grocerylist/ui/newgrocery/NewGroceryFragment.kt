package com.zkathi.grocerylist.ui.newgrocery

import android.R.attr.data
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.zkathi.grocerylist.R
import com.zkathi.grocerylist.databinding.NewGroceryFragmentBinding
import com.zkathi.grocerylist.ui.GroceryFragment
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class NewGroceryFragment : GroceryFragment() {

    companion object {
        fun newInstance() = NewGroceryFragment()
    }

    private lateinit var viewModel: NewGroceryViewModel
    private lateinit var binding: NewGroceryFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding = DataBindingUtil.inflate<NewGroceryFragmentBinding>(
            inflater, R.layout.new_grocery_fragment, container, false
        )
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this)[NewGroceryViewModel::class.java]
        binding.lifecycleOwner = this
        binding.viewmodel = viewModel
    }
}