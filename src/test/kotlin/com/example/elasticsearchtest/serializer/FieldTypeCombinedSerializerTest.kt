package com.example.elasticsearchtest.serializer

import com.example.elasticsearchtest.model.fields.types.TextFieldType
import com.fasterxml.jackson.databind.ObjectMapper
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class FieldTypeSerializerTest(@Autowired val objectMapper: ObjectMapper) {

    @Test
    fun `Test the serializer`() {
        val fieldType = TextFieldType()
        val json = objectMapper.writeValueAsString(fieldType)

        assertEquals("{\"name\":\"text\"}", json);
    }
}