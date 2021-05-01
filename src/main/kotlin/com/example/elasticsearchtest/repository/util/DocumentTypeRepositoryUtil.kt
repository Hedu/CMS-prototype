package com.example.elasticsearchtest.repository.util

import com.example.elasticsearchtest.config.Config
import com.example.elasticsearchtest.model.documents.Document
import com.example.elasticsearchtest.model.documents.DocumentType
import com.example.elasticsearchtest.repository.DocumentTypeRepository
import org.elasticsearch.index.query.QueryBuilder
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.domain.Sort
import org.springframework.data.elasticsearch.core.query.Query
import java.util.*


class DocumentTypeRepositoryUtil {

    companion object {
        var documentTypeRepository: DocumentTypeRepository? = null

        fun <S : DocumentType?> save(entity: S): S? {
            return getRepository()?.save(entity)
        }

        fun findAll(sort: Sort): MutableIterable<DocumentType>? {
            return getRepository()?.findAll(sort)
        }

        fun findAll(pageable: Pageable): Page<DocumentType>? {
            return getRepository()?.findAll(pageable)
        }

        fun findAll(): MutableIterable<DocumentType>? {
            return  getRepository()?.findAll()
        }

        fun searchSimilar(entity: DocumentType, fields: Array<out String>?, pageable: Pageable): Page<DocumentType>? {
            return  getRepository()?.searchSimilar(entity, fields, pageable)
        }

        fun deleteById(id: String) {
            getRepository()?.deleteById(id)
        }

        fun search(query: QueryBuilder): MutableIterable<DocumentType>? {
            return getRepository()?.search(query)
        }

        fun search(query: QueryBuilder, pageable: Pageable): Page<DocumentType>? {
            return  getRepository()?.search(query, pageable)
        }

        fun search(searchQuery: Query): Page<DocumentType>? {
            return  getRepository()?.search(searchQuery)
        }

        fun deleteAll(entities: MutableIterable<DocumentType>) {
            getRepository()?.deleteAll(entities)
        }

        fun deleteAll() {
            getRepository()?.deleteAll()
        }

        fun <S : DocumentType?> saveAll(entities: MutableIterable<S>): MutableIterable<S>? {
            return getRepository()?.saveAll(entities)
        }

        fun count(): Long? {
            return getRepository()?.count()
        }

        fun findAllById(ids: MutableIterable<String>): MutableIterable<DocumentType>? {
            return getRepository()?.findAllById(ids)
        }

        fun existsById(id: String): Boolean? {
            return  getRepository()?.existsById(id)
        }

        fun <S : DocumentType?> indexWithoutRefresh(entity: S): S? {
            return  getRepository()?.indexWithoutRefresh(entity)
        }

        fun refresh() {
            getRepository()?.refresh()
        }

        fun findById(id: String): Optional<DocumentType>? {
            return  getRepository()?.findById(id)
        }

        fun delete(entity: DocumentType) {
            getRepository()?.delete(entity)
        }

        fun findByName(name: String): DocumentType? {
            return getRepository()?.findByName(name)
        }

        private fun getRepository(): DocumentTypeRepository? {
            if (documentTypeRepository == null) {
                documentTypeRepository = Config.getContext()?.getBean(DocumentTypeRepository::class.java)
            }
            return documentTypeRepository
        }
    }
}