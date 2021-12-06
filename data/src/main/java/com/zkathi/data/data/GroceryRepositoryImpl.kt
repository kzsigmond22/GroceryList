package com.zkathi.data.data

import com.zkathi.data.domain.GroceryRepository
import com.zkathi.data.domain.model.Grocery
import javax.inject.Inject

class GroceryRepositoryImpl @Inject constructor(
    private val localDataSource: LocalDataSource,
) : GroceryRepository {
    override suspend fun getGroceries() = localDataSource.getAllGroceries()

}