package com.zkathi.grocerylist.ui.newgrocery

import androidx.lifecycle.ViewModel
import com.zkathi.data.domain.GroceryRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class NewGroceryViewModel @Inject constructor(private val groceryRepository: GroceryRepository) : ViewModel() {

}