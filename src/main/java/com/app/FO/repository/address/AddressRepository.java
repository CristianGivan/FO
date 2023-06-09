package com.app.FO.repository.address;

import com.app.FO.model.address.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {


    @Query(nativeQuery = true, value =
            "SELECT * FROM address as t inner join address_user tu on t.address_id = tu.address_id where tu.user_id=?1")
    List<Address> getAddressListFromUserId(Long userId);

    @Query(nativeQuery = true, value =
            "SELECT * FROM address as t inner join address_user tu on t.address_id = tu.address_id where tu.user_id=?1 and tu.address_id=?2")
    Address getAddressFromUserIdByAddressId(Long userId, Long addressId);

    @Query(nativeQuery = true, value =
            "SELECT * FROM address as t inner join address_user tu on t.address_id = tu.address_id where tu.user_id=?1 and t.subject=?2")
    Address getAddressFromUserIdBySubject(Long userId, String subject);

    @Query(nativeQuery = true, value =
            "SELECT * FROM address as t inner join address_user ut on t.address_id = ut.address_id where ut.user_id=:userId and t.subject like %:containingText%")
    List<Address> getAddressListBySubjectContains(@Param("userId") Long UserId, @Param("containingText") String tagText);


    @Query(nativeQuery = true, value =
            "SELECT * FROM address as t inner join address_user tu on t.address_id = tu.address_id where tu.user_id=?1 and t.reference=?2")
    Address getAddressFromUserIdByReference(Long userId, String reference);

    @Query(nativeQuery = true, value =
            "SELECT * FROM address as t inner join address_user ut on t.address_id = ut.address_id where ut.user_id=:userId and t.reference like %:containingText%")
    List<Address> getAddressListByReferenceContains(@Param("userId") Long UserId, @Param("containingText") String tagText);

    @Query(nativeQuery = true, value =
            "SELECT * FROM address as t inner join address_user tu on t.address_id = tu.address_id where tu.user_id=?1 and t.created_date=?2")
    Address getAddressFromUserIdByCreatedDate(Long userId, LocalDateTime createdDate);

    @Query(nativeQuery = true, value =
            "SELECT * FROM address as t inner join address_user ut on t.address_id = ut.address_id where ut.user_id=?1 and t.created_date between ?2 and ?3")
    List<Address> getAddressListFromUserIdByCreatedDateBetween(Long UserId, LocalDateTime createdDateMin, LocalDateTime createdDateMax);

    @Query(nativeQuery = true, value =
            "SELECT * FROM address as t inner join address_topic as tn on t.address_id = tn.address_id inner join address_user tu on t.address_id = tu.address_id where tu.user_id=?1 and tn.topic_id=?2")
    List<Address> getAddressListFromUserIdByTopicId(Long userId, Long topicId);

    @Query(nativeQuery = true, value =
            "SELECT * FROM address as t inner join address_tasks as tn on t.address_id = tn.address_id inner join address_user tu on t.address_id = tu.address_id where tu.user_id=?1 and tn.tasks_id=?2")
    List<Address> getAddressListFromUserIdByTasksId(Long userId, Long tasksId);

    @Query(nativeQuery = true, value =
            "SELECT * FROM address as t inner join (SELECT ti.address_id FROM (SELECT t.address_id FROM address as t inner join address_user tu on t.address_id = tu.address_id where tu.user_id=?1) as ti inner join address_user tu on ti.address_id = tu.address_id where tu.user_id=?2)as tr on tr.address_id=t.address_id")
    List<Address> getAddressListFromUserIdByUserId(Long logInUserId, Long userId);

    @Query(nativeQuery = true, value =
            "SELECT * FROM address as t inner join address_tag as tt on t.address_id = tt.address_id inner join address_user tu on t.address_id = tu.address_id where tu.user_id=?1 and tt.tag_id=?2")
    List<Address> getAddressListFromUserIdByTagId(Long userId, Long tagId);

    @Query(nativeQuery = true, value =
            "SELECT * FROM address as t inner join address_reminder as tr on t.address_id = tr.address_id inner join address_user tu on t.address_id = tu.address_id where tu.user_id=?1 and tr.reminder_id=?2")
    List<Address> getAddressListFromUserIdByReminderId(Long userId, Long reminderId);

}
