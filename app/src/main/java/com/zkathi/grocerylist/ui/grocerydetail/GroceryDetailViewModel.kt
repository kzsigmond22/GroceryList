package com.zkathi.grocerylist.ui.grocerydetail

import androidx.lifecycle.viewModelScope
import com.zkathi.data.domain.GroceryRepository
import com.zkathi.grocerylist.ui.newgrocery.NewGroceryViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class GroceryDetailViewModel @Inject constructor(private val groceryRepository: GroceryRepository) :
    NewGroceryViewModel(groceryRepository) {

    fun deleteGrocery() {
        grocery.value?.let {
            viewModelScope.launch {
                groceryRepository.deleteGrocery(it)
            }
        }
    }

    fun updateGrocery() {
        grocery.value?.let {
            viewModelScope.launch {
                groceryRepository.updateGrocery(it)
            }
        }
    }

}