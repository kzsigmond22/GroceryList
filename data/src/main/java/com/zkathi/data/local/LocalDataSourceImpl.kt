package com.zkathi.data.local

import com.zkathi.data.data.LocalDataSource
import com.zkathi.data.domain.mapper.GroceryEntityToGroceryMapper
import com.zkathi.data.domain.model.Grocery
import javax.inject.Inject

class LocalDataSourceImpl @Inject constructor(
    private val groceryDao: GroceryDao,
    private val groceryMapper: GroceryEntityToGroceryMapper,
) : LocalDataSource {

    override suspend fun getAllGroceries() = groceryDao.getAll().map { groceryMapper.to(it) }

    override suspend fun saveGrocery(grocery: Grocery) {
        val groceryEntity = groceryMapper.from(grocery)
        groceryDao.insertAll(groceryEntity)
    }

    override suspend fun updateGrocery(grocery: Grocery) =
        groceryDao.update(groceryMapper.from(grocery))
}