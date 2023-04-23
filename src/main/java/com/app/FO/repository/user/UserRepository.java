package com.app.FO.repository.user;

import com.app.FO.model.note.Note;
import com.app.FO.model.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {

    User findByUsername(String username);
    List<User> findAll();
    @Query(nativeQuery = true, value =
            "SELECT * FROM user as u where u.user_id=?1")
    User getUserByUserId(Long userId);
    @Query(nativeQuery = true, value =
            "SELECT * FROM user as u inner join note_user nu on u.user_id = nu.user_id where nu.note_id=?1")
    List<User> getUserListByNoteId(Long noteId);
}
