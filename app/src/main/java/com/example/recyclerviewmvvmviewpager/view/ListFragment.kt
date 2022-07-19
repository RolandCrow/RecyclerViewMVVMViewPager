package com.example.recyclerviewmvvmviewpager.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.recyclerviewmvvmviewpager.databinding.FragmentListBinding
import com.example.recyclerviewmvvmviewpager.viewmodel.ListViewModel

class ListFragment: Fragment() {

    private val viewModel: ListViewModel by lazy {
        ViewModelProvider(this).get(ListViewModel::class.java) // присоединяем вью модель

    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentListBinding.inflate(inflater)
        binding.viewModel = viewModel // присоединяем вью модель к значению во вью
        binding.lifecycleOwner = this
        return binding.root
    }
}