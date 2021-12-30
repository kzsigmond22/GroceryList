package com.zkathi.grocerylist.ui.grocerylist

import androidx.recyclerview.widget.RecyclerView
import com.zkathi.data.domain.model.Grocery
import com.zkathi.grocerylist.databinding.ItemGroceryBinding

class GroceryViewHolder(private val binding: ItemGroceryBinding) :
    RecyclerView.ViewHolder(binding.root) {

    private lateinit var grocery: Grocery

    fun bind(grocery: Grocery) {
        this.grocery = grocery
        binding.groceryVH = this
        binding.grocery = grocery
    }

    fun increaseQuantity() {
        grocery.quantity++
        binding.grocery = grocery
    }

    fun decreaseQuantity() {
        if (grocery.quantity > 0) {
            grocery.quantity--
            binding.grocery = grocery
        }
    }
}