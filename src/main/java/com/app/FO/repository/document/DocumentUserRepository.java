package com.app.FO.repository.document;

import com.app.FO.model.document.DocumentUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface DocumentUserRepository extends JpaRepository<DocumentUser, Long> {

    @Query(nativeQuery = true, value =
            "SELECT * FROM document_user as tu where tu.document_id=?1 and tu.user_id=?2")
    DocumentUser getDocumentUserByDocumentIdAndUserId(Long documentId, Long userId);


}
