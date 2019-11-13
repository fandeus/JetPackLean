package com.jetpack.lean.main.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.switchMap
import java.util.logging.Level.ALL

class ShoeModel constructor(shoeRepository: ShoeRepository) : ViewModel() {


    //品牌的观察者对象 默认观察所有的品牌
    private val brand = MutableLiveData<String>().apply {
        value = ALL
    }

    /*val shoes: LiveData<List<Shoe>> = brand.switchMap {
        //Room 数据库查询，只要知道返回是LiveData<List<Shoe>> 即可
        if (it == ALL) {
            shoeRepository.getAllShoe()
        }
    }*/

    companion object {
        const val ALL = "所有"

        const val NIKE = "Nike"
        const val ADIDAS = "Adidas"
        const val OTHER = "other"
    }

}