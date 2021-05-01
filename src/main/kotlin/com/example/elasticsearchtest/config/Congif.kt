package com.example.elasticsearchtest.config

import org.elasticsearch.client.RestHighLevelClient
import org.springframework.context.ApplicationContext
import org.springframework.context.ApplicationContextAware
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration
import org.springframework.data.elasticsearch.client.ClientConfiguration
import org.springframework.data.elasticsearch.client.RestClients
import org.springframework.data.elasticsearch.core.ElasticsearchOperations
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories


@Configuration
@EnableElasticsearchRepositories(basePackages = ["com.example.elasticsearchtest.repository"])
@ComponentScan(basePackages = ["com.example.elasticsearchtest"])
class Config: ApplicationContextAware {

    @Bean
    fun client(): RestHighLevelClient {
        val clientConfiguration = ClientConfiguration.builder()
                .connectedTo("localhost:9200")
                .build()

        return RestClients.create(clientConfiguration).rest()
    }

    @Bean
    fun elasticsearchTemplate(restHighLevelClient: RestHighLevelClient): ElasticsearchOperations {
        return ElasticsearchRestTemplate(restHighLevelClient)
    }


    override fun setApplicationContext(context: ApplicationContext) {
        applicationContext = context
    }

    /**
     * Note that this is a static method which expose ApplicationContext
     */
    companion object {
        var applicationContext: ApplicationContext? = null

        fun getContext(): ApplicationContext? {
            return applicationContext
        }
    }

}