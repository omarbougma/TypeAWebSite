package com.projecttypea.typea.service;

import java.io.IOException;
import java.util.List;
import com.projecttypea.typea.bean.Documents;
import com.projecttypea.typea.bean.Manifestation;
import com.projecttypea.typea.bean.MissionStage;
import com.projecttypea.typea.dao.DocumentsDao;
import com.projecttypea.typea.dao.ManifestationDao;
import com.projecttypea.typea.dao.MissionStageDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class DocumentsService {
    @Autowired
    DocumentsDao documentsDao;

    @Autowired
    MissionStageDao missionStageDao;

    @Autowired
    ManifestationDao manifestationDao;

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

    public int storeDocumentMission(Long missionId, MultipartFile document) throws IOException {
        String documentName = document.getOriginalFilename();
        Documents documents = new Documents(documentName, document.getContentType(), document.getBytes());
        MissionStage curreMissionStage = missionStageDao.getById(missionId);
        documents.setMissionstage(curreMissionStage);
        documentsDao.save(documents);
        return 1;
    }

    public int storeDocumentManifestation(Long manifId, MultipartFile document) throws IOException {
        String documentName = document.getOriginalFilename();
        Documents documents = new Documents(documentName, document.getContentType(), document.getBytes());
        Manifestation currentManifestation = manifestationDao.getById(manifId);
        documents.setManifestation(currentManifestation);
        documentsDao.save(documents);
        return 1;
    }

    public byte[] retrieve(String docName) {
        Documents doc = documentsDao.findByName(docName);
        byte[] docBytes = doc.getData();
        return docBytes;
    }

}
