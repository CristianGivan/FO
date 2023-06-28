package com.app.FO.repository.tryLearn;


import com.app.FO.model.tryLearn.Prs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PrsRepository extends JpaRepository<Prs, Long> {

//
//    @Query(nativeQuery = true, value =
//            "SELECT * FROM prs as t inner join prs_user tu on t.prs_id = tu.prs_id where tu.user_id=?1")
//    List<Prs> getPrsListFromUserId(Long userId);
//
//    @Query(nativeQuery = true, value =
//            "SELECT * FROM prs as t inner join prs_user tu on t.prs_id = tu.prs_id where tu.user_id=?1 and tu.prs_id=?2")
//    Prs getPrsFromUserIdByPrsId(Long userId, Long prsId);
//
//    @Query(nativeQuery = true, value =
//            "SELECT * FROM prs as t inner join prs_user tu on t.prs_id = tu.prs_id where tu.user_id=?1 and t.nick_name=?2")
//    List<Prs> getPrsFromUserIdByNickName(Long userId, String nickName);
//
//    @Query(nativeQuery = true, value =
//            "SELECT * FROM prs as t inner join prs_user ut on t.prs_id = ut.prs_id where ut.user_id=:userId and t.nick_name like %:containingText%")
//    List<Prs> getPrsListByNickNameContains(@Param("userId") Long UserId, @Param("containingText") String containsText);
//
//    @Query(nativeQuery = true, value =
//            "SELECT * FROM prs as t inner join prs_user tu on t.prs_id = tu.prs_id where tu.user_id=?1 and t.first_name=?2")
//    List<Prs> getPrsFromUserIdByFirstName(Long userId, String firstName);
//
//    @Query(nativeQuery = true, value =
//            "SELECT * FROM prs as t inner join prs_user ut on t.prs_id = ut.prs_id where ut.user_id=:userId and t.first_name like %:containingText%")
//    List<Prs> getPrsListByFirstNameContains(@Param("userId") Long UserId, @Param("containingText") String containsText);
//
//    @Query(nativeQuery = true, value =
//            "SELECT * FROM prs as t inner join prs_user tu on t.prs_id = tu.prs_id where tu.user_id=?1 and t.middle_name=?2")
//    List<Prs> getPrsFromUserIdByMiddleName(Long userId, String middleName);
//
//    @Query(nativeQuery = true, value =
//            "SELECT * FROM prs as t inner join prs_user ut on t.prs_id = ut.prs_id where ut.user_id=:userId and t.middle_name like %:containingText%")
//    List<Prs> getPrsListByMiddleNameContains(@Param("userId") Long UserId, @Param("containingText") String containsText);
//
//    @Query(nativeQuery = true, value =
//            "SELECT * FROM prs as t inner join prs_user tu on t.prs_id = tu.prs_id where tu.user_id=?1 and t.last_name=?2")
//    List<Prs> getPrsFromUserIdByLastName(Long userId, String lastName);
//
//    @Query(nativeQuery = true, value =
//            "SELECT * FROM prs as t inner join prs_user ut on t.prs_id = ut.prs_id where ut.user_id=:userId and t.last_name like %:containingText%")
//    List<Prs> getPrsListByLastNameContains(@Param("userId") Long UserId, @Param("containingText") String containsText);
//
//    @Query(nativeQuery = true, value =
//            "SELECT * FROM prs as t inner join prs_user tu on t.prs_id = tu.prs_id where tu.user_id=?1 and t.full_name=?2")
//    List<Prs> getPrsFromUserIdByFullName(Long userId, String fullName);
//
//    @Query(nativeQuery = true, value =
//            "SELECT * FROM prs as t inner join prs_user ut on t.prs_id = ut.prs_id where ut.user_id=:userId and t.full_name like %:containingText%")
//    List<Prs> getPrsListByFullNameContains(@Param("userId") Long UserId, @Param("containingText") String containsText);
//
//    @Query(nativeQuery = true, value =
//            "SELECT * FROM prs as t inner join prs_user tu on t.prs_id = tu.prs_id where tu.user_id=?1 and t.description=?2")
//    List<Prs> getPrsFromUserIdByDescription(Long userId, String description);
//
//    @Query(nativeQuery = true, value =
//            "SELECT * FROM prs as t inner join prs_user ut on t.prs_id = ut.prs_id where ut.user_id=:userId and t.description like %:containingText%")
//    List<Prs> getPrsListByDescriptionContains(@Param("userId") Long UserId, @Param("containingText") String containsText);
//
//    @Query(nativeQuery = true, value =
//            "SELECT * FROM prs as t inner join prs_user tu on t.prs_id = tu.prs_id where tu.user_id=?1 and t.subject=?2")
//    Prs getPrsFromUserIdBySubject(Long userId, String subject);
//
//    @Query(nativeQuery = true, value =
//            "SELECT * FROM prs as t inner join prs_user ut on t.prs_id = ut.prs_id where ut.user_id=:userId and t.subject like %:containingText%")
//    List<Prs> getPrsListBySubjectContains(@Param("userId") Long UserId, @Param("containingText") String containsText);
//
//    @Query(nativeQuery = true, value =
//            "SELECT * FROM prs as t inner join prs_user tu on t.prs_id = tu.prs_id where tu.user_id=?1 and t.created_date=?2")
//    Prs getPrsFromUserIdByCreatedDate(Long userId, LocalDateTime createdDate);
//
//    @Query(nativeQuery = true, value =
//            "SELECT * FROM prs as t inner join prs_user ut on t.prs_id = ut.prs_id where ut.user_id=?1 and t.created_date between ?2 and ?3")
//    List<Prs> getPrsListFromUserIdByCreatedDateBetween(Long UserId, LocalDateTime createdDateMin, LocalDateTime createdDateMax);
//
//
//    @Query(nativeQuery = true, value =
//            "SELECT * FROM prs as t inner join (SELECT ti.prs_id FROM (SELECT t.prs_id FROM prs as t inner join prs_user tu on t.prs_id = tu.prs_id where tu.user_id=?1) as ti inner join prs_user tu on ti.prs_id = tu.prs_id where tu.user_id=?2)as tr on tr.prs_id=t.prs_id")
//    List<Prs> getPrsListFromUserIdByUserId(Long logInUserId, Long userId);
//
//    @Query(nativeQuery = true, value =
//            "SELECT * FROM prs as t inner join prs_tag as tt on t.prs_id = tt.prs_id inner join prs_user tu on t.prs_id = tu.prs_id where tu.user_id=?1 and tt.tag_id=?2")
//    List<Prs> getPrsListFromUserIdByTagId(Long userId, Long tagId);
//
//    @Query(nativeQuery = true, value =
//            "SELECT * FROM prs as t inner join prs_reminder as tr on t.prs_id = tr.prs_id inner join prs_user tu on t.prs_id = tu.prs_id where tu.user_id=?1 and tr.reminder_id=?2")
//    List<Prs> getPrsListFromUserIdByReminderId(Long userId, Long reminderId);
//
//    @Query(nativeQuery = true, value =
//            "SELECT * FROM prs as t inner join prs_topic as tn on t.prs_id = tn.prs_id inner join prs_user tu on t.prs_id = tu.prs_id where tu.user_id=?1 and tn.topic_id=?2")
//    List<Prs> getPrsListFromUserIdByTopicId(Long userId, Long topicId);
//
//    @Query(nativeQuery = true, value =
//            "SELECT * FROM prs as t inner join prs_tasks as tn on t.prs_id = tn.prs_id inner join prs_user tu on t.prs_id = tu.prs_id where tu.user_id=?1 and tn.tasks_id=?2")
//    List<Prs> getPrsListFromUserIdByTasksId(Long userId, Long tasksId);
//
//
//    @Query(nativeQuery = true, value =
//            "SELECT * FROM prs as t inner join prs_document as tn on t.prs_id = tn.prs_id inner join prs_user tu on t.prs_id = tu.prs_id where tu.user_id=?1 and tn.document_id=?2")
//    List<Prs> getPrsListFromUserIdByDocumentId(Long userId, Long documentId);
//
//    @Query(nativeQuery = true, value =
//            "SELECT * FROM prs as t inner join prs_address as tn on t.prs_id = tn.prs_id inner join prs_user tu on t.prs_id = tu.prs_id where tu.user_id=?1 and tn.address_id=?2")
//    List<Prs> getPrsListFromUserIdByAddressId(Long userId, Long addressId);
//
//    @Query(nativeQuery = true, value =
//            "SELECT * FROM prs as t inner join prs_email as tn on t.prs_id = tn.prs_id inner join prs_user tu on t.prs_id = tu.prs_id where tu.user_id=?1 and tn.email_id=?2")
//    List<Prs> getPrsListFromUserIdByEmailId(Long userId, Long emailId);
//
//    @Query(nativeQuery = true, value =
//            "SELECT * FROM prs as t inner join prs_phone_number as tn on t.prs_id = tn.prs_id inner join prs_user tu on t.prs_id = tu.prs_id where tu.user_id=?1 and tn.phone_number_id=?2")
//    List<Prs> getPrsListFromUserIdByPhoneNumberId(Long userId, Long phoneNumberId);
//
//    @Query(nativeQuery = true, value =
//            "SELECT * FROM prs as t inner join prs_dates as tn on t.prs_id = tn.prs_id inner join prs_user tu on t.prs_id = tu.prs_id where tu.user_id=?1 and tn.dates_id=?2")
//    List<Prs> getPrsListFromUserIdByDatesId(Long userId, Long datesId);
//
//    @Query(nativeQuery = true, value =
//            "SELECT * FROM prs as t inner join expenses_prs as tn on t.prs_id = tn.prs_id inner join prs_user tu on t.prs_id = tu.prs_id where tu.user_id=?1 and tn.expenses_id=?2")
//    List<Prs> getPrsListFromUserIdByExpensesId(Long userId, Long expensesId);

    @Query(nativeQuery = true, value =
            "SELECT * FROM prs as p  where p.prs_id=?1")
    Prs getPrsByPrsId(Long prsId);

    @Query(nativeQuery = true, value =
            "SELECT * FROM prs as t inner join prs_prs as tn on t.prs_id = tn.prs_id where tn.related_prs_id=?1")
    List<Prs> getPrsListByPrsId(Long prsId);

}
