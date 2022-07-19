package com.example.recyclerviewmvvmviewpager.adapters


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerviewmvvmviewpager.databinding.ItemListBinding
import com.example.recyclerviewmvvmviewpager.model.Sports

class SportsAdapter: ListAdapter<Sports, SportsAdapter.SportsViewHolder>(DiffCallback) { // адаптер для ресайкл вью в лист фрагменте


    class SportsViewHolder(
        private val binding: ItemListBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(
            sports: Sports
        ) {
            binding.sport = sports // присоединяем данные к ресайклер вью во вью
            binding.executePendingBindings()
        }
    }




    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SportsViewHolder {
       return SportsViewHolder(
           ItemListBinding.inflate(
               LayoutInflater.from(parent.context), parent, false
           ) // все вместе
       )
    }

    override fun onBindViewHolder(holder: SportsViewHolder, position: Int) {
        val sports: Sports = getItem(position)// получаем отдельную позицию
        holder.bind(sports)
    }


    companion object DiffCallback : DiffUtil.ItemCallback<Sports>() {
        override fun areItemsTheSame(oldItem: Sports, newItem: Sports): Boolean {
            return oldItem === newItem
        }

        override fun areContentsTheSame(oldItem: Sports, newItem: Sports): Boolean {
            return oldItem.title == newItem.title
        }
    }



}