package com.app.FO.repository.tag;

import com.app.FO.model.tag.TagUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TagUserRepository extends JpaRepository<TagUser, Long> {


}
