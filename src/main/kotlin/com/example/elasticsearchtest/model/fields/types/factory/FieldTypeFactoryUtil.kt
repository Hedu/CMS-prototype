package com.example.elasticsearchtest.model.fields.types.factory

import com.example.elasticsearchtest.config.Config
import com.example.elasticsearchtest.model.fields.types.FieldType
import java.util.*

class FieldTypeFactoryUtil {

    companion object {
        var fieldTypeFactory: FieldTypeFactory? = null

        fun getFieldTypes(): List<FieldType<*>>? {
            return getFactory()?.getFieldTypes()
        }

        @JvmStatic
        fun getFieldType(name: String): Optional<FieldType<*>>? {
            return getFactory()?.getFieldType(name)
        }

        private fun getFactory(): FieldTypeFactory? {
            if (fieldTypeFactory == null) {
                fieldTypeFactory = Config.getContext()?.getBean(FieldTypeFactory::class.java)
            }
            return fieldTypeFactory
        }
    }
}