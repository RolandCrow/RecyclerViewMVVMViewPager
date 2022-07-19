package com.example.recyclerviewmvvmviewpager.adapters

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.navigation.NavDirections
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerviewmvvmviewpager.model.Sports
import com.example.recyclerviewmvvmviewpager.utils.RecyclerViewItemDecoration
import com.example.recyclerviewmvvmviewpager.view.ListFragmentDirections
import com.google.android.material.card.MaterialCardView

@BindingAdapter("bindListData") // помещаем информацию во вью
fun RecyclerView.setListData(sportsList: List<Sports>) { // функция установить
    let { recyclerView ->
        val adapter = SportsAdapter()
        adapter.submitList(sportsList) // потвердить лист значений
        recyclerView.adapter = adapter

        RecyclerViewItemDecoration.setItemSpacing(
            resources, recyclerView
        )

    }

}

@BindingAdapter("bindSportImageItem")
fun ImageView.setSportItemImage(sports: Sports) {
    this.setImageResource(sports.icon)
}

@BindingAdapter("bindItemClickListener")
fun MaterialCardView.setItemClickListener(sports: Sports) { // передача информации через клик

    let { cardView ->
        cardView.setOnClickListener { view ->
            val direction: NavDirections =
                ListFragmentDirections.actionListFragmentToDetailFragment(sports)
            Navigation.findNavController(view).navigate(direction)
        }

    }
}