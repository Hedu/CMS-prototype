package com.example.elasticsearchtest.serialization

import com.example.elasticsearchtest.model.documents.DocumentType
import com.example.elasticsearchtest.model.fields.FieldDefinition
import com.example.elasticsearchtest.model.settings.Setting
import com.fasterxml.jackson.databind.ObjectMapper
import org.hamcrest.MatcherAssert.assertThat
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.util.AssertionErrors.assertEquals
import org.springframework.test.util.AssertionErrors.assertNotNull
import java.util.Arrays.asList

@SpringBootTest
class DocumentTypeSerializationTest(@Autowired val objectMapper: ObjectMapper) {

    @Test
    fun `Test Document Type deserailization`() {
        val jsonAsStream = this.javaClass.classLoader.getResourceAsStream(docTypeJsonLocation)
        val docType = objectMapper.readValue(jsonAsStream, DocumentType::class.java)

        assertEquals("Check the name", "testDocType", docType.name)

        val fields = docType.fields
        assertNotNull("Check nulls", fields)
        assertEquals("Check the number of fields", 3, fields.size)

        assertField(fields.get(0) as FieldDefinition<String>, "firstName", "text", "First Name placeholder",
                asList(Setting("multiline", false), Setting("editor", false)))
        assertField(fields.get(1) as FieldDefinition<String>, "lastName", "text", "Last Name placeholder",
                asList(Setting("multiline", false), Setting("editor", false)))
        assertField(fields.get(2) as FieldDefinition<String>, "email", "text", "Email placeholder",
                asList(Setting("multiline", false), Setting("editor", false)))
    }

    private fun <T> assertField(fieldDefinition: FieldDefinition<T>, name: String, fieldTypeName: String,
                                defaultValue: T, settings: List<Setting<*>>) {

        assertEquals("Check the name", name, fieldDefinition.name)

        val fieldType = fieldDefinition.fieldType
        assertNotNull("Check nulls", fieldType)
        assertEquals("Check the fieldType", fieldTypeName, fieldType?.getName())

        assertEquals("Check the default Value", defaultValue, fieldDefinition.value)

        assertSettings(fieldDefinition.settings, settings)
    }

    private fun assertSettings(actual: List<Setting<*>>?, expected: List<Setting<*>>) {
        assertNotNull("Check nulls", actual)
        assertNotNull("Check nulls", expected)

        assertEquals("Both settings have the same size", expected.size, actual?.size)

        assertThat("They containst the same settings", actual?.containsAll(expected)!!)

    }

    companion object {
        const val docTypeJsonLocation = "serialization/documentType.json"
    }
}