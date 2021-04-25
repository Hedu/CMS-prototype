package com.example.elasticsearchtest.model.fields.types.factory

import com.example.elasticsearchtest.model.fields.types.FieldType
import java.util.*

interface FieldTypeFactory {

    fun getFieldType(name: String): Optional<FieldType<*>>
}