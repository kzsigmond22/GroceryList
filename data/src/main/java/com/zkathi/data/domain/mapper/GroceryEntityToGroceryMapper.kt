package com.zkathi.data.domain.mapper

import com.zkathi.data.domain.Mapper
import com.zkathi.data.domain.model.Grocery
import com.zkathi.data.local.entity.GroceryEntity

class GroceryEntityToGroceryMapper : Mapper<GroceryEntity, Grocery> {
    override fun map(input: GroceryEntity) = Grocery(
        uid = input.uid,
        name = input.name,
        image_name = input.image_name,
        description = input.description,
        price = input.price,
        quantity = input.quantity
    )
}