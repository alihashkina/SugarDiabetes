package com.bignerdranch.android.sugardiabetes.room

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "sugar_table")
data class Sugar(
    @PrimaryKey val id: Int,
    val date: String?,
    val sugar: String?,
val chips: String?)
