package com.example.elasticsearchtest.model.fields.types

import org.springframework.stereotype.Component

@Component
class BooleanFieldType() : FieldType<Boolean> {
    override fun getName(): String {
        return "boolean"
    }

    override fun getValueType(): Class<Boolean> {
        return Boolean::class.java
    }

}