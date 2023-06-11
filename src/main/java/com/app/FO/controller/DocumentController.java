package com.app.FO.controller;

import com.app.FO.mapper.dto.document.DocumentDTO;
import com.app.FO.mapper.mappers.DocumentDTOMapper;
import com.app.FO.model.document.Document;
import com.app.FO.service.document.DocumentService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("document")
public class DocumentController {
    private DocumentService documentService;

    private DocumentDTOMapper documentDTOMapper;

    @Autowired
    public DocumentController(DocumentService documentService, DocumentDTOMapper documentDTOMapper) {
        this.documentService = documentService;
        this.documentDTOMapper = documentDTOMapper;
    }

    //-- PostMapping

    @PostMapping("/postNewDocument")
    public DocumentDTO postNewDocument(@RequestParam String subject, @RequestParam String type) {
        Document document = documentService.postDocument(subject, type);
        return documentDTOMapper.documentToDocumentDTO(document);
    }


    //-- PutMapping
    @PutMapping("/putSubjectToDocument")
    public DocumentDTO putSubjectToDocument(@RequestParam Long documentId, @RequestParam String subject) {
        Document document = documentService.putSubjectToDocument(documentId, subject);
        return documentDTOMapper.documentToDocumentDTO(document);
    }


    //-- PutMapping
    @PutMapping("/putTypeToDocument")
    public DocumentDTO putTypeToDocument(@RequestParam Long documentId, @RequestParam String type) {
        Document document = documentService.putTypeToDocument(documentId, type);
        return documentDTOMapper.documentToDocumentDTO(document);
    }

    @PutMapping("/putUserToDocument")
    public DocumentDTO putUserToDocument(@RequestParam Long documentId, @RequestParam Long userId) {
        Document document = documentService.putUserToDocument(documentId, userId);
        return documentDTOMapper.documentToDocumentDTO(document);
    }

    @PutMapping("/putTagToDocument")
    public DocumentDTO putTagToDocument(@RequestParam Long documentId, @RequestParam Long tagId) {
        Document document = documentService.putTagToDocument(documentId, tagId);
        return documentDTOMapper.documentToDocumentDTO(document);
    }


    @PutMapping("/putReminderToDocument")
    public DocumentDTO putReminderToDocument(@RequestParam Long documentId, @RequestParam Long reminderId) {
        Document document = documentService.putReminderToDocument(documentId, reminderId);
        return documentDTOMapper.documentToDocumentDTO(document);
    }

    @PutMapping("/putTopicToDocument")
    public DocumentDTO putTopicToDocument(@RequestParam Long documentId, @RequestParam Long topicId) {
        Document document = documentService.putTopicToDocument(documentId, topicId);
        return documentDTOMapper.documentToDocumentDTO(document);
    }

    @PutMapping("/putTasksToDocument")
    public DocumentDTO putTasksToDocument(@RequestParam Long documentId, @RequestParam Long tasksId) {
        Document document = documentService.putTasksToDocument(documentId, tasksId);
        return documentDTOMapper.documentToDocumentDTO(document);
    }


    //-- DeleteMapping


    @DeleteMapping("/deleteUserFromDocument")
    public DocumentDTO deleteRoleFromDocument(@RequestParam Long documentId, @RequestParam Long userId) {
        Document document = documentService.deleteUserFromDocument(documentId, userId);
        return documentDTOMapper.documentToDocumentDTO(document);
    }

    @DeleteMapping("/deleteTagFromDocument")
    public DocumentDTO deleteTagFromDocument(@RequestParam Long documentId, @RequestParam Long tagId) {
        Document document = documentService.deleteTagFromDocument(documentId, tagId);
        return documentDTOMapper.documentToDocumentDTO(document);
    }

    @DeleteMapping("/deleteReminderFromDocument")
    public DocumentDTO deleteReminderFromDocument(@RequestParam Long documentId, @RequestParam Long reminderId) {
        Document document = documentService.deleteReminderFromDocument(documentId, reminderId);
        return documentDTOMapper.documentToDocumentDTO(document);
    }


    @DeleteMapping("/deleteTopicFromDocument")
    public DocumentDTO deleteTopicFromDocument(@RequestParam Long documentId, @RequestParam Long topicId) {
        Document document = documentService.deleteTopicFromDocument(documentId, topicId);
        return documentDTOMapper.documentToDocumentDTO(document);
    }

