package com.example.elasticsearchtest.controller

object PaginationUtils {
    const val DEFAULT_PAGE =  1
    const val DEFAULT_PAGE_SIZE = 20

    fun getPage(page: Int?): Int {
        // pages in spring use the index zero
        return if (page?.minus(1)!! >= 0)  page - 1 else DEFAULT_PAGE - 1
    }

    fun getSize(size: Int?): Int {
       return (if (size!! < 1 || size!! > 1000) DEFAULT_PAGE_SIZE else size)!!
    }
}