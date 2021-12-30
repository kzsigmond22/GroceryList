package com.zkathi.grocerylist.ui.grocerylist

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.zkathi.data.domain.GroceryRepository
import com.zkathi.data.domain.model.Grocery
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class GroceryListViewModel @Inject constructor(private val groceryRepository: GroceryRepository) :
    ViewModel() {

    init {
        refreshList()
    }

    val groceries = MutableLiveData<List<Grocery>>()

    fun refreshList() {
        viewModelScope.launch {
            val groceryFromRepo = groceryRepository.getGroceries()
            groceries.postValue(groceryFromRepo)
        }
    }

    // TODO: make this a queue?
    fun updateGrocery(grocery: Grocery) =
        viewModelScope.launch { groceryRepository.updateGrocery(grocery) }
}