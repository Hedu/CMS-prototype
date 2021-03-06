package com.example.elasticsearchtest.repository

import com.example.elasticsearchtest.model.documents.DocumentType
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable


interface DocumentTypeRepository: ElasticsearchRepository<DocumentType, String> {
    fun findByName(name: String): DocumentType
}