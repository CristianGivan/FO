package com.app.FO.repository.user;

import com.app.FO.model.topic.TopicUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersTopicsRepository extends JpaRepository<TopicUser, Long> {


}
