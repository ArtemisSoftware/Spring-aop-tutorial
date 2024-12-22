package com.artemissoftware.spring_aop

import com.artemissoftware.spring_aop.business.DataService
import org.springframework.stereotype.Service


@Service
class BusinessService(
    private val dataService: DataService
) {
    fun calculateMax() = dataService.retrieveData().max()
}