package com.app.FO.repository.tag;

import com.app.FO.model.user.UserTag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TagUserRepository extends JpaRepository<UserTag , Long> {


}
