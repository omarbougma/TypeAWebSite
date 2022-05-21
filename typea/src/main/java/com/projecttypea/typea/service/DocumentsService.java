package com.projecttypea.typea.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

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

    public int storeDocumentMissionStage(Long missionId, MultipartFile document, MultipartFile document1,
            MultipartFile document2,
            MultipartFile document3, MultipartFile document4, MultipartFile document5) throws IOException {
        storeDocumentMission(missionId, document);
        storeDocumentMission(missionId, document1);
        storeDocumentMission(missionId, document2);
        storeDocumentMission(missionId, document3);
        storeDocumentMission(missionId, document4);
        storeDocumentMission(missionId, document5);
        return 1;
    }

    public int storeDocumentManifestation(Long manifId, MultipartFile document, MultipartFile document1,
            MultipartFile document2,
            MultipartFile document3, MultipartFile document4, MultipartFile document5) throws IOException {
        storeDocumentManifestation(manifId, document);
        storeDocumentManifestation(manifId, document1);
        storeDocumentManifestation(manifId, document2);
        storeDocumentManifestation(manifId, document3);
        storeDocumentManifestation(manifId, document4);
        storeDocumentManifestation(manifId, document5);
        return 1;
    }

    public int storeDocumentMission(Long missionId, MultipartFile document) throws IOException {
        String documentName = document.getOriginalFilename();
        Documents documents = new Documents(documentName, document.getContentType(), document.getBytes());
        MissionStage curreMissionStage = missionStageDao.getById(missionId);
        documents.setMissionstage(curreMissionStage);
        documents.setName(UUID.randomUUID().toString());
        documentsDao.save(documents);

        return 1;
    }

    public int storeDocumentManifestation(Long manifId, MultipartFile document) throws IOException {
        String documentName = document.getOriginalFilename();
        Documents documents = new Documents(documentName, document.getContentType(), document.getBytes());
        Manifestation currentManifestation = manifestationDao.getById(manifId);
        documents.setManifestation(currentManifestation);
        documents.setName(UUID.randomUUID().toString());
        documentsDao.save(documents);
        return 1;
    }

    public byte[] retrieve(String docName) {
        Documents doc = documentsDao.findByName(docName);
        byte[] docBytes = doc.getData();
        return docBytes;
    }

    public List<Documents> findAllByMStageId(Long mStageId) {
        MissionStage currentMStage = missionStageDao.getById(mStageId);
        List<Documents> docs = currentMStage.getDocuments();
        return docs;
    }

}
