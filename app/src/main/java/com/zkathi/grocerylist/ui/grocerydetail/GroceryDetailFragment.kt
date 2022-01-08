package com.zkathi.grocerylist.ui.grocerydetail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import com.zkathi.grocerylist.R
import com.zkathi.grocerylist.databinding.FragmentGroceryDetailBinding
import com.zkathi.grocerylist.ui.GroceryImageHandlerFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class GroceryDetailFragment : GroceryImageHandlerFragment() {

    private lateinit var viewModel: GroceryDetailViewModel
    private lateinit var binding: FragmentGroceryDetailBinding

    private val args: GroceryDetailFragmentArgs by navArgs()

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
        viewModel.grocery.postValue(args.grocery)
        binding.lifecycleOwner = this
        binding.viewmodel = viewModel
        binding.groceryDetailImage.setOnClickListener {
            takePicture()
        }
    }

    override fun handleSuccessImage(imageUri: String) {
        viewModel.setGroceryImage(imageUri)
    }

}