package com.zkathi.grocerylist.ui.newgrocery

import android.net.Uri
import android.os.Bundle
import android.view.*
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.content.FileProvider
import androidx.core.os.bundleOf
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.setFragmentResult
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.NavHostFragment
import com.zkathi.grocerylist.BuildConfig
import com.zkathi.grocerylist.R
import com.zkathi.grocerylist.databinding.FragmentNewGroceryBindingImpl
import com.zkathi.grocerylist.ui.GroceryFragment
import com.zkathi.grocerylist.ui.MainActivity
import dagger.hilt.android.AndroidEntryPoint
import java.io.File
import java.util.*


@AndroidEntryPoint
class NewGroceryFragment : GroceryFragment() {

    private lateinit var viewModel: NewGroceryViewModel
    private lateinit var binding: FragmentNewGroceryBindingImpl

    private lateinit var uri: Uri
    private val takePicture =
        registerForActivityResult(ActivityResultContracts.TakePicture()) { success: Boolean ->
            if (success) {
                viewModel.setGroceryImage(uri.toString())
            }
        }

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
            val randomFileName = UUID.randomUUID().toString()
            val file = File.createTempFile(randomFileName, ".jpg", requireActivity().filesDir)
            uri = FileProvider.getUriForFile(
                requireActivity().applicationContext,
                BuildConfig.APPLICATION_ID + ".provider",
                file
            )

            takePicture.launch(uri)
        }
        binding.newGroceryAddButton.setOnClickListener { onSave() }
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