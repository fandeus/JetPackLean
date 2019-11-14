package com.jetpack.lean.db.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Query
import com.jetpack.lean.db.data.Shoe

@Dao
interface ShoeDao {

    /**
     * 通过鞋子的范围查找Index
     */
    @Query("SELECT * FROM shoe WHERE id between :startIndex AND :endIndex ORDER BY id ASC")
    fun findShoesByIndexRange(startIndex: Long, endIndex: Long): List<Shoe>


    // 配合LiveData 返回所有的鞋子
    @Query("SELECT * FROM shoe")
    fun getAllShoes(): LiveData<List<Shoe>>

    /**
     * 通过品牌查询鞋子
     */
    @Query("SELECT * FROM shoe WHERE shoe_brand IN (:brand)")
    fun findShoesByBrand(brand: String): LiveData<List<Shoe>>
}