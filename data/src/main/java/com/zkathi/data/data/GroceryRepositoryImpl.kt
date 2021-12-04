package com.zkathi.data.data

import com.zkathi.data.domain.GroceryRepository
import javax.inject.Inject

class GroceryRepositoryImpl @Inject constructor(
    private val localDataSource: LocalDataSource) : GroceryRepository {

}