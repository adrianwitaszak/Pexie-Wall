package com.adwi.data.database.domain

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.adwi.domain.ColorCategory

@Entity(tableName = "colors_table")
data class ColorCategoryEntity(
    @PrimaryKey(autoGenerate = false)
    val name: String = "",
    val firstImage: String = "",
    val secondImage: String = "",
    val thirdImage: String = "",
    val forthImage: String = "",
    val timeStamp: Long = 0L
)

fun ColorCategoryEntity.toDomain() =
    ColorCategory(
        name, firstImage, secondImage, thirdImage, forthImage, timeStamp
    )

fun List<ColorCategoryEntity>.toDomainList() = this.map { it.toDomain() }