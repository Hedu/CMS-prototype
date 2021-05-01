package com.example.elasticsearchtest.model.settings

import java.util.*

data class SettingDefinition(val name: String, val type: SettingType, val extra: List<String> = Collections.emptyList()) {

    enum class SettingType {
        BOOLEAN,
        STRING,
        LIST_OF_STRINGS,
        INTEGER,
        DECIMAL
    }
}