package com.example.elasticsearchtest.model.fields.types

import com.example.elasticsearchtest.model.settings.Setting
import org.springframework.stereotype.Component
import java.util.Arrays.asList

@Component
class NumberFieldType() : FieldType<Number> {
    override fun getName(): String {
        return "number"
    }

    override fun getValueType(): Class<Number> {
        return Number::class.java
    }

    override fun getSettings():List<Setting<*>> {
        return asList(Setting<Boolean>("decimal", false))
    }

}