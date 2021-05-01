package com.example.elasticsearchtest

import com.example.elasticsearchtest.model.documents.Document
import com.example.elasticsearchtest.model.documents.DocumentType
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.data.elasticsearch.core.ElasticsearchOperations


@SpringBootApplication
class ElasticsearchTestApplication

fun main(args: Array<String>) {
	val applicationContext = runApplication<ElasticsearchTestApplication>(*args)

	val elasticsearchOperations = applicationContext.getBean(ElasticsearchOperations::class.java)
	elasticsearchOperations.indexOps(DocumentType::class.java).create()
	elasticsearchOperations.indexOps(Document::class.java).create()
}


