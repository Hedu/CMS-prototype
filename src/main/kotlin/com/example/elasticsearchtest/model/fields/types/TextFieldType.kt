package com.example.elasticsearchtest.model.fields.types

import com.example.elasticsearchtest.model.settings.SettingDefinition
import org.springframework.stereotype.Component
import java.util.Arrays.asList

@Component
class TextFieldType() : FieldType<String> {
    override fun getName(): String {
        return "text"
    }

    override fun getValueType(): Class<String> {
        return String::class.java
    }

    override fun getSettingDefinitions(): List<SettingDefinition> {
        return asList(
                SettingDefinition("multiline", SettingDefinition.SettingType.BOOLEAN),
                SettingDefinition("editor", SettingDefinition.SettingType.BOOLEAN))
    }

}