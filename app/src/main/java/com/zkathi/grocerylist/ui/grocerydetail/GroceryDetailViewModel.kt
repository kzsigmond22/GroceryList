package com.zkathi.grocerylist.ui.grocerydetail

import com.zkathi.data.domain.GroceryRepository
import com.zkathi.grocerylist.ui.newgrocery.NewGroceryViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class GroceryDetailViewModel @Inject constructor(private val groceryRepository: GroceryRepository) :
    NewGroceryViewModel(groceryRepository) {

}