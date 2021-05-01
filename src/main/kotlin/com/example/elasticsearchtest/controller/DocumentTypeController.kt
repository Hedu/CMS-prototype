package com.example.elasticsearchtest.controller

import com.example.elasticsearchtest.controller.PaginationUtils.DEFAULT_PAGE
import com.example.elasticsearchtest.controller.PaginationUtils.DEFAULT_PAGE_SIZE
import com.example.elasticsearchtest.model.documents.DocumentType
import com.example.elasticsearchtest.repository.DocumentTypeRepository
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageRequest
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/documentTypes")
class DocumentTypeController(val documentTypeRepository: DocumentTypeRepository) {


    @GetMapping
    fun getDocumentTypes(@RequestParam("page", required = false, defaultValue = DEFAULT_PAGE.toString()) page: Int?,
                         @RequestParam("size", required = false, defaultValue = DEFAULT_PAGE_SIZE.toString()) size: Int?): Page<DocumentType> {

        return documentTypeRepository.findAll(PageRequest.of(PaginationUtils.getPage(page), PaginationUtils.getSize(size)))
    }

    @GetMapping("/{id}")
    fun getOne(@PathVariable("id") id: String): DocumentType {

        return documentTypeRepository.findById(id).orElse(null)
    }

    @PostMapping()
    fun save(@RequestBody documentType: DocumentType): DocumentType {

        return documentTypeRepository.save(documentType);
    }

    @PutMapping("/{id}")
    fun update(@PathVariable("id") id: String,
               @RequestBody documentType: DocumentType): DocumentType {

        documentType.id = id
        return documentTypeRepository.save(documentType)
    }

    @DeleteMapping("/{id}")
    fun delete(@PathVariable("id") id: String) {
        documentTypeRepository.deleteById(id)
    }
}