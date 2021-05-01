package com.example.elasticsearchtest.model.fields

import com.example.elasticsearchtest.model.fields.types.FieldType
import com.example.elasticsearchtest.model.fields.types.factory.FieldTypeFactoryUtil
import com.example.elasticsearchtest.model.settings.Setting
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty

class FieldDefinition<T> {

        var name: String? = null
                private set
        var fieldType: FieldType<T>? = null
                private set
        var value: T? = null
                private set
        var settings: List<Setting<*>>? = null
                private set

        val fieldTypeString: String
                @JsonProperty("fieldType")
                get() = fieldType!!.getName()

        constructor() {}

        constructor(name: String, fieldType: FieldType<T>, value: T, settings: List<Setting<*>>) {
                this.name = name
                this.fieldType = fieldType
                this.value = value
                this.settings = settings
        }

        @JsonCreator
        constructor(name: String, @JsonProperty("fieldType") fieldTypeName: String, value: T, settings: List<Setting<*>>) {
                this.name = name
                fieldType = FieldTypeFactoryUtil.getFieldType(fieldTypeName)!!.orElse(null) as FieldType<T>
                this.fieldType = fieldType
                this.value = value
                this.settings = settings
        }
}