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
            "SELECT * FROM phone_number as t inner join phone_number_user tu on t.phone_number_id = tu.phone_number_id where tu.user_id=?1")
    List<PhoneNumber> getPhoneNumberListFromUserId(Long userId);

    @Query(nativeQuery = true, value =
            "SELECT * FROM phone_number as t inner join phone_number_user tu on t.phone_number_id = tu.phone_number_id where tu.user_id=?1 and tu.phone_number_id=?2")
    PhoneNumber getPhoneNumberFromUserIdByPhoneNumberId(Long userId, Long phone_numberId);

    @Query(nativeQuery = true, value =
            "SELECT * FROM phone_number as t inner join phone_number_user tu on t.phone_number_id = tu.phone_number_id where tu.user_id=?1 and t.subject=?2")
    PhoneNumber getPhoneNumberFromUserIdBySubject(Long userId, String subject);

    @Query(nativeQuery = true, value =
            "SELECT * FROM phone_number as t inner join phone_number_user ut on t.phone_number_id = ut.phone_number_id where ut.user_id=:userId and t.subject like %:containingText%")
    List<PhoneNumber> getPhoneNumberListBySubjectContains(@Param("userId") Long UserId, @Param("containingText") String tagText);


    @Query(nativeQuery = true, value =
            "SELECT * FROM phone_number as t inner join phone_number_user tu on t.phone_number_id = tu.phone_number_id where tu.user_id=?1 and t.number=?2")
    PhoneNumber getPhoneNumberFromUserIdByNumber(Long userId, String number);

    @Query(nativeQuery = true, value =
            "SELECT * FROM phone_number as t inner join phone_number_user ut on t.phone_number_id = ut.phone_number_id where ut.user_id=:userId and t.number like %:containingText%")
    List<PhoneNumber> getPhoneNumberListByNumberContains(@Param("userId") Long UserId, @Param("containingText") String tagText);

    @Query(nativeQuery = true, value =
            "SELECT * FROM phone_number as t inner join phone_number_user tu on t.phone_number_id = tu.phone_number_id where tu.user_id=?1 and t.created_date=?2")
    PhoneNumber getPhoneNumberFromUserIdByCreatedDate(Long userId, LocalDateTime createdDate);

    @Query(nativeQuery = true, value =
            "SELECT * FROM phone_number as t inner join phone_number_user ut on t.phone_number_id = ut.phone_number_id where ut.user_id=?1 and t.created_date between ?2 and ?3")
    List<PhoneNumber> getPhoneNumberListFromUserIdByCreatedDateBetween(Long UserId, LocalDateTime createdDateMin, LocalDateTime createdDateMax);

    @Query(nativeQuery = true, value =
            "SELECT * FROM phone_number as t inner join phone_number_topic as tn on t.phone_number_id = tn.phone_number_id inner join phone_number_user tu on t.phone_number_id = tu.phone_number_id where tu.user_id=?1 and tn.topic_id=?2")
    List<PhoneNumber> getPhoneNumberListFromUserIdByTopicId(Long userId, Long topicId);

    @Query(nativeQuery = true, value =
            "SELECT * FROM phone_number as t inner join phone_number_tasks as tn on t.phone_number_id = tn.phone_number_id inner join phone_number_user tu on t.phone_number_id = tu.phone_number_id where tu.user_id=?1 and tn.tasks_id=?2")
    List<PhoneNumber> getPhoneNumberListFromUserIdByTasksId(Long userId, Long tasksId);

    @Query(nativeQuery = true, value =
            "SELECT * FROM phone_number as t inner join (SELECT ti.phone_number_id FROM (SELECT t.phone_number_id FROM phone_number as t inner join phone_number_user tu on t.phone_number_id = tu.phone_number_id where tu.user_id=?1) as ti inner join phone_number_user tu on ti.phone_number_id = tu.phone_number_id where tu.user_id=?2)as tr on tr.phone_number_id=t.phone_number_id")
    List<PhoneNumber> getPhoneNumberListFromUserIdByUserId(Long logInUserId, Long userId);

    @Query(nativeQuery = true, value =
            "SELECT * FROM phone_number as t inner join phone_number_tag as tt on t.phone_number_id = tt.phone_number_id inner join phone_number_user tu on t.phone_number_id = tu.phone_number_id where tu.user_id=?1 and tt.tag_id=?2")
    List<PhoneNumber> getPhoneNumberListFromUserIdByTagId(Long userId, Long tagId);

    @Query(nativeQuery = true, value =
            "SELECT * FROM phone_number as t inner join phone_number_reminder as tr on t.phone_number_id = tr.phone_number_id inner join phone_number_user tu on t.phone_number_id = tu.phone_number_id where tu.user_id=?1 and tr.reminder_id=?2")
    List<PhoneNumber> getPhoneNumberListFromUserIdByReminderId(Long userId, Long reminderId);

}
