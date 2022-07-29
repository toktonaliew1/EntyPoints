package com.example.android4hw1.ui.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView

import com.example.android4hw1.models.CoinsModel
import com.example.entypoints.databinding.ItemBinding

class CoinsAdapter() :
    androidx.recyclerview.widget.ListAdapter<CoinsModel, CoinsAdapter.ViewHolder>(diffCallback){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.onBind(getItem(position))
    }

    inner class ViewHolder(
        private val binding: ItemBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun onBind(item: CoinsModel) {
            binding.itemName.text = item.name
        }
    }

    companion object {
        private val diffCallback: DiffUtil.ItemCallback<CoinsModel> =
            object : DiffUtil.ItemCallback<CoinsModel>() {
                override fun areItemsTheSame(
                    oldItem: CoinsModel,
                    newItem: CoinsModel
                ): Boolean {
                    return oldItem.id === newItem.id
                }

                @SuppressLint("DiffUtilEquals")
                override fun areContentsTheSame(
                    oldItem: CoinsModel,
                    newItem: CoinsModel
                ): Boolean {
                    return oldItem === newItem
                }
            }
    }
}
