package com.zkathi.grocerylist.ui.grocerylist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.zkathi.data.domain.GroceryRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class GroceryListViewModel @Inject constructor(private val groceryRepository: GroceryRepository) : ViewModel() {

    val groceries = liveData {
        emit(groceryRepository.getGroceries())
    }

}