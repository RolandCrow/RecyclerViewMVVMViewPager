package com.example.recyclerviewmvvmviewpager.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.recyclerviewmvvmviewpager.model.Sports

class ListViewModel(application: Application): AndroidViewModel(application) { // вью модел для передачи данных из модель класса

    private val _sport: MutableLiveData<List<Sports>> = MutableLiveData() // изменяемая лайв дата для передачи значений из модель класса
    val sports: LiveData<List<Sports>>
            get() = _sport // присоединяем к просто лайв дате

    init {
        val sportsList: List<Sports> = Sports.sportList(application.applicationContext)
        _sport.value = sportsList // присоединяем модель класс с определенными значениями в контекст для дальнейшего использования

    }

}

