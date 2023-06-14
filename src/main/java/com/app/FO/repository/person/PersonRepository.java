package com.app.FO.repository.person;

import com.app.FO.model.person.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {


    @Query(nativeQuery = true, value =
            "SELECT * FROM person as t inner join person_user tu on t.person_id = tu.person_id where tu.user_id=?1")
    List<Person> getPersonListFromUserId(Long userId);

    @Query(nativeQuery = true, value =
            "SELECT * FROM person as t inner join person_user tu on t.person_id = tu.person_id where tu.user_id=?1 and tu.person_id=?2")
    Person getPersonFromUserIdByPersonId(Long userId, Long personId);

    @Query(nativeQuery = true, value =
            "SELECT * FROM person as t inner join person_user tu on t.person_id = tu.person_id where tu.user_id=?1 and t.nick_name=?2")
    List<Person> getPersonFromUserIdByNickName(Long userId, String nickName);

    @Query(nativeQuery = true, value =
            "SELECT * FROM person as t inner join person_user ut on t.person_id = ut.person_id where ut.user_id=:userId and t.nick_name like %:containingText%")
    List<Person> getPersonListByNickNameContains(@Param("userId") Long UserId, @Param("containingText") String containsText);

    @Query(nativeQuery = true, value =
            "SELECT * FROM person as t inner join person_user tu on t.person_id = tu.person_id where tu.user_id=?1 and t.first_name=?2")
    List<Person> getPersonFromUserIdByFirstName(Long userId, String firstName);

    @Query(nativeQuery = true, value =
            "SELECT * FROM person as t inner join person_user ut on t.person_id = ut.person_id where ut.user_id=:userId and t.first_name like %:containingText%")
    List<Person> getPersonListByFirstNameContains(@Param("userId") Long UserId, @Param("containingText") String containsText);

    @Query(nativeQuery = true, value =
            "SELECT * FROM person as t inner join person_user tu on t.person_id = tu.person_id where tu.user_id=?1 and t.middle_name=?2")
    List<Person> getPersonFromUserIdByMiddleName(Long userId, String middleName);

    @Query(nativeQuery = true, value =
            "SELECT * FROM person as t inner join person_user ut on t.person_id = ut.person_id where ut.user_id=:userId and t.middle_name like %:containingText%")
    List<Person> getPersonListByMiddleNameContains(@Param("userId") Long UserId, @Param("containingText") String containsText);

    @Query(nativeQuery = true, value =
            "SELECT * FROM person as t inner join person_user tu on t.person_id = tu.person_id where tu.user_id=?1 and t.last_name=?2")
    List<Person> getPersonFromUserIdByLastName(Long userId, String lastName);

    @Query(nativeQuery = true, value =
            "SELECT * FROM person as t inner join person_user ut on t.person_id = ut.person_id where ut.user_id=:userId and t.last_name like %:containingText%")
    List<Person> getPersonListByLastNameContains(@Param("userId") Long UserId, @Param("containingText") String containsText);

    @Query(nativeQuery = true, value =
            "SELECT * FROM person as t inner join person_user tu on t.person_id = tu.person_id where tu.user_id=?1 and t.full_name=?2")
    List<Person> getPersonFromUserIdByFullName(Long userId, String fullName);

    @Query(nativeQuery = true, value =
            "SELECT * FROM person as t inner join person_user ut on t.person_id = ut.person_id where ut.user_id=:userId and t.full_name like %:containingText%")
    List<Person> getPersonListByFullNameContains(@Param("userId") Long UserId, @Param("containingText") String containsText);

    @Query(nativeQuery = true, value =
            "SELECT * FROM person as t inner join person_user tu on t.person_id = tu.person_id where tu.user_id=?1 and t.description=?2")
    List<Person> getPersonFromUserIdByDescription(Long userId, String description);

    @Query(nativeQuery = true, value =
            "SELECT * FROM person as t inner join person_user ut on t.person_id = ut.person_id where ut.user_id=:userId and t.description like %:containingText%")
    List<Person> getPersonListByDescriptionContains(@Param("userId") Long UserId, @Param("containingText") String containsText);

    @Query(nativeQuery = true, value =
            "SELECT * FROM person as t inner join person_user tu on t.person_id = tu.person_id where tu.user_id=?1 and t.subject=?2")
    Person getPersonFromUserIdBySubject(Long userId, String subject);

    @Query(nativeQuery = true, value =
            "SELECT * FROM person as t inner join person_user ut on t.person_id = ut.person_id where ut.user_id=:userId and t.subject like %:containingText%")
    List<Person> getPersonListBySubjectContains(@Param("userId") Long UserId, @Param("containingText") String containsText);


    @Query(nativeQuery = true, value =
            "SELECT * FROM person as t inner join (SELECT ti.person_id FROM (SELECT t.person_id FROM person as t inner join person_user tu on t.person_id = tu.person_id where tu.user_id=?1) as ti inner join person_user tu on ti.person_id = tu.person_id where tu.user_id=?2)as tr on tr.person_id=t.person_id")
    List<Person> getPersonListFromUserIdByUserId(Long logInUserId, Long userId);

    @Query(nativeQuery = true, value =
            "SELECT * FROM person as t inner join person_tag as tt on t.person_id = tt.person_id inner join person_user tu on t.person_id = tu.person_id where tu.user_id=?1 and tt.tag_id=?2")
    List<Person> getPersonListFromUserIdByTagId(Long userId, Long tagId);

    @Query(nativeQuery = true, value =
            "SELECT * FROM person as t inner join person_reminder as tr on t.person_id = tr.person_id inner join person_user tu on t.person_id = tu.person_id where tu.user_id=?1 and tr.reminder_id=?2")
    List<Person> getPersonListFromUserIdByReminderId(Long userId, Long reminderId);

    @Query(nativeQuery = true, value =
            "SELECT * FROM person as t inner join person_topic as tn on t.person_id = tn.person_id inner join person_user tu on t.person_id = tu.person_id where tu.user_id=?1 and tn.topic_id=?2")
    List<Person> getPersonListFromUserIdByTopicId(Long userId, Long topicId);

    @Query(nativeQuery = true, value =
            "SELECT * FROM person as t inner join person_tasks as tn on t.person_id = tn.person_id inner join person_user tu on t.person_id = tu.person_id where tu.user_id=?1 and tn.tasks_id=?2")
    List<Person> getPersonListFromUserIdByTasksId(Long userId, Long tasksId);


    @Query(nativeQuery = true, value =
            "SELECT * FROM person as t inner join person_document as tn on t.person_id = tn.person_id inner join person_user tu on t.person_id = tu.person_id where tu.user_id=?1 and tn.document_id=?2")
    List<Person> getPersonListFromUserIdByDocumentId(Long userId, Long documentId);

    @Query(nativeQuery = true, value =
            "SELECT * FROM person as t inner join person_address as tn on t.person_id = tn.person_id inner join person_user tu on t.person_id = tu.person_id where tu.user_id=?1 and tn.address_id=?2")
    List<Person> getPersonListFromUserIdByAddressId(Long userId, Long addressId);

    @Query(nativeQuery = true, value =
            "SELECT * FROM person as t inner join person_email as tn on t.person_id = tn.person_id inner join person_user tu on t.person_id = tu.person_id where tu.user_id=?1 and tn.email_id=?2")
    List<Person> getPersonListFromUserIdByEmailId(Long userId, Long emailId);

    @Query(nativeQuery = true, value =
            "SELECT * FROM person as t inner join person_phone_number as tn on t.person_id = tn.person_id inner join person_user tu on t.person_id = tu.person_id where tu.user_id=?1 and tn.phone_number_id=?2")
    List<Person> getPersonListFromUserIdByPhoneNumberId(Long userId, Long phoneNumberId);

    @Query(nativeQuery = true, value =
            "SELECT * FROM person as t inner join person_dates as tn on t.person_id = tn.person_id inner join person_user tu on t.person_id = tu.person_id where tu.user_id=?1 and tn.dates_id=?2")
    List<Person> getPersonListFromUserIdByDatesId(Long userId, Long datesId);

    @Query(nativeQuery = true, value =
            "SELECT * FROM person as t inner join expenses_person as tn on t.person_id = tn.person_id inner join person_user tu on t.person_id = tu.person_id where tu.user_id=?1 and tn.expenses_id=?2")
    List<Person> getPersonListFromUserIdByExpensesId(Long userId, Long expensesId);

    @Query(nativeQuery = true, value =
            "SELECT * FROM person as t inner join person_person as tn on t.person_id = tn.person_id inner join person_user tu on t.person_id = tu.person_id where tu.user_id=?1 and tn.person_id=?2")
    List<Person> getPersonListFromUserIdByPersonId(Long userId, Long personId);

}
