package com.example.recyclerviewmvvmviewpager.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.example.recyclerviewmvvmviewpager.model.Sports

class DetailViewModel(application: Application, sports: Sports): AndroidViewModel(application) {

    private val _sportList = Sports.sportList(application.applicationContext) // берем значение из контекста ListViewModel
    val sportList: List<Sports> // присоединяем значения из контекста в лайв дату
        get() = _sportList

    private val _selectedSport = sports
    val selectedSport: Sports
        get() = _selectedSport // значение для отдельно выбранного спорта


}