package com.example.elasticsearchtest.model.fields.types

import com.example.elasticsearchtest.model.settings.Setting
import com.fasterxml.jackson.annotation.JsonIgnore

interface FieldType<T> {

    fun getName(): String
    fun getValueType(): Class<T>
    fun getSettings(): List<Setting<*>>
}