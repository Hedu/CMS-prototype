package com.example.elasticsearchtest.serializer

import com.example.elasticsearchtest.model.fields.types.FieldType
import com.fasterxml.jackson.core.JsonGenerator
import com.fasterxml.jackson.databind.JsonSerializer
import com.fasterxml.jackson.databind.SerializerProvider
import org.springframework.boot.jackson.JsonComponent


@JsonComponent
class FieldTypeSerializer(): JsonSerializer<FieldType<*>>() {

    override fun serialize(value: FieldType<*>?, gen: JsonGenerator?, serializers: SerializerProvider?) {
        gen?.writeStartObject()
        gen?.writeStringField("name",value?.getName())
        gen?.writeEndObject()
    }
}