package com.zkathi.grocerylist.ui.grocerylist

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.zkathi.data.domain.model.Grocery
import com.zkathi.grocerylist.databinding.ItemGroceryBinding
import java.util.*

class GroceryListAdapter(private val groceryUpdateHandler: GroceryUpdateHandler) :
    ListAdapter<Grocery, GroceryViewHolder>(UserDiffCallBack()) {

    private var groceryList = emptyList<Grocery>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GroceryViewHolder {
        val binding = ItemGroceryBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return GroceryViewHolder(binding, groceryUpdateHandler)
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

    fun swapItems(firstPosition: Int, secondPosition: Int) {
        Collections.swap(groceryList, firstPosition, secondPosition)
        notifyItemMoved(firstPosition, secondPosition)
    }

    private class UserDiffCallBack : DiffUtil.ItemCallback<Grocery>() {
        override fun areItemsTheSame(oldItem: Grocery, newItem: Grocery): Boolean =
            oldItem.uid == newItem.uid

        override fun areContentsTheSame(oldItem: Grocery, newItem: Grocery): Boolean =
            oldItem.uid == newItem.uid
    }
}
