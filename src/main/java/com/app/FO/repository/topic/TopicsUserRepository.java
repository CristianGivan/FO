package com.app.FO.repository.topic;

import com.app.FO.model.topic.TopicUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TopicsUserRepository extends JpaRepository<TopicUser, Long> {


}
