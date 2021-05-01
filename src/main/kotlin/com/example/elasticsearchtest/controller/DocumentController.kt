package com.example.elasticsearchtest.controller

import com.example.elasticsearchtest.controller.PaginationUtils.DEFAULT_PAGE
import com.example.elasticsearchtest.controller.PaginationUtils.DEFAULT_PAGE_SIZE
import com.example.elasticsearchtest.model.documents.Document
import com.example.elasticsearchtest.repository.DocumentRepository
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageRequest
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/documents")
class DocumentController(val documentRepository: DocumentRepository) {


    @GetMapping
    fun getDocuments(@RequestParam("page", required = false, defaultValue = DEFAULT_PAGE.toString()) page: Int?,
                         @RequestParam("size", required = false, defaultValue = DEFAULT_PAGE_SIZE.toString()) size: Int?): Page<Document> {

        return documentRepository.findAll(PageRequest.of(PaginationUtils.getPage(page), PaginationUtils.getSize(size)))
    }

    @GetMapping("/{id}")
    fun getOne(@PathVariable("id") id: String): Document {

        return documentRepository.findById(id).orElse(null)
    }

    @PostMapping()
    fun save(@RequestBody document: Document): Document {

        return documentRepository.save(document);
    }

    @PutMapping("/{id}")
    fun update(@PathVariable("id") id: String,
               @RequestBody document: Document): Document {

        document.id = id
        return documentRepository.save(document)
    }

    @DeleteMapping("/{id}")
    fun delete(@PathVariable("id") id: String) {
        documentRepository.deleteById(id)
    }
}