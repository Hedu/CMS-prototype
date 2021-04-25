package com.example.elasticsearchtest.model.fields.types

import com.example.elasticsearchtest.model.settings.Setting
import org.springframework.stereotype.Component
import java.util.*

@Component
class BooleanFieldType() : FieldType<Boolean> {
    override fun getName(): String {
        return "boolean"
    }

    override fun getValueType(): Class<Boolean> {
        return Boolean::class.java
    }

    override fun getSettings(): List<Setting<*>> {
        return Collections.emptyList()
    }

}