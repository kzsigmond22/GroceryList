package com.zkathi.grocerylist.ui.grocerylist

import com.zkathi.data.domain.model.Grocery

interface GroceryItemNavigator {
    fun navigateToDetail(grocery: Grocery)
}