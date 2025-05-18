package com.example.todoapp.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.todoapp.data.datasource.GorevlerDataSource
import com.example.todoapp.data.entity.Gorevler
import com.example.todoapp.data.repo.GorevlerRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AnaSayfaViewModel @Inject constructor(var gorevlerRepository: GorevlerRepository): ViewModel() {
    var gorevlerListesi = MutableLiveData<List<Gorevler>>()

    init {
        gorevleriYukle()
    }

    fun sil(gorev_id : Int){
        CoroutineScope(Dispatchers.Main).launch {
            gorevlerRepository.sil(gorev_id)
            gorevleriYukle()
        }
    }
    fun gorevleriYukle(){
        CoroutineScope(Dispatchers.Main).launch {
            gorevlerListesi.value =gorevlerRepository.gorevleriYukle()
        }
    }
    fun ara(aramaKelimesi: String){
        CoroutineScope(Dispatchers.Main).launch {
            gorevlerListesi.value=gorevlerRepository.ara(aramaKelimesi)
        }
    }
}