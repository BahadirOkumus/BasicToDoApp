package com.example.todoapp.ui.viewmodel

import androidx.lifecycle.ViewModel
import com.example.todoapp.data.repo.GorevlerRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class KayitViewModel @Inject constructor(var gorevlerRepository: GorevlerRepository): ViewModel(){
    fun kaydet(kisi_ad: String,kisi_tel: String){
        CoroutineScope(Dispatchers.Main).launch {
            gorevlerRepository.kaydet(kisi_ad,kisi_tel)
        }
    }
}