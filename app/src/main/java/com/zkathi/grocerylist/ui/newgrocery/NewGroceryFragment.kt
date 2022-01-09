package com.zkathi.grocerylist.ui.newgrocery

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.addCallback
import androidx.core.os.bundleOf
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.setFragmentResult
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import com.zkathi.grocerylist.R
import com.zkathi.grocerylist.databinding.FragmentNewGroceryBinding
import com.zkathi.grocerylist.ui.GroceryImageHandlerFragment
import com.zkathi.grocerylist.ui.MainActivity
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class NewGroceryFragment : GroceryImageHandlerFragment() {

    private lateinit var viewModel: NewGroceryViewModel
    private lateinit var binding: FragmentNewGroceryBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_new_grocery, container, false
        )
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this)[NewGroceryViewModel::class.java]
        binding.lifecycleOwner = this
        binding.viewmodel = viewModel
        binding.newGroceryImage.setOnClickListener {
            takePicture()
        }
        binding.newGroceryAddButton.setOnClickListener { onSave() }
        requireActivity().onBackPressedDispatcher.addCallback(this) {
            viewModel.grocery.value?.let { grocery ->
                deletePicture(grocery.image_name)
            }
            findNavController().popBackStack()
        }
    }

    override fun handleSuccessImage(imageUri: String) {
        viewModel.setGroceryImage(imageUri)
    }

    private fun onSave() {
        if (binding.newGroceryName.text.toString().isEmpty()) {
            showErrorToast(R.string.new_grocery_fill_out_all)
            return
        }
        viewModel.saveGrocery()
        setFragmentResult(
            MainActivity.ADD_TASK_REQUEST_KEY,
            bundleOf(MainActivity.ADD_TASK_IS_ADDED to true)
        )
        NavHostFragment.findNavController(requireParentFragment()).popBackStack()
    }
}