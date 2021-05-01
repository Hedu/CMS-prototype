package com.example.elasticsearchtest.model.documents

import com.example.elasticsearchtest.model.fields.FieldDefinition
import org.springframework.data.annotation.Id
import org.springframework.data.elasticsearch.annotations.Document
import org.springframework.data.elasticsearch.annotations.FieldType

@Document(indexName = "document_type")
class DocumentType(name: String, fields: List<FieldDefinition<*>>) {
    @Id
    var id: String = ""
    val name: String = name

    @org.springframework.data.elasticsearch.annotations.Field(type = FieldType.Nested, includeInParent = true)
    val fields: List<FieldDefinition<*>> = fields
}