package com.example.elasticsearchtest.model.fields

import com.example.elasticsearchtest.model.fields.types.FieldType
import com.example.elasticsearchtest.model.settings.Setting

class Field<T>(name: String, fieldType: FieldType<T>, value: T, settings: List<Setting<*>>) {

    val name: String = name
    val fieldType: FieldType<T> = fieldType
    val value: T = value
    val settings: List<Setting<*>> = settings
}