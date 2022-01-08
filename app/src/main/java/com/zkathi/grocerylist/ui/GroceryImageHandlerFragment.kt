package com.zkathi.grocerylist.ui

import android.net.Uri
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.content.FileProvider
import com.zkathi.grocerylist.BuildConfig
import com.zkathi.grocerylist.R
import java.io.File
import java.util.*

abstract class GroceryImageHandlerFragment : GroceryFragment() {

    abstract fun handleSuccessImage(imageUri: String)

    private lateinit var uri: Uri
    private val takePicture =
        registerForActivityResult(ActivityResultContracts.TakePicture()) { success: Boolean ->
            if (success) {
                handleSuccessImage(uri.toString())
            }
        }

    protected fun takePicture() {
        val randomFileName = UUID.randomUUID().toString()
        val file = File.createTempFile(randomFileName, ".jpg", requireActivity().filesDir)
        uri = FileProvider.getUriForFile(
            requireActivity().applicationContext,
            BuildConfig.APPLICATION_ID + ".provider",
            file
        )

        takePicture.launch(uri)
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