package com.app.FO.repository.document;

import com.app.FO.model.document.DocumentTag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface DocumentTagRepository extends JpaRepository<DocumentTag, Long> {

    @Query(nativeQuery = true, value =
            "SELECT * FROM document_tag as tt where tt.document_id=?1 and tt.tag_id=?2")
    DocumentTag getDocumentTagByDocumentIdAndTagId(Long documentId, Long tagId);


}
