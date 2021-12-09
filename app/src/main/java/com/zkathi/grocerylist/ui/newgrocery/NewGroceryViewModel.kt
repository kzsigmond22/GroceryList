package com.zkathi.grocerylist.ui.newgrocery

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.zkathi.data.domain.GroceryRepository
import com.zkathi.data.domain.model.Grocery
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class NewGroceryViewModel @Inject constructor(private val groceryRepository: GroceryRepository) : ViewModel() {

    val grocery = MutableLiveData<Grocery>()

    private val groceryToSave = Grocery(1, "", "", 0, 0.0, "")

    fun increaseGroceryQuantity() {
        groceryToSave.quantity++
        grocery.postValue(groceryToSave)
    }

    fun decreaseGroceryQuantity() {
        groceryToSave.quantity--
        grocery.postValue(groceryToSave)
    }
}