package com.example.elasticsearchtest

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication


@SpringBootApplication
class ElasticsearchTestApplication

fun main(args: Array<String>) {
	val applicationContext = runApplication<ElasticsearchTestApplication>(*args)
}


