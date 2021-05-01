package com.example.elasticsearchtest.model.documents

import com.example.elasticsearchtest.model.fields.Field
import com.example.elasticsearchtest.repository.util.DocumentTypeRepositoryUtil
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.annotation.JsonSetter
import org.springframework.data.annotation.Id
import org.springframework.data.elasticsearch.annotations.Document
import org.springframework.data.elasticsearch.annotations.FieldType

@Document(indexName = "document")
class Document(name: String, documentType: DocumentType, fields: List<Field<*>>) {
    @Id
    var id: String = ""

    val name: String = name

    var documentType = documentType

    @org.springframework.data.elasticsearch.annotations.Field(type = FieldType.Nested, includeInParent = true)
    val fields: List<Field<*>> = fields

    @JsonProperty("documentType")
    fun getDocumentTypeString(): String {
        return documentType.name
    }

    @JsonSetter("documentType")
    fun setDocumentTypeString(name: String) {
        documentType = DocumentTypeRepositoryUtil.findByName(name)!!
    }
}
