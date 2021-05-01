package com.example.elasticsearchtest.controller

import com.example.elasticsearchtest.model.fields.types.FieldType
import com.example.elasticsearchtest.model.fields.types.factory.FieldTypeFactory
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/fieldTypes")
class FieldTypeController(val fieldTypeFactory: FieldTypeFactory) {

    @GetMapping
    fun getFieldTypes(): List<FieldType<*>> {

        return fieldTypeFactory.getFieldTypes()
    }

    @GetMapping("/{name}")
    fun getFieldType(@PathVariable("name") name: String): FieldType<*> {

        return fieldTypeFactory.getFieldType(name).orElse(null)
    }
}