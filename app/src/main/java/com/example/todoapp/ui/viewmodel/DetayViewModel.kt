package com.example.todoapp.ui.viewmodel

import androidx.lifecycle.ViewModel
import com.example.todoapp.data.repo.GorevlerRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class DetayViewModel @Inject constructor(var gorevlerRepository: GorevlerRepository): ViewModel(){

    fun guncelle (gorev_id: Int,gorev_ad: String,gorev_detay: String){
        CoroutineScope(Dispatchers.Main).launch {
            gorevlerRepository.guncelle(gorev_id,gorev_ad,gorev_detay)
        }
    }
}