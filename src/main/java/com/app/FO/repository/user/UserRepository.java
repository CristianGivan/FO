package com.app.FO.repository.user;

import com.app.FO.model.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
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
            "SELECT * FROM user as t  where t.username=?1")
    List<User> getUserListByUsername(String username);

    @Query(nativeQuery = true, value =
            "SELECT * FROM user as t where t.username like %:containingText%")
    List<User> getUserListFromUserIdByUsernameContains(@Param("containingText") String usernameText);


    @Query(nativeQuery = true, value =
            "SELECT * FROM user as t where t.created_date=?1")
    User getUserFromUserIdByCreatedDate(Long userId, LocalDateTime createdDate);

    @Query(nativeQuery = true, value =
            "SELECT * FROM user as t where t.created_date between ?1 and ?2")
    List<User> getUserListFromUserIdByCreatedDateBetween(Long UserId, LocalDateTime createdDateMin, LocalDateTime createdDateMax);


//    @Query(nativeQuery = true, value =
//            "SELECT * FROM user as t inner join user_user tu on t.user_id = tu.user_id where tu.user_id=?1 and tu.userLinked=?2 and t.username=?3")
//    User getUserListByUsername(Long logInUserId,Long userLinkedId, String username);
//
//    @Query(nativeQuery = true, value =
//            "SELECT * FROM user as t inner join user_user ut on t.user_id = ut.user_id where ut.user_id=:userId and ut.user_linked_id=:userLinkedId and t.username like %:containingText%")
//    List<User> getUserListFromUserIdByUsernameContains(@Param("userId") Long UserId,@Param("userLinkedId") Long userLinkedId, @Param("containingText") String usernameText);


//
//    @Query(nativeQuery = true, value =
//            "SELECT * FROM user as u inner join tag_user tu on u.user_id = tu.user_id where tu.tag_id=?1")
//    List<User> getUserListByTagId(Long tagId);


    @Query(nativeQuery = true, value =
            "SELECT * FROM user as u inner join user_user uu on u.user_id = uu.user_id where uu.user_id=?1")
    List<User> getUserListByUserId(Long userId);

    @Query(nativeQuery = true, value =
            "SELECT * FROM user as u where u.email_id=?1")
    List<User> getUserListByEmailId(Long emailId);

    @Query(nativeQuery = true, value =
            "SELECT * FROM user as u where u.role_id=?1")
    List<User> getUserListByRole(Long roleId);

    @Query(nativeQuery = true, value =
            "SELECT * FROM user as u inner join user_user uu on u.user_id = uu.user_id where uu.user_id=?1")
    List<Long> getUserIdListByUserId(Long userId);

//    List<User> getUsersByUserList_User(User user);

    @Query(nativeQuery = true, value =
            "SELECT * FROM user_user as uu where uu.user_id = ?1 and uu.user_linked_id = ?2")
    User getUserFromUserIdByUserId(Long userId, Long userLinkedId);
}
