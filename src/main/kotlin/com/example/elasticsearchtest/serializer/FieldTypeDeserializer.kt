package com.example.elasticsearchtest.serializer

import com.example.elasticsearchtest.model.fields.types.FieldType
import com.example.elasticsearchtest.model.fields.types.factory.FieldTypeFactory
import com.fasterxml.jackson.core.JsonParser
import com.fasterxml.jackson.databind.DeserializationContext
import com.fasterxml.jackson.databind.JsonDeserializer
import com.fasterxml.jackson.databind.JsonNode
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.jackson.JsonComponent


@JsonComponent
class FieldTypeDeserializer(): JsonDeserializer<FieldType<*>>() {

    @Autowired
    private lateinit var fieldTypeFactory: FieldTypeFactory

    override fun deserialize(p: JsonParser?, ctxt: DeserializationContext?): FieldType<*> {
        val node = p?.readValueAsTree<JsonNode>()
        val name = node?.get("name")?.textValue()
        return fieldTypeFactory.getFieldType(name!!).orElse(null)
    }
}