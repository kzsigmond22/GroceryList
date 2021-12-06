package com.zkathi.grocerylist.ui.grocerylist

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
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

    val groceries = MutableLiveData<List<Grocery>>()

    fun getGroceries() {
        CoroutineScope(Dispatchers.IO).launch {
            groceries.postValue(groceryRepository.getGroceries())

        }
    }

}