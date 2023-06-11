package com.app.FO.repository.person;

import com.app.FO.model.person.PersonDocument;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonDocumentRepository extends JpaRepository<PersonDocument, Long> {

    @Query(nativeQuery = true, value =
            "SELECT * FROM person_document as tt where tt.person_id=?1 and tt.document_id=?2")
    PersonDocument getPersonDocumentByPersonIdAndDocumentId(Long personId, Long documentId);


}
