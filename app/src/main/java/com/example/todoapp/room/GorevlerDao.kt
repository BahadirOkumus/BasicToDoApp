package com.example.todoapp.room

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.todoapp.data.entity.Gorevler

@Dao
interface GorevlerDao {
    @Query("SELECT * FROM gorevler")
    suspend fun gorevleriYukle() : List<Gorevler>

    @Insert
    suspend fun kaydet(gorev: Gorevler)

    @Update
    suspend fun guncelle(gorev: Gorevler)

    @Delete
    suspend fun sil(gorev: Gorevler)

    @Query("SELECT * FROM GOREVLER WHERE gorev_ad LIKE '%' || :aramaKelimesi ||'%'")
    suspend fun ara(aramaKelimesi: String): List<Gorevler>
}
