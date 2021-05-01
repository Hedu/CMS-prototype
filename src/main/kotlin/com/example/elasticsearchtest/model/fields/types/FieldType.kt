package com.example.elasticsearchtest.model.fields.types

import com.example.elasticsearchtest.model.settings.SettingDefinition
import java.util.*

interface FieldType<T> {

    fun getName(): String
    fun getValueType(): Class<T>
    fun getSettingDefinitions(): List<SettingDefinition> {
        return Collections.emptyList()
    }
}