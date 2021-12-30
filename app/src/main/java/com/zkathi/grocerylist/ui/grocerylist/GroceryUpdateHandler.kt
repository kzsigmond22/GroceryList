package com.zkathi.grocerylist.ui.grocerylist

import com.zkathi.data.domain.model.Grocery

interface GroceryUpdateHandler {
    fun updateGrocery(grocery: Grocery)
}