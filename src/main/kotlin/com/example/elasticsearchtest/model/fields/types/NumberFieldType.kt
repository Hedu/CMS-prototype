package com.example.elasticsearchtest.model.fields.types

import com.example.elasticsearchtest.model.settings.SettingDefinition
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

    override fun getSettingDefinitions(): List<SettingDefinition> {
        return asList(
                SettingDefinition("decimal", SettingDefinition.SettingType.BOOLEAN))
    }


}