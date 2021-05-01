package com.example.elasticsearchtest.model.fields.types.factory

import com.example.elasticsearchtest.model.fields.types.FieldType
import org.springframework.stereotype.Component
import java.util.*

@Component
class DefaultFieldTypeFactory(val _fieldTypes: List<FieldType<*>>): FieldTypeFactory {

    override fun getFieldTypes(): List<FieldType<*>> {
       return _fieldTypes
    }

    override fun getFieldType(name: String): Optional<FieldType<*>> {
        return _fieldTypes.stream()
                .filter{fieldType -> fieldType.getName() == name }
                .findFirst()
    }
}