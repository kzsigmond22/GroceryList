package com.zkathi.grocerylist.ui.grocerydetail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import androidx.core.os.bundleOf
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.setFragmentResult
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.navArgs
import com.zkathi.grocerylist.R
import com.zkathi.grocerylist.databinding.FragmentGroceryDetailBinding
import com.zkathi.grocerylist.ui.GroceryImageHandlerFragment
import com.zkathi.grocerylist.ui.MainActivity
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
        binding.groceryDetailUpdateButton.setOnClickListener { update() }
        binding.groceryDetailDeleteButton.setOnClickListener { delete() }
        viewModel.finalOperationCompleted.observe(viewLifecycleOwner) {
            if (it) {
                popFragmentAndSetResult()
            }
        }
    }

    override fun handleSuccessImage(imageUri: String) {
        viewModel.setGroceryImage(imageUri)
    }

    private fun update() {
        if (binding.groceryDetailName.text.toString().isEmpty()) {
            showErrorToast(R.string.new_grocery_fill_out_all)
            return
        }
        viewModel.updateGrocery()
    }

    private fun delete() {
        val alertDialog: AlertDialog? = activity?.let {
            val builder = AlertDialog.Builder(it)
            builder.apply {
                setPositiveButton(
                    R.string.delete
                ) { dialog, _ ->
                    viewModel.deleteGrocery()
                    dialog.dismiss()
                }
                setNegativeButton(
                    R.string.cancel
                ) { dialog, _ ->
                    dialog.dismiss()
                }
            }
            builder.setMessage(R.string.delete_warning)
            builder.create()
        }
        alertDialog?.show()
    }

    private fun popFragmentAndSetResult() {
        setFragmentResult(
            MainActivity.ADD_TASK_REQUEST_KEY,
            bundleOf(MainActivity.ADD_TASK_IS_ADDED to true)
        )
        NavHostFragment.findNavController(requireParentFragment()).popBackStack()
    }

}