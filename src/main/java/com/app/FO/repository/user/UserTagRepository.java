package com.app.FO.repository.user;

import com.app.FO.model.user.UserTag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserTagRepository extends JpaRepository<UserTag , Long> {


}
