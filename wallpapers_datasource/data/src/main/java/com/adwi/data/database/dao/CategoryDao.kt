package com.adwi.data.database.dao

import androidx.room.*
import com.adwi.data.database.domain.ColorCategoryEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface CategoryDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertColors(colors: List<ColorCategoryEntity>)

    @Query("SELECT * FROM colors_table")
    fun getAllColors(): Flow<List<ColorCategoryEntity>>

    @Query("SELECT * FROM colors_table WHERE name = :colorName")
    suspend fun getColor(colorName: String): ColorCategoryEntity

    @Update
    suspend fun updateColor(color: ColorCategoryEntity)
}