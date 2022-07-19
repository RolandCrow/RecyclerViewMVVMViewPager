package com.example.recyclerviewmvvmviewpager.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.recyclerviewmvvmviewpager.databinding.FragmentDetailBinding
import com.example.recyclerviewmvvmviewpager.utils.ZoomOutPageTransformer
import com.example.recyclerviewmvvmviewpager.viewmodel.DetailViewModel
import com.example.recyclerviewmvvmviewpager.viewmodel.DetailViewModelFactory

class DetailFragment: Fragment() {

    private  lateinit var viewModel: DetailViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val sportsArgs = DetailFragmentArgs.fromBundle(requireArguments()).detailFragmentArgs // получаем информацию из бандла
        val factory = DetailViewModelFactory(requireActivity().application, sportsArgs ) // используем фабрику для передачи инфы из вью моделя
        viewModel = ViewModelProvider(this, factory).get(DetailViewModel::class.java)
    }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
       val binding = FragmentDetailBinding.inflate(inflater)
        binding.detailViewPager.setPageTransformer(ZoomOutPageTransformer())
        binding.lifecycleOwner = this
        return binding.root
    }

}