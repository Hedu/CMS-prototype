package com.example.elasticsearchtest.model.documents

import com.example.elasticsearchtest.model.fields.Field
import org.springframework.data.annotation.Id
import org.springframework.data.elasticsearch.annotations.Document
import org.springframework.data.elasticsearch.annotations.FieldType

@Document(indexName = "document")
class DocumentType(name: String, fields: List<Field<*>>) {
    @Id
    var id: String = ""
    val name: String = name

    @org.springframework.data.elasticsearch.annotations.Field(type = FieldType.Nested, includeInParent = true)
    val fields: List<Field<*>> = fields
}