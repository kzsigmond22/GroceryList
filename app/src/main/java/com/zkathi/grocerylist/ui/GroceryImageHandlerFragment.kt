package com.zkathi.grocerylist.ui

import android.net.Uri
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.content.FileProvider
import com.zkathi.grocerylist.BuildConfig
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
}