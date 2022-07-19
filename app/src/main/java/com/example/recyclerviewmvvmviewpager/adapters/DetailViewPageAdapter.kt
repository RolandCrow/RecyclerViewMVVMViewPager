package com.example.recyclerviewmvvmviewpager.adapters


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.example.recyclerviewmvvmviewpager.databinding.ItemDetailAdapterBinding
import com.example.recyclerviewmvvmviewpager.model.Sports
import com.example.recyclerviewmvvmviewpager.viewmodel.DetailViewModel
import com.example.recyclerviewmvvmviewpager.adapters.DetailViewPageAdapter.DetailViewHolder

class DetailViewPageAdapter( // адаптер для пейджера похожий на ресайклер вью
    private val viewPager2: ViewPager2,
    private val viewModel: DetailViewModel
): ListAdapter<Sports, DetailViewHolder>(DiffCallback) {





    class DetailViewHolder(
        private val binding: ItemDetailAdapterBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(
            sports: Sports,
            viewModel: DetailViewModel,
            viewPager: ViewPager2
        ) {
            binding.sport = sports
            binding.viewModel = viewModel
            binding.viewPager = viewPager
            binding.executePendingBindings() // биндим результаты во вью
        }
    }






    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DetailViewHolder {
        return DetailViewHolder(
            ItemDetailAdapterBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: DetailViewHolder, position: Int) { // присоединяем позиции вью модел
        val sportsArgs: Sports = getItem(position)
        holder.bind(sportsArgs, viewModel, viewPager2)
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