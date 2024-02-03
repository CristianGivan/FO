package com.app.FO.repository.snooze;

import com.app.FO.model.snooze.Snooze;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

@Repository
public interface SnoozeRepository extends JpaRepository<Snooze, Long> {


    @Query(nativeQuery = true, value =
            "SELECT * FROM snooze as t inner join snooze_user tu on t.snooze_id = tu.snooze_id where tu.user_id=?1")
    List<Snooze> getSnoozeListFromUserId(Long userId);

    @Query(nativeQuery = true, value =
            "SELECT * FROM snooze as t inner join snooze_user tu on t.snooze_id = tu.snooze_id where tu.user_id=?1 and tu.snooze_id=?2")
    Snooze getSnoozeFromUserIdBySnoozeId(Long userId, Long snoozeId);

    @Query(nativeQuery = true, value =
            "SELECT * FROM snooze as t inner join snooze_user tu on t.snooze_id = tu.snooze_id where tu.user_id=?1 and t.subject=?2")
    Snooze getSnoozeFromUserIdBySubject(Long userId, String subject);

    @Query(nativeQuery = true, value =
            "SELECT * FROM snooze as t inner join snooze_user ut on t.snooze_id = ut.snooze_id where ut.user_id=:userId and t.subject like %:containingText%")
    List<Snooze> getSnoozeListBySubjectContains(@Param("userId") Long UserId, @Param("containingText") String tagText);

    @Query(nativeQuery = true, value =
            "SELECT * FROM snooze as t inner join snooze_user tu on t.snooze_id = tu.snooze_id where tu.user_id=?1 and t.snooze_time=?2")
    Snooze getSnoozeFromUserIdBySnoozeTime(Long userId, LocalTime snoozeTime);

    @Query(nativeQuery = true, value =
            "SELECT * FROM snooze as t inner join snooze_user ut on t.snooze_id = ut.snooze_id where ut.user_id=?1 and t.snooze_time between ?2 and ?3")
    List<Snooze> getSnoozeListFromUserIdBySnoozeTimeBetween(Long UserId, LocalTime snoozeTimeMin, LocalTime snoozeTimeMax);

    @Query(nativeQuery = true, value =
            "SELECT * FROM snooze as t inner join snooze_user tu on t.snooze_id = tu.snooze_id where tu.user_id=?1 and t.created_date=?2")
    Snooze getSnoozeFromUserIdByCreatedDate(Long userId, LocalDateTime createdDate);

    @Query(nativeQuery = true, value =
            "SELECT * FROM snooze as t inner join snooze_user ut on t.snooze_id = ut.snooze_id where ut.user_id=?1 and t.created_date between ?2 and ?3")
    List<Snooze> getSnoozeListFromUserIdByCreatedDateBetween(Long UserId, LocalDateTime createdDateMin, LocalDateTime createdDateMax);

    @Query(nativeQuery = true, value =
            "SELECT * FROM snooze as t inner join (SELECT ti.snooze_id FROM (SELECT t.snooze_id FROM snooze as t inner join snooze_user tu on t.snooze_id = tu.snooze_id where tu.user_id=?1) as ti inner join snooze_user tu on ti.snooze_id = tu.snooze_id where tu.user_id=?2)as tr on tr.snooze_id=t.snooze_id")
    List<Snooze> getSnoozeListFromUserIdByUserId(Long logInUser, Long userId);


}
