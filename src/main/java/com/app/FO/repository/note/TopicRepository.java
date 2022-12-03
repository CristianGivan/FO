package com.app.FO.repository.note;

import com.app.FO.model.note.Topic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TopicRepository extends JpaRepository<Topic,Long> {
}
