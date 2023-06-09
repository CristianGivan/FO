package com.app.FO.repository.shop;

import com.app.FO.model.shop.Shop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface ShopRepository extends JpaRepository<Shop, Long> {


    @Query(nativeQuery = true, value =
            "SELECT * FROM shop as t inner join shop_user tu on t.shop_id = tu.shop_id where tu.user_id=?1")
    List<Shop> getShopListFromUserId(Long userId);

    @Query(nativeQuery = true, value =
            "SELECT * FROM shop as t inner join shop_user tu on t.shop_id = tu.shop_id where tu.user_id=?1 and tu.shop_id=?2")
    Shop getShopFromUserIdByShopId(Long userId, Long shopId);

    @Query(nativeQuery = true, value =
            "SELECT * FROM shop as t inner join shop_user tu on t.shop_id = tu.shop_id where tu.user_id=?1 and t.subject=?2")
    Shop getShopFromUserIdBySubject(Long userId, String subject);

    @Query(nativeQuery = true, value =
            "SELECT * FROM shop as t inner join shop_user ut on t.shop_id = ut.shop_id where ut.user_id=:userId and t.subject like %:containingText%")
    List<Shop> getShopListBySubjectContains(@Param("userId") Long UserId, @Param("containingText") String tagText);


    @Query(nativeQuery = true, value =
            "SELECT * FROM shop as t inner join shop_user tu on t.shop_id = tu.shop_id where tu.user_id=?1 and t.name=?2")
    Shop getShopFromUserIdByName(Long userId, String name);

    @Query(nativeQuery = true, value =
            "SELECT * FROM shop as t inner join shop_user ut on t.shop_id = ut.shop_id where ut.user_id=:userId and t.name like %:containingText%")
    List<Shop> getShopListByNameContains(@Param("userId") Long UserId, @Param("containingText") String tagText);

    @Query(nativeQuery = true, value =
            "SELECT * FROM shop as t inner join shop_user tu on t.shop_id = tu.shop_id where tu.user_id=?1 and t.created_date=?2")
    Shop getShopFromUserIdByCreatedDate(Long userId, LocalDateTime createdDate);

    @Query(nativeQuery = true, value =
            "SELECT * FROM shop as t inner join shop_user ut on t.shop_id = ut.shop_id where ut.user_id=?1 and t.created_date between ?2 and ?3")
    List<Shop> getShopListFromUserIdByCreatedDateBetween(Long UserId, LocalDateTime createdDateMin, LocalDateTime createdDateMax);

    @Query(nativeQuery = true, value =
            "SELECT * FROM shop as t inner join shop_topic as tn on t.shop_id = tn.shop_id inner join shop_user tu on t.shop_id = tu.shop_id where tu.user_id=?1 and tn.topic_id=?2")
    List<Shop> getShopListFromUserIdByTopicId(Long userId, Long topicId);

    @Query(nativeQuery = true, value =
            "SELECT * FROM shop as t inner join shop_tasks as tn on t.shop_id = tn.shop_id inner join shop_user tu on t.shop_id = tu.shop_id where tu.user_id=?1 and tn.tasks_id=?2")
    List<Shop> getShopListFromUserIdByTasksId(Long userId, Long tasksId);

    @Query(nativeQuery = true, value =
            "SELECT * FROM shop as t inner join (SELECT ti.shop_id FROM (SELECT t.shop_id FROM shop as t inner join shop_user tu on t.shop_id = tu.shop_id where tu.user_id=?1) as ti inner join shop_user tu on ti.shop_id = tu.shop_id where tu.user_id=?2)as tr on tr.shop_id=t.shop_id")
    List<Shop> getShopListFromUserIdByUserId(Long logInUserId, Long userId);

    @Query(nativeQuery = true, value =
            "SELECT * FROM shop as t inner join shop_tag as tt on t.shop_id = tt.shop_id inner join shop_user tu on t.shop_id = tu.shop_id where tu.user_id=?1 and tt.tag_id=?2")
    List<Shop> getShopListFromUserIdByTagId(Long userId, Long tagId);

    @Query(nativeQuery = true, value =
            "SELECT * FROM shop as t inner join shop_reminder as tr on t.shop_id = tr.shop_id inner join shop_user tu on t.shop_id = tu.shop_id where tu.user_id=?1 and tr.reminder_id=?2")
    List<Shop> getShopListFromUserIdByReminderId(Long userId, Long reminderId);

}
