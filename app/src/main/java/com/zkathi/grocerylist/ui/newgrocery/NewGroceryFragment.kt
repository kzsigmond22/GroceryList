package com.zkathi.grocerylist.ui.newgrocery

import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.content.FileProvider
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.zkathi.grocerylist.BuildConfig
import com.zkathi.grocerylist.R
import com.zkathi.grocerylist.databinding.NewGroceryFragmentBinding
import com.zkathi.grocerylist.ui.GroceryFragment
import dagger.hilt.android.AndroidEntryPoint
import java.io.File
import java.util.*


@AndroidEntryPoint
class NewGroceryFragment : GroceryFragment() {

    private lateinit var uri: Uri
    private val takePicture =
        registerForActivityResult(ActivityResultContracts.TakePicture()) { success: Boolean ->
            if (success) {
                Glide.with(requireContext())
                    .load(uri)
                    .into(binding.newGroceryImage);
            }
        }

    private lateinit var viewModel: NewGroceryViewModel
    private lateinit var binding: NewGroceryFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding = DataBindingUtil.inflate(
            inflater, R.layout.new_grocery_fragment, container, false
        )
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this)[NewGroceryViewModel::class.java]
        binding.lifecycleOwner = this
        binding.viewmodel = viewModel
        binding.newGroceryImage.setOnClickListener {
            val randomFileName = UUID.randomUUID().toString()
            val file = File.createTempFile(randomFileName, ".jpg", requireActivity().filesDir)
            uri = FileProvider.getUriForFile(
                requireActivity().applicationContext,
                BuildConfig.APPLICATION_ID + ".provider",
                file
            )

            takePicture.launch(uri)
        }
    }
}