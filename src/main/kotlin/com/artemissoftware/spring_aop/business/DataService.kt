package com.artemissoftware.spring_aop.business

import org.springframework.stereotype.Repository

@Repository
class DataService {

    fun retrieveData() = listOf(11, 22, 33, 44, 55)

}