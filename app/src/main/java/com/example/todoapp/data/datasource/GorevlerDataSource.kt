package com.example.todoapp.data.datasource


import com.example.todoapp.data.entity.Gorevler
import com.example.todoapp.room.GorevlerDao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext


class GorevlerDataSource (var gorevlerDao: GorevlerDao){

    suspend fun kaydet(gorev_ad: String,gorev_detay: String){
        val yeniGorev = Gorevler(0,gorev_ad,gorev_detay)
        gorevlerDao.kaydet(yeniGorev)
    }
    suspend fun guncelle(gorev_id: Int,gorev_ad: String,gorev_detay: String){
        val guncellenenGorev = Gorevler(gorev_id,gorev_ad,gorev_detay)
        gorevlerDao.guncelle(guncellenenGorev)
    }
    suspend fun sil(gorev_id: Int){
        val silinenGorev = Gorevler(gorev_id,"","")
        gorevlerDao.sil(silinenGorev)
    }

    suspend fun gorevleriYukle() : List<Gorevler> = withContext(Dispatchers.IO) {
        return@withContext  gorevlerDao.gorevleriYukle()
    }

    suspend fun ara(aramaKelimesi: String) : List<Gorevler> = withContext(Dispatchers.IO) {
        return@withContext gorevlerDao.ara(aramaKelimesi)
    }
}
