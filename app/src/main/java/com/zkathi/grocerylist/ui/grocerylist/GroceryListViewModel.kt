package com.zkathi.grocerylist.ui.grocerylist

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import androidx.lifecycle.viewModelScope
import com.zkathi.data.domain.GroceryRepository
import com.zkathi.data.domain.model.Grocery
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.scopes.ViewModelScoped
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class GroceryListViewModel @Inject constructor(private val groceryRepository: GroceryRepository) : ViewModel() {

    val groceries = liveData {
        emit(groceryRepository.getGroceries())
    }

}