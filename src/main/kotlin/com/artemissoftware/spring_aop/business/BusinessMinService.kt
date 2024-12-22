package com.artemissoftware.spring_aop.business

import org.springframework.stereotype.Service


@Service
class BusinessMinService(
    private val dataService: DataService
) {
    fun calculateMin() = dataService.retrieveData().min()
}