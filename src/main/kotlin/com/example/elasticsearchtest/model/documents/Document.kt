package com.example.elasticsearchtest.model.documents

import com.example.elasticsearchtest.model.fields.Field
import com.example.elasticsearchtest.repository.util.DocumentTypeRepositoryUtil
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.annotation.JsonSetter
import org.springframework.data.annotation.Id
import org.springframework.data.elasticsearch.annotations.Document
import org.springframework.data.elasticsearch.annotations.FieldType

@Document(indexName = "document")
class Document {
    @Id
    var id: String = ""

    var name: String? = null

    var documentType: DocumentType? = null

    val documentTypeString: String?
        @JsonProperty("documentType")
        get() = documentType?.name

    @org.springframework.data.elasticsearch.annotations.Field(type = FieldType.Nested, includeInParent = true)
    var fields: List<Field<*>>? = null

    constructor() {}

    constructor(name: String, documentType: DocumentType, fields: List<Field<*>>) {
        init(name, documentType, fields)
    }

    @JsonCreator
    constructor(name: String, @JsonProperty("documentType") documentTypeName: String, fields: List<Field<*>>) {
        init(name, DocumentTypeRepositoryUtil.findByName(documentTypeName)!!, fields)
    }

    fun init(name: String, documentType: DocumentType, fields: List<Field<*>>) {
        this.name = name
        this.documentType = documentType
        this.fields = fields
    }

}
