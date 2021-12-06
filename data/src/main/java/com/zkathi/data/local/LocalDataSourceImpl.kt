package com.zkathi.data.local

import com.zkathi.data.data.LocalDataSource
import com.zkathi.data.domain.mapper.GroceryEntityToGroceryMapper
import javax.inject.Inject

class LocalDataSourceImpl @Inject constructor(
    private val groceryDao: GroceryDao,
    private val groceryMapper: GroceryEntityToGroceryMapper,
) : LocalDataSource {
    override suspend fun getAllGroceries() = groceryDao.getAll().map { groceryMapper.map(it) }
}