package com.zkathi.grocerylist.ui.grocerydetail

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.zkathi.data.domain.model.Grocery

class GroceryDetailViewModel : ViewModel() {

    val grocery = MutableLiveData<Grocery>()

}