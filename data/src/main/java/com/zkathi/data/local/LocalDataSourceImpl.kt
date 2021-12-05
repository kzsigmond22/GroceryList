package com.zkathi.data.local

import com.zkathi.data.data.LocalDataSource
import javax.inject.Inject

class LocalDataSourceImpl @Inject constructor(private val groceryDao: GroceryDao) : LocalDataSource {
}