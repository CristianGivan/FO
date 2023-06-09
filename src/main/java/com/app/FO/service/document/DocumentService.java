package com.app.FO.service.document;

import com.app.FO.config.DateTime;
import com.app.FO.exceptions.*;
import com.app.FO.model.document.*;
import com.app.FO.model.reminder.Reminder;
import com.app.FO.model.tag.Tag;
import com.app.FO.model.tasks.Tasks;
import com.app.FO.model.topic.Topic;
import com.app.FO.model.user.User;
import com.app.FO.repository.document.DocumentRepository;
import com.app.FO.util.ServiceAll;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class DocumentService {
    private DocumentRepository documentRepository;

    private ServiceAll serviceAll;

    @Autowired
    public DocumentService(DocumentRepository documentRepository, ServiceAll serviceAll) {
        this.documentRepository = documentRepository;
        this.serviceAll = serviceAll;
    }

//-- Post

    public Document postDocument(String subject) {
        User logInUser = serviceAll.getLogInUser();

        Document document = documentRepository.getDocumentFromUserIdBySubject(logInUser.getId(), subject);
        if (document != null) {
            throw new DocumentAlreadyExistException("Document with this subject already exist");
        }

        document = documentRepository.save(new Document(subject, logInUser));

        DocumentUser documentUser = new DocumentUser(document, logInUser);
        document.getDocumentUserList().add(documentUser);

        return documentRepository.save(document);
    }

    //-- Put
    public Document putSubjectToDocument(Long documentId, String subject) {
        User logInUser = serviceAll.getLogInUser();
        Document document = documentRepository.getDocumentFromUserIdByDocumentId(logInUser.getId(), documentId);
        if (document == null) {
            throw new DocumentNotFoundException("Document not found in your list");
        }

        if (document.getSubject().equals(subject)) {
            throw new DocumentAlreadyExistException("Document has already the same subject");
        }

        document.setSubject(subject);

        return documentRepository.save(document);
    }

    public Document putTypeToDocument(Long documentId, String type) {
        User logInUser = serviceAll.getLogInUser();
        Document document = documentRepository.getDocumentFromUserIdByDocumentId(logInUser.getId(), documentId);
        if (document == null) {
            throw new DocumentNotFoundException("Document not found in your list");
        }

        if (document.getType().equals(type)) {
            throw new DocumentAlreadyExistException("Document has already the same type");
        }

        document.setType(type);

        return documentRepository.save(document);
    }

    public Document putUserToDocument(Long documentId, Long userId) {
        User logInUser = serviceAll.getLogInUser();

        Document document = documentRepository.getDocumentFromUserIdByDocumentId(logInUser.getId(), documentId);
        if (document == null) {
            throw new DocumentNotFoundException("Document not found in your list");
        }

        User user = serviceAll.getUserByUserId(userId);
        if (user == null) {
            throw new UserNotFoundException("User not found");
        }

        DocumentUser documentUser = serviceAll.getDocumentUser(documentId, userId);
        if (documentUser != null) {
            throw new DocumentUserAlreadyExistException("The document already has the user");
        }

        documentUser = new DocumentUser(document, user);
        document.getDocumentUserList().add(documentUser);

        return documentRepository.save(document);
    }

    public Document putTagToDocument(Long documentId, Long tagId) {
        User logInUser = serviceAll.getLogInUser();

        Document document = documentRepository.getDocumentFromUserIdByDocumentId(logInUser.getId(), documentId);
        if (document == null) {
            throw new DocumentNotFoundException("Document not found in your list");
        }

        Tag tag = serviceAll.getTagFromUserIdAndTagId(logInUser.getId(), tagId);
        if (tag == null) {
            throw new TagNotFoundException("Tag not found");
        }

        DocumentTag documentTag = serviceAll.getDocumentTag(documentId, tagId);
        if (documentTag != null) {
            throw new DocumentTagAlreadyExistException("The document already has the tag");
        }

        documentTag = new DocumentTag(document, tag);
        document.getDocumentTagList().add(documentTag);

        return documentRepository.save(document);
    }


    public Document putReminderToDocument(Long documentId, Long reminderId) {
        User logInUser = serviceAll.getLogInUser();

        Document document = documentRepository.getDocumentFromUserIdByDocumentId(logInUser.getId(), documentId);
        if (document == null) {
            throw new DocumentNotFoundException("Document not found in your list");
        }

        Reminder reminder = serviceAll.getReminderFromUserIdByReminderId(logInUser.getId(), reminderId);
        if (reminder == null) {
            throw new ReminderNotFoundException("Reminder not found");
        }

        DocumentReminder documentReminder = serviceAll.getDocumentReminder(documentId, reminderId);
        if (documentReminder != null) {
            throw new DocumentReminderAlreadyExistException("The document already has the reminder");
        }

        documentReminder = new DocumentReminder(document, reminder);
        document.getDocumentReminderList().add(documentReminder);

        return documentRepository.save(document);
    }

    public Document putTopicToDocument(Long documentId, Long topicId) {
        User logInUser = serviceAll.getLogInUser();

        Document document = documentRepository.getDocumentFromUserIdByDocumentId(logInUser.getId(), documentId);
        if (document == null) {
            throw new DocumentNotFoundException("Document not found in your list");
        }

        Topic topic = serviceAll.getTopicFromUserIdByTopicId(logInUser.getId(), topicId);
        if (topic == null) {
            throw new TopicNotFoundException("Topic not found");
        }

        DocumentTopic documentTopic = serviceAll.getDocumentTopic(documentId, topicId);
        if (documentTopic != null) {
            throw new DocumentTopicAlreadyExistException("The document already has the topic");
        }

        documentTopic = new DocumentTopic(document, topic);
        document.getDocumentTopicList().add(documentTopic);
        return documentRepository.save(document);
    }

    public Document putTasksToDocument(Long documentId, Long tasksId) {
        User logInUser = serviceAll.getLogInUser();

        Document document = documentRepository.getDocumentFromUserIdByDocumentId(logInUser.getId(), documentId);
        if (document == null) {
            throw new DocumentNotFoundException("Document not found in your list");
        }

        Tasks tasks = serviceAll.getTasksFromUserIdAndTasksId(logInUser.getId(), tasksId);
        if (tasks == null) {
            throw new TasksNotFoundException("Tasks not found");
        }

        DocumentTasks documentTasks = serviceAll.getDocumentTasks(documentId, tasksId);
        if (documentTasks != null) {
            throw new DocumentTasksAlreadyExistException("The document already has the tasks");
        }

        documentTasks = new DocumentTasks(document, tasks);
        document.getDocumentTasksList().add(documentTasks);
        return documentRepository.save(document);
    }


    //--Delete


    public Document deleteUserFromDocument(Long documentId, Long userId) {
        User logInUser = serviceAll.getLogInUser();

        Document document = documentRepository.getDocumentFromUserIdByDocumentId(logInUser.getId(), documentId);
        if (document == null) {
            throw new DocumentNotFoundException("Document not found in your list");
        }

        User user = serviceAll.getUserByUserId(userId);
        if (user == null) {
            throw new UserNotFoundException("User not found");
        }

        DocumentUser documentUser = serviceAll.getDocumentUser(documentId, userId);
        if (documentUser == null) {
            throw new DocumentUserNotFoundException("The document don't has the user");
        }
        document.getDocumentUserList().remove(documentUser);

        return documentRepository.save(document);
    }

    public Document deleteTagFromDocument(Long documentId, Long tagId) {
        User logInUser = serviceAll.getLogInUser();

        Document document = documentRepository.getDocumentFromUserIdByDocumentId(logInUser.getId(), documentId);
        if (document == null) {
            throw new DocumentNotFoundException("Document not found in your list");
        }

        Tag tag = serviceAll.getTagFromUserIdAndTagId(logInUser.getId(), tagId);
        if (tag == null) {
            throw new TagNotFoundException("Tag not found");
        }

        DocumentTag documentTag = serviceAll.getDocumentTag(documentId, tagId);
        if (documentTag == null) {
            throw new DocumentTagNotFoundException("The document don't has the tag");
        }

        document.getDocumentTagList().remove(documentTag);

        return documentRepository.save(document);
    }

    public Document deleteReminderFromDocument(Long documentId, Long reminderId) {
        User logInUser = serviceAll.getLogInUser();

        Document document = documentRepository.getDocumentFromUserIdByDocumentId(logInUser.getId(), documentId);
        if (document == null) {
            throw new DocumentNotFoundException("Document not found in your list");
        }

        Reminder reminder = serviceAll.getReminderFromUserIdByReminderId(logInUser.getId(), reminderId);
        if (reminder == null) {
            throw new ReminderNotFoundException("Reminder not found");
        }

        DocumentReminder documentReminder = serviceAll.getDocumentReminder(documentId, reminderId);
        if (documentReminder == null) {
            throw new DocumentReminderNotFoundException("The document don't has the reminder");
        }

        document.getDocumentReminderList().remove(documentReminder);

        return documentRepository.save(document);
    }

    public Document deleteTopicFromDocument(Long documentId, Long topicId) {
        User logInUser = serviceAll.getLogInUser();

        Document document = documentRepository.getDocumentFromUserIdByDocumentId(logInUser.getId(), documentId);
        if (document == null) {
            throw new DocumentNotFoundException("Document not found in your list");
        }

        Topic topic = serviceAll.getTopicFromUserIdByTopicId(logInUser.getId(), topicId);
        if (topic == null) {
            throw new TopicNotFoundException("Topic not found");
        }

        DocumentTopic documentTopic = serviceAll.getDocumentTopic(documentId, topicId);
        if (documentTopic == null) {
            throw new DocumentTasksNotFoundException("The document don't has the topic");
        }

        document.getDocumentTopicList().remove(documentTopic);

        return documentRepository.save(document);
    }

    public Document deleteTasksFromDocument(Long documentId, Long tasksId) {
        User logInUser = serviceAll.getLogInUser();

        Document document = documentRepository.getDocumentFromUserIdByDocumentId(logInUser.getId(), documentId);
        if (document == null) {
            throw new DocumentNotFoundException("Document not found in your list");
        }

        Tasks tasks = serviceAll.getTasksFromUserIdAndTasksId(logInUser.getId(), tasksId);
        if (tasks == null) {
            throw new TasksNotFoundException("Tasks not found");
        }

        DocumentTasks documentTasks = serviceAll.getDocumentTasks(documentId, tasksId);
        if (documentTasks == null) {
            throw new DocumentTasksNotFoundException("The document don't has the tasks");
        }

        document.getDocumentTasksList().remove(documentTasks);

        return documentRepository.save(document);
    }

    public List<Document> deleteDocument(Long documentId) {
        User logInUser = serviceAll.getLogInUser();

        Document document = documentRepository.getDocumentFromUserIdByDocumentId(logInUser.getId(), documentId);
        if (document == null) {
            throw new DocumentNotFoundException("Document not found in your list");
        }
        documentRepository.delete(document);
        return getAllDocument();
    }
    //-- GET


    public List<Document> getAllDocument() {
        User logInUser = serviceAll.getLogInUser();
        List<Document> documentList = documentRepository.getDocumentListFromUserId(logInUser.getId());
        if (documentList.isEmpty()) {
            throw new DocumentNotFoundException("No document found");
        }
        return documentList;
    }

    public Document getDocumentByDocumentId(Long documentId) {
        User logInUser = serviceAll.getLogInUser();
        Document document = documentRepository.getDocumentFromUserIdByDocumentId(logInUser.getId(), documentId);
        if (document == null) {
            throw new DocumentNotFoundException("No document found");
        }
        return document;
    }

    public Document getDocumentBySubject(String subject) {
        User logInUser = serviceAll.getLogInUser();
        Document document = documentRepository.getDocumentFromUserIdBySubject(logInUser.getId(), subject);
        if (document == null) {
            throw new DocumentNotFoundException("No document found");
        }
        return document;
    }

    public List<Document> getDocumentListBySubjectContains(String subjectContains) {
        User logInUser = serviceAll.getLogInUser();
        List<Document> documentList = documentRepository.getDocumentListBySubjectContains(logInUser.getId(), subjectContains);
        if (documentList.isEmpty()) {
            throw new DocumentNotFoundException("No document found");
        }
        return documentList;
    }

    public Document getDocumentByType(String type) {
        User logInUser = serviceAll.getLogInUser();
        Document document = documentRepository.getDocumentFromUserIdByType(logInUser.getId(), type);
        if (document == null) {
            throw new DocumentNotFoundException("No document found");
        }
        return document;
    }

    public List<Document> getDocumentListByTypeContains(String typeContains) {
        User logInUser = serviceAll.getLogInUser();
        List<Document> documentList = documentRepository.getDocumentListByTypeContains(logInUser.getId(), typeContains);
        if (documentList.isEmpty()) {
            throw new DocumentNotFoundException("No document found");
        }
        return documentList;
    }

    public Document getDocumentByCreatedDate(String createdDate) {
        LocalDateTime createdDateTime = DateTime.textToLocalDateTime(createdDate);
        User logInUser = serviceAll.getLogInUser();
        Document document = documentRepository.getDocumentFromUserIdByCreatedDate(logInUser.getId(), createdDateTime);
        if (document == null) {
            throw new DocumentNotFoundException("No document found");
        }
        return document;
    }

    public List<Document> getDocumentListByCreatedDateBetween(String createdDateMin, String createdDateMax) {
        LocalDateTime createdDateTimeMin = DateTime.textToLocalDateTime(createdDateMin);
        LocalDateTime createdDateTimeMax = DateTime.textToLocalDateTime(createdDateMax);
        User logInUser = serviceAll.getLogInUser();
        List<Document> documentList = documentRepository.getDocumentListFromUserIdByCreatedDateBetween(logInUser.getId(), createdDateTimeMin, createdDateTimeMax);
        if (documentList.isEmpty()) {
            throw new DocumentNotFoundException("No document found");
        }
        return documentList;
    }

    public List<Document> getDocumentListByUserId(Long userId) {
        User logInUser = serviceAll.getLogInUser();
        List<Document> documentList = documentRepository.getDocumentListFromUserIdByUserId(logInUser.getId(), userId);
        if (documentList.isEmpty()) {
            throw new DocumentNotFoundException("No document found");
        }
        return documentList;
    }

    public List<Document> getDocumentListByTagId(Long tagId) {
        User logInUser = serviceAll.getLogInUser();
        List<Document> documentList = documentRepository.getDocumentListFromUserIdByTagId(logInUser.getId(), tagId);
        if (documentList.isEmpty()) {
            throw new DocumentNotFoundException("No document found");
        }
        return documentList;
    }

    public List<Document> getDocumentListByReminderId(Long reminderId) {
        User logInUser = serviceAll.getLogInUser();
        List<Document> documentList = documentRepository.getDocumentListFromUserIdByReminderId(logInUser.getId(), reminderId);
        if (documentList.isEmpty()) {
            throw new DocumentNotFoundException("No document found");
        }
        return documentList;
    }

    public List<Document> getDocumentListByTopicId(Long topicId) {
        User logInUser = serviceAll.getLogInUser();
        List<Document> documentList = documentRepository.getDocumentListFromUserIdByTopicId(logInUser.getId(), topicId);
        if (documentList.isEmpty()) {
            throw new DocumentNotFoundException("No document found");
        }
        return documentList;
    }

    public List<Document> getDocumentListByTasksId(Long tasksId) {
        User logInUser = serviceAll.getLogInUser();
        List<Document> documentList = documentRepository.getDocumentListFromUserIdByTasksId(logInUser.getId(), tasksId);
        if (documentList.isEmpty()) {
            throw new DocumentNotFoundException("No document found");
        }
        return documentList;
    }

    //-- Other


}
