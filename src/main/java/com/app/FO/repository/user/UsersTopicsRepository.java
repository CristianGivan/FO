package com.app.FO.repository.user;

import com.app.FO.model.topic.TopicNote;
import com.app.FO.model.user.UserTag;
import com.app.FO.model.user.UsersTopics;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersTopicsRepository extends JpaRepository<UsersTopics, Long> {


}
