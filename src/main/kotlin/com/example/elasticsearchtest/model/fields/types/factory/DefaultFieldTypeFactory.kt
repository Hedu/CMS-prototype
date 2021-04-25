package com.example.elasticsearchtest.model.fields.types.factory

import com.example.elasticsearchtest.model.fields.types.FieldType
import org.springframework.stereotype.Component
import java.util.*

@Component
class DefaultFieldTypeFactory(val fieldTypes: List<FieldType<*>>): FieldTypeFactory {

    override fun getFieldType(name: String): Optional<FieldType<*>> {
        return fieldTypes.stream()
                .filter{fieldType -> fieldType.getName() == name }
                .findFirst()
    }
}