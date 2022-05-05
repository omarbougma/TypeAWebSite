package com.projecttypea.typea.ws;

import java.util.List;

import javax.transaction.Transactional;

import com.projecttypea.typea.bean.Documents;
import com.projecttypea.typea.service.DocumentsService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/documentsapi")
@RestController
public class DocumentsWS {
    @Autowired
    DocumentsService documentsService;

    @Transactional
    @DeleteMapping("/deletedocument/{id}")
    public void deleteById(@PathVariable Long id) {
        documentsService.deleteById(id);
    }

    @GetMapping("/documents")
    public List<Documents> findAll() {
        return documentsService.findAll();
    }

    @PostMapping("/add_document")
    public Documents storeDocument(@RequestBody Documents document) {
        return documentsService.storeDocument(document);
    }

    @PutMapping("/updatedocument/{id}")
    public void updateDocuments(@PathVariable Long id, @RequestBody Documents document) {
        documentsService.updateDocuments(id, document);
    }

}
