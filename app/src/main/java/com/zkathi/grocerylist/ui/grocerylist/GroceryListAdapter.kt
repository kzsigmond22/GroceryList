package com.zkathi.grocerylist.ui.grocerylist

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.zkathi.data.domain.model.Grocery
import com.zkathi.grocerylist.databinding.ItemGroceryBinding

class GroceryListAdapter : RecyclerView.Adapter<GroceryViewHolder>() {

    private var groceryList = emptyList<Grocery>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GroceryViewHolder {
        val binding = ItemGroceryBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return GroceryViewHolder(binding)
    }

    override fun onBindViewHolder(holder: GroceryViewHolder, position: Int) {
        val grocery = groceryList[position]
        holder.bind(grocery)
    }

    override fun getItemCount() = groceryList.count()

    fun updateList(newGroceries: List<Grocery>) {
        groceryList = newGroceries
        notifyDataSetChanged()
    }
}