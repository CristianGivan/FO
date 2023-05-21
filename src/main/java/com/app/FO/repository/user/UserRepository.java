package com.app.FO.repository.user;

import com.app.FO.model.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    List<User> findAll();

    @Query(nativeQuery = true, value =
            "SELECT * FROM user as u where u.user_id=?1")
    User getUserByUserId(Long userId);

    @Query(nativeQuery = true, value =
            "SELECT * FROM user as u where u.username=?1")
    User getUserByUserName(String userName);

    @Query(nativeQuery = true, value =
            "SELECT * FROM user as u inner join note_user nu on u.user_id = nu.user_id where nu.note_id=?1")
    List<User> getUserListByNoteId(Long noteId);

    @Query(nativeQuery = true, value =
            "SELECT * FROM user as u inner join tag_user tu on u.user_id = tu.user_id where tu.tag_id=?1")
    List<User> getUserListByTagId(Long tagId);

    @Query(nativeQuery = true, value =
            "SELECT * FROM user as u inner join user_role ur on u.user_id = ur.user_id where ur.role_id=?1")
    List<User> getUserListByRole(Long roleId);

    @Query(nativeQuery = true, value =
            "SELECT * FROM user_role as ur where ur.user_id = ?1 and ur.role_id = ?2)")
    Long userIdHasRoleId(Long userId, Long roleId);

    @Query(nativeQuery = true, value =
            "SELECT * FROM user as u inner join user_user uu on u.user_id = uu.user_id where uu.user_id=?1")
    List<User> getUserListByUserId(Long userId);

    List<User> getUsersByUserList_User(User user);

    @Query(nativeQuery = true, value =
            "SELECT * FROM user_user as uu where uu.user_id = ?1 and uu.user_linked_id = ?2")
    Long userIdHasUserId(Long userId, Long roleId);
}
