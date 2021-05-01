package com.example.elasticsearchtest.repository

import com.example.elasticsearchtest.model.documents.Document
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable


interface DocumentRepository: ElasticsearchRepository<Document, String> {
    fun findByName(name: String, pageable: Pageable): Page<Document>
}