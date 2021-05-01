package com.example.elasticsearchtest.model.settings

data class Setting<T>(val name: String, val value: T) {
}