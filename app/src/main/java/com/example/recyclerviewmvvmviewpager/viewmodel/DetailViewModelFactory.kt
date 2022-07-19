package com.example.recyclerviewmvvmviewpager.viewmodel

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.recyclerviewmvvmviewpager.model.Sports

class DetailViewModelFactory(private val application: Application, private val sports: Sports): ViewModelProvider.Factory {
    // фабрика для передачи данных дальше во фрагменты

    @Suppress("unchecked_cast")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
     if(modelClass.isAssignableFrom(DetailViewModel::class.java))  { // если модель класс пришел из DetailViewModel то
         return DetailViewModel(application, sports) as T // то возвращаем детайл вью модель уже с такими данными

     }
        throw IllegalArgumentException("Cannot create instance for DetailViewModel class")
    }


}