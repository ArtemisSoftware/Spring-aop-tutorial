package com.artemissoftware.spring_aop.business

import org.springframework.stereotype.Repository

@Repository
class DataService {

    fun retrieveData(): List<Int> {
        //throw RuntimeException("ERROR ERROR")
        return listOf(11, 22, 33, 44, 55)
    }

}