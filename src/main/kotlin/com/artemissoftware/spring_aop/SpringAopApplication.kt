package com.artemissoftware.spring_aop

import com.artemissoftware.spring_aop.business.BusinessMaxService
import com.artemissoftware.spring_aop.business.BusinessMinService
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class SpringAopApplication(
	val  businessMaxService: BusinessMaxService,
	val  businessMinService: BusinessMinService
): CommandLineRunner{

	private val logger = LoggerFactory.getLogger(this::class.java)

	override fun run(vararg args: String?) {
		logger.info("MAX Value returned is {}", businessMaxService.calculateMax())
		logger.info("MIN Value returned is {}", businessMinService.calculateMin())
	}

}

fun main(args: Array<String>) {
	runApplication<SpringAopApplication>(*args)
}
