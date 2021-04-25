package com.example.elasticsearchtest.model.fields.types

import com.example.elasticsearchtest.model.settings.Setting
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

    override fun getSettings(): List<Setting<*>> {
        return asList(Setting<Boolean>("multiline", false),
                Setting<Boolean>("editor", false))
    }

}