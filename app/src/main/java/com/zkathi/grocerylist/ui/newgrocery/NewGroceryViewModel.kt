package com.zkathi.grocerylist.ui.newgrocery

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.zkathi.data.domain.GroceryRepository
import com.zkathi.data.domain.model.Grocery
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
open class NewGroceryViewModel @Inject constructor(private val groceryRepository: GroceryRepository) :
    ViewModel() {

    private val MINIMUM_QUANTITY = 0
    val grocery = MutableLiveData<Grocery>()

    init {
        initGroceryWithDefaultValues()
    }

    fun increaseGroceryQuantity() {
        grocery.value!!.quantity++
        grocery.postValue(grocery.value)
    }

    fun decreaseGroceryQuantity() {
        grocery.value?.let {
            if (it.quantity > MINIMUM_QUANTITY) {
                it.quantity--
            }
            grocery.postValue(it)
        }
    }

    fun saveGrocery() {
        grocery.value?.let { groceryToSave ->
            if (groceryToSave.name.isEmpty()) {
                return
            }
            viewModelScope.launch {
                groceryRepository.saveGrocery(groceryToSave)
                initGroceryWithDefaultValues()
            }
        }
    }

    fun setGroceryImage(imagePath: String) {
        grocery.value?.let {
            it.image_name = imagePath
            grocery.postValue(it)
        }
    }

    private fun initGroceryWithDefaultValues() {
        grocery.postValue(Grocery(0, "", "", 0, 0.0, ""))
    }
}