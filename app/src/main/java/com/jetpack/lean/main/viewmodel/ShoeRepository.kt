package com.jetpack.lean.main.viewmodel

import androidx.lifecycle.LiveData
import com.jetpack.lean.db.dao.ShoeDao
import com.jetpack.lean.db.data.Shoe

class ShoeRepository private constructor(private val shoeDao: ShoeDao) {

    fun getAllShoe(): LiveData<List<Shoe>> {
        return shoeDao.getAllShoes()
    }

    fun getShoesByBrand(brand: String): LiveData<List<Shoe>> {
        return shoeDao.findShoesByBrand(brand)
    }

}