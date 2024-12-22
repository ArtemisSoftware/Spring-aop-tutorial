package com.artemissoftware.spring_aop

import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class SpringAopApplication: CommandLineRunner{

	private val logger = LoggerFactory.getLogger(this::class.java)
	@Autowired
	private lateinit var  businessService: BusinessService

	override fun run(vararg args: String?) {
		logger.info("Value returned is {}", businessService.calculateMax())
	}

}

fun main(args: Array<String>) {
	runApplication<SpringAopApplication>(*args)
}
