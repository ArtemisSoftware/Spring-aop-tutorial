package com.artemissoftware.spring_aop.business

import com.artemissoftware.spring_aop.annotations.TrackTime
import com.artemissoftware.spring_aop.data.DataService
import org.springframework.stereotype.Service


@Service
class BusinessMaxService(
    private val dataService: DataService
) {
    @TrackTime
    fun calculateMax() = dataService.retrieveData().max()
}