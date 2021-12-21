package com.zkathi.grocerylist.ui.grocerylist

import androidx.recyclerview.widget.RecyclerView
import com.zkathi.data.domain.model.Grocery
import com.zkathi.grocerylist.databinding.ItemGroceryBinding

class GroceryViewHolder(private val binding: ItemGroceryBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(grocery: Grocery) {
        binding.grocery = grocery
    }

}