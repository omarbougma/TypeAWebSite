package com.projecttypea.typea.service;

import java.io.IOException;
import java.util.List;
import com.projecttypea.typea.bean.Documents;
import com.projecttypea.typea.dao.DocumentsDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

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

    public Documents storeDocument(MultipartFile document) throws IOException {
        String documentName = document.getOriginalFilename();
        Documents documents = new Documents(documentName, document.getContentType(), document.getBytes());
        return documentsDao.save(documents);
    }

}