    @DeleteMapping("/deleteTasksFromDocument")
    public DocumentDTO deleteTasksFromDocument(@RequestParam Long documentId, @RequestParam Long tasksId) {
        Document document = documentService.deleteTasksFromDocument(documentId, tasksId);
        return documentDTOMapper.documentToDocumentDTO(document);
    }

    @DeleteMapping("/deleteDocument")
    public List<DocumentDTO> deleteDocument(@RequestParam Long documentId) {
        List<Document> documentList = documentService.deleteDocument(documentId);
        return documentDTOMapper.documentListToDocumentDTOList(documentList);
    }


    //---GetMapping

    @GetMapping("/getAllDocument")
    public List<DocumentDTO> getAllDocument() {
        List<Document> documentList = documentService.getAllDocument();
        return documentDTOMapper.documentListToDocumentDTOList(documentList);
    }

    @GetMapping("/getDocumentById")
    public DocumentDTO getDocumentById(@RequestParam Long documentId) {
        Document document = documentService.getDocumentByDocumentId(documentId);
        return documentDTOMapper.documentToDocumentDTO(document);
    }

    @GetMapping("/getDocumentBySubject")
    public DocumentDTO getDocumentBySubject(@RequestParam String subject) {
        Document document = documentService.getDocumentBySubject(subject);
        return documentDTOMapper.documentToDocumentDTO(document);
    }

    @GetMapping("/getDocumentListBySubjectContains")
    public List<DocumentDTO> getDocumentListBySubjectContains(@RequestParam String subjectContain) {
        List<Document> documentList = documentService.getDocumentListBySubjectContains(subjectContain);
        return documentDTOMapper.documentListToDocumentDTOList(documentList);
    }

    @GetMapping("/getDocumentByType")
    public DocumentDTO getDocumentByType(@RequestParam String type) {
        Document document = documentService.getDocumentByType(type);
        return documentDTOMapper.documentToDocumentDTO(document);
    }

    @GetMapping("/getDocumentListByTypeContains")
    public List<DocumentDTO> getDocumentListByTypeContains(@RequestParam String typeContain) {
        List<Document> documentList = documentService.getDocumentListByTypeContains(typeContain);
        return documentDTOMapper.documentListToDocumentDTOList(documentList);
    }

    @GetMapping("/getDocumentByCreatedDate")
    @ApiOperation(value = "Formatter    yyyy-MM-dd HH:mm:ss 2023.06.01 13:14:15")
    public DocumentDTO getDocumentByCreatedDate(@RequestParam String createdDate) {
        Document document = documentService.getDocumentByCreatedDate(createdDate);
        return documentDTOMapper.documentToDocumentDTO(document);
    }

    @GetMapping("/getDocumentListByCreatedDateBetween")
    public List<DocumentDTO> getDocumentListByCreatedDateBetween(@RequestParam String createdDateMin, @RequestParam String createdDateMax) {
        List<Document> documentList = documentService.getDocumentListByCreatedDateBetween(createdDateMin, createdDateMax);
        return documentDTOMapper.documentListToDocumentDTOList(documentList);
    }

    @GetMapping("/getDocumentListByUserId")
    public List<DocumentDTO> getDocumentListByUserId(@RequestParam Long userId) {
        List<Document> documentList = documentService.getDocumentListByUserId(userId);
        return documentDTOMapper.documentListToDocumentDTOList(documentList);
    }

    @GetMapping("/getDocumentListByTagId")
    public List<DocumentDTO> getDocumentListByTagId(@RequestParam Long tagId) {
        List<Document> documentList = documentService.getDocumentListByTagId(tagId);
        return documentDTOMapper.documentListToDocumentDTOList(documentList);
    }

    @GetMapping("/getDocumentListByReminderId")
    public List<DocumentDTO> getDocumentListByReminderId(@RequestParam Long reminderId) {
        List<Document> documentList = documentService.getDocumentListByReminderId(reminderId);
        return documentDTOMapper.documentListToDocumentDTOList(documentList);
    }

    @GetMapping("/getDocumentListByTopicId")
    public List<DocumentDTO> getDocumentListByTopicId(@RequestParam Long topicId) {
        List<Document> documentList = documentService.getDocumentListByTopicId(topicId);
        return documentDTOMapper.documentListToDocumentDTOList(documentList);
    }

    @GetMapping("/getDocumentListByTasksId")
    public List<DocumentDTO> getDocumentListByTasksId(@RequestParam Long tasksId) {
        List<Document> documentList = documentService.getDocumentListByTasksId(tasksId);
        return documentDTOMapper.documentListToDocumentDTOList(documentList);
    }


    //--- Other


}
