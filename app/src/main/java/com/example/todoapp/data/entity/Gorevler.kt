package com.example.todoapp.data.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import org.jetbrains.annotations.NotNull
import java.io.Serializable

@Entity(tableName = "gorevler")
data class Gorevler(@PrimaryKey(autoGenerate = true)
                   @ColumnInfo(name = "gorev_id") @NotNull var gorev_id:Int,
                   @ColumnInfo(name = "gorev_ad") @NotNull var gorev_ad: String,
                   @ColumnInfo(name = "gorev_detay") @NotNull var gorev_detay: String) : Serializable {
}