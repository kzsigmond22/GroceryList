package com.zkathi.grocerylist.ui

import android.widget.Toast
import androidx.fragment.app.Fragment

open class GroceryFragment : Fragment() {

    fun showErrorToast(messageId: Int) {
        Toast.makeText(requireContext(), requireContext().getString(messageId), Toast.LENGTH_SHORT)
            .show()
    }

}