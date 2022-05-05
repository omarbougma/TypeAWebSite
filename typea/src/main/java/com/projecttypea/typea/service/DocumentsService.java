package com.projecttypea.typea.service;

import java.util.List;

import com.projecttypea.typea.bean.Documents;
import com.projecttypea.typea.dao.DocumentsDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DocumentsService {
    @Autowired
    DocumentsDao documentsDao;

    public void deleteById(Long id) {
        documentsDao.deleteById(id);
    }

    public List<Documents> findAll() {
        return documentsDao.findAll();
    }

    public Documents storeDocument(Documents document) {
        return documentsDao.save(document);
    }

    public void updateDocuments(Long id, Documents document) {
        Documents currentDocument = documentsDao.getById(id);
        currentDocument.setData(document.getData());
        currentDocument.setName(document.getName());
        documentsDao.save(currentDocument);
    }
}
