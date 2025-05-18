package com.example.todoapp.data.repo

import com.example.todoapp.data.datasource.GorevlerDataSource
import com.example.todoapp.data.entity.Gorevler

class GorevlerRepository (var gorevlerDataSource: GorevlerDataSource) {
    suspend fun kaydet(gorev_ad: String,gorev_detay: String){
        gorevlerDataSource.kaydet(gorev_ad,gorev_detay)
    }

    suspend fun guncelle(gorev_id: Int,gorev_ad: String,gorev_detay: String){
        gorevlerDataSource.guncelle(gorev_id,gorev_ad,gorev_detay)
    }
    suspend fun sil(gorev_id: Int) = gorevlerDataSource.sil(gorev_id)

    suspend fun gorevleriYukle() : List<Gorevler> = gorevlerDataSource.gorevleriYukle()

    suspend fun ara(aramaKelimesi: String) : List<Gorevler> = gorevlerDataSource.ara(aramaKelimesi)
}


