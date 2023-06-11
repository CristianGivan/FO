package com.app.FO.repository.phoneNumber;

import com.app.FO.model.phoneNumber.PhoneNumber;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface PhoneNumberRepository extends JpaRepository<PhoneNumber, Long> {


    @Query(nativeQuery = true, value =
            "SELECT * FROM phoneNumber as t inner join phoneNumber_user tu on t.phoneNumber_id = tu.phoneNumber_id where tu.user_id=?1")
    List<PhoneNumber> getPhoneNumberListFromUserId(Long userId);

    @Query(nativeQuery = true, value =
            "SELECT * FROM phoneNumber as t inner join phoneNumber_user tu on t.phoneNumber_id = tu.phoneNumber_id where tu.user_id=?1 and tu.phoneNumber_id=?2")
    PhoneNumber getPhoneNumberFromUserIdByPhoneNumberId(Long userId, Long phoneNumberId);

    @Query(nativeQuery = true, value =
            "SELECT * FROM phoneNumber as t inner join phoneNumber_user tu on t.phoneNumber_id = tu.phoneNumber_id where tu.user_id=?1 and t.subject=?2")
    PhoneNumber getPhoneNumberFromUserIdBySubject(Long userId, String subject);

    @Query(nativeQuery = true, value =
            "SELECT * FROM phoneNumber as t inner join phoneNumber_user ut on t.phoneNumber_id = ut.phoneNumber_id where ut.user_id=:userId and t.subject like %:containingText%")
    List<PhoneNumber> getPhoneNumberListBySubjectContains(@Param("userId") Long UserId, @Param("containingText") String tagText);


    @Query(nativeQuery = true, value =
            "SELECT * FROM phoneNumber as t inner join phoneNumber_user tu on t.phoneNumber_id = tu.phoneNumber_id where tu.user_id=?1 and t.reference=?2")
    PhoneNumber getPhoneNumberFromUserIdByReference(Long userId, String reference);

    @Query(nativeQuery = true, value =
            "SELECT * FROM phoneNumber as t inner join phoneNumber_user ut on t.phoneNumber_id = ut.phoneNumber_id where ut.user_id=:userId and t.reference like %:containingText%")
    List<PhoneNumber> getPhoneNumberListByReferenceContains(@Param("userId") Long UserId, @Param("containingText") String tagText);

    @Query(nativeQuery = true, value =
            "SELECT * FROM phoneNumber as t inner join phoneNumber_user tu on t.phoneNumber_id = tu.phoneNumber_id where tu.user_id=?1 and t.created_date=?2")
    PhoneNumber getPhoneNumberFromUserIdByCreatedDate(Long userId, LocalDateTime createdDate);

    @Query(nativeQuery = true, value =
            "SELECT * FROM phoneNumber as t inner join phoneNumber_user ut on t.phoneNumber_id = ut.phoneNumber_id where ut.user_id=?1 and t.created_date between ?2 and ?3")
    List<PhoneNumber> getPhoneNumberListFromUserIdByCreatedDateBetween(Long UserId, LocalDateTime createdDateMin, LocalDateTime createdDateMax);

    @Query(nativeQuery = true, value =
            "SELECT * FROM phoneNumber as t inner join phoneNumber_topic as tn on t.phoneNumber_id = tn.phoneNumber_id inner join phoneNumber_user tu on t.phoneNumber_id = tu.phoneNumber_id where tu.user_id=?1 and tn.topic_id=?2")
    List<PhoneNumber> getPhoneNumberListFromUserIdByTopicId(Long userId, Long topicId);

    @Query(nativeQuery = true, value =
            "SELECT * FROM phoneNumber as t inner join phoneNumber_tasks as tn on t.phoneNumber_id = tn.phoneNumber_id inner join phoneNumber_user tu on t.phoneNumber_id = tu.phoneNumber_id where tu.user_id=?1 and tn.tasks_id=?2")
    List<PhoneNumber> getPhoneNumberListFromUserIdByTasksId(Long userId, Long tasksId);

    @Query(nativeQuery = true, value =
            "SELECT * FROM phoneNumber as t inner join (SELECT ti.phoneNumber_id FROM (SELECT t.phoneNumber_id FROM phoneNumber as t inner join phoneNumber_user tu on t.phoneNumber_id = tu.phoneNumber_id where tu.user_id=?1) as ti inner join phoneNumber_user tu on ti.phoneNumber_id = tu.phoneNumber_id where tu.user_id=?2)as tr on tr.phoneNumber_id=t.phoneNumber_id")
    List<PhoneNumber> getPhoneNumberListFromUserIdByUserId(Long logInUserId, Long userId);

    @Query(nativeQuery = true, value =
            "SELECT * FROM phoneNumber as t inner join phoneNumber_tag as tt on t.phoneNumber_id = tt.phoneNumber_id inner join phoneNumber_user tu on t.phoneNumber_id = tu.phoneNumber_id where tu.user_id=?1 and tt.tag_id=?2")
    List<PhoneNumber> getPhoneNumberListFromUserIdByTagId(Long userId, Long tagId);

    @Query(nativeQuery = true, value =
            "SELECT * FROM phoneNumber as t inner join phoneNumber_reminder as tr on t.phoneNumber_id = tr.phoneNumber_id inner join phoneNumber_user tu on t.phoneNumber_id = tu.phoneNumber_id where tu.user_id=?1 and tr.reminder_id=?2")
    List<PhoneNumber> getPhoneNumberListFromUserIdByReminderId(Long userId, Long reminderId);

}
