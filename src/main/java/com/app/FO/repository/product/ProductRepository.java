package com.app.FO.repository.product;

import com.app.FO.model.product.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {


    @Query(nativeQuery = true, value =
            "SELECT * FROM product as t inner join product_user tu on t.product_id = tu.product_id where tu.user_id=?1")
    List<Product> getProductListFromUserId(Long userId);

    @Query(nativeQuery = true, value =
            "SELECT * FROM product as t inner join product_user tu on t.product_id = tu.product_id where tu.user_id=?1 and tu.product_id=?2")
    Product getProductFromUserIdByProductId(Long userId, Long productId);

    @Query(nativeQuery = true, value =
            "SELECT * FROM product as t inner join product_user tu on t.product_id = tu.product_id where tu.user_id=?1 and t.name=?2")
    List<Product> getProductFromUserIdByName(Long userId, String name);

    @Query(nativeQuery = true, value =
            "SELECT * FROM product as t inner join product_user ut on t.product_id = ut.product_id where ut.user_id=:userId and t.name like %:containingText%")
    List<Product> getProductListByNameContains(@Param("userId") Long UserId, @Param("containingText") String nameText);

    @Query(nativeQuery = true, value =
            "SELECT * FROM product as t inner join product_user tu on t.product_id = tu.product_id where tu.user_id=?1 and t.unit=?2")
    List<Product> getProductFromUserIdByUnit(Long userId, String unit);

    @Query(nativeQuery = true, value =
            "SELECT * FROM product as t inner join product_user ut on t.product_id = ut.product_id where ut.user_id=:userId and t.unit like %:containingText%")
    List<Product> getProductListByUnitContains(@Param("userId") Long UserId, @Param("containingText") String unitText);

    @Query(nativeQuery = true, value =
            "SELECT * FROM product as t inner join product_user tu on t.product_id = tu.product_id where tu.user_id=?1 and t.producer=?2")
    List<Product> getProductFromUserIdByProducer(Long userId, String producer);

    @Query(nativeQuery = true, value =
            "SELECT * FROM product as t inner join product_user ut on t.product_id = ut.product_id where ut.user_id=:userId and t.producer like %:containingText%")
    List<Product> getProductListByProducerContains(@Param("userId") Long UserId, @Param("containingText") String producerText);

    @Query(nativeQuery = true, value =
            "SELECT * FROM product as t inner join product_user tu on t.product_id = tu.product_id where tu.user_id=?1 and t.subject=?2")
    Product getProductFromUserIdBySubject(Long userId, String subject);

    @Query(nativeQuery = true, value =
            "SELECT * FROM product as t inner join product_user ut on t.product_id = ut.product_id where ut.user_id=:userId and t.subject like %:containingText%")
    List<Product> getProductListBySubjectContains(@Param("userId") Long UserId, @Param("containingText") String subjectText);

    @Query(nativeQuery = true, value =
            "SELECT * FROM product as t inner join product_user tu on t.product_id = tu.product_id where tu.user_id=?1 and t.category=?2")
    Product getProductFromUserIdByCategory(Long userId, String category);

    @Query(nativeQuery = true, value =
            "SELECT * FROM product as t inner join product_user ut on t.product_id = ut.product_id where ut.user_id=:userId and t.category like %:containingText%")
    List<Product> getProductListByCategoryContains(@Param("userId") Long UserId, @Param("containingText") String categoryText);


    @Query(nativeQuery = true, value =
            "SELECT * FROM product as t inner join product_user tu on t.product_id = tu.product_id where tu.user_id=?1 and t.number_buys=?2")
    List<Product> getProductFromUserIdByNumberOfBuys(Long userId, Integer numberOfBuys);

    @Query(nativeQuery = true, value =
            "SELECT * FROM product as t inner join product_user ut on t.product_id = ut.product_id where ut.user_id=?1 and t.number_buys between ?2 and ?3")
    List<Product> getProductListFromUserIdByNumberOfBuysBetween(Long UserId, Integer numberOfBuysMin, Integer numberOfBuysMax);

    @Query(nativeQuery = true, value =
            "SELECT * FROM product as t inner join product_user tu on t.product_id = tu.product_id where tu.user_id=?1 and t.number_mean_quantity=?2")
    List<Product> getProductFromUserIdByNumberForMeanQuantity(Long userId, Integer numberForMeanQuantity);

    @Query(nativeQuery = true, value =
            "SELECT * FROM product as t inner join product_user ut on t.product_id = ut.product_id where ut.user_id=?1 and t.number_mean_quantity between ?2 and ?3")
    List<Product> getProductListFromUserIdByNumberForMeanQuantityBetween(Long UserId, Integer numberForMeanQuantityMin, Integer numberForMeanQuantityMax);


    @Query(nativeQuery = true, value =
            "SELECT * FROM product as t inner join product_user tu on t.product_id = tu.product_id where tu.user_id=?1 and t.number_mean_price=?2")
    List<Product> getProductFromUserIdByNumberForMeanPrice(Long userId, Integer numberForMeanPrice);

    @Query(nativeQuery = true, value =
            "SELECT * FROM product as t inner join product_user ut on t.product_id = ut.product_id where ut.user_id=?1 and t.number_mean_price between ?2 and ?3")
    List<Product> getProductListFromUserIdByNumberForMeanPriceBetween(Long UserId, Integer numberForMeanPriceMin, Integer numberForMeanPriceMax);


    @Query(nativeQuery = true, value =
            "SELECT * FROM product as t inner join product_user tu on t.product_id = tu.product_id where tu.user_id=?1 and t.mean_quantity=?2")
    List<Product> getProductFromUserIdByMeanQuantity(Long userId, Double meanQuantity);

    @Query(nativeQuery = true, value =
            "SELECT * FROM product as t inner join product_user ut on t.product_id = ut.product_id where ut.user_id=?1 and t.mean_quantity between ?2 and ?3")
    List<Product> getProductListFromUserIdByMeanQuantityBetween(Long UserId, Double meanQuantityMin, Double meanQuantityMax);

    @Query(nativeQuery = true, value =
            "SELECT * FROM product as t inner join product_user tu on t.product_id = tu.product_id where tu.user_id=?1 and t.mean_unit_price=?2")
    List<Product> getProductFromUserIdByMeanUnitPrice(Long userId, Double meanUnitPrice);

    @Query(nativeQuery = true, value =
            "SELECT * FROM product as t inner join product_user ut on t.product_id = ut.product_id where ut.user_id=?1 and t.mean_unit_price between ?2 and ?3")
    List<Product> getProductListFromUserIdByMeanUnitPriceBetween(Long UserId, Double meanUnitPriceMin, Double meanUnitPriceMax);

    @Query(nativeQuery = true, value =
            "SELECT * FROM product as t inner join product_user tu on t.product_id = tu.product_id where tu.user_id=?1 and t.created_date=?2")
    Product getProductFromUserIdByCreatedDate(Long userId, LocalDateTime createdDate);

    @Query(nativeQuery = true, value =
            "SELECT * FROM product as t inner join product_user ut on t.product_id = ut.product_id where ut.user_id=?1 and t.created_date between ?2 and ?3")
    List<Product> getProductListFromUserIdByCreatedDateBetween(Long UserId, LocalDateTime createdDateMin, LocalDateTime createdDateMax);

    @Query(nativeQuery = true, value =
            "SELECT * FROM product as t inner join (SELECT ti.product_id FROM (SELECT t.product_id FROM product as t inner join product_user tu on t.product_id = tu.product_id where tu.user_id=?1) as ti inner join product_user tu on ti.product_id = tu.product_id where tu.user_id=?2)as tr on tr.product_id=t.product_id")
    List<Product> getProductListFromUserIdByUserId(Long logInUserId, Long userId);

    @Query(nativeQuery = true, value =
            "SELECT * FROM product as t inner join product_tag as tt on t.product_id = tt.product_id inner join product_user tu on t.product_id = tu.product_id where tu.user_id=?1 and tt.tag_id=?2")
    List<Product> getProductListFromUserIdByTagId(Long userId, Long tagId);

    @Query(nativeQuery = true, value =
            "SELECT * FROM product as t inner join product_reminder as tr on t.product_id = tr.product_id inner join product_user tu on t.product_id = tu.product_id where tu.user_id=?1 and tr.reminder_id=?2")
    List<Product> getProductListFromUserIdByReminderId(Long userId, Long reminderId);

    @Query(nativeQuery = true, value =
            "SELECT * FROM product as t inner join product_topic as tn on t.product_id = tn.product_id inner join product_user tu on t.product_id = tu.product_id where tu.user_id=?1 and tn.topic_id=?2")
    List<Product> getProductListFromUserIdByTopicId(Long userId, Long topicId);

    @Query(nativeQuery = true, value =
            "SELECT * FROM product as t inner join product_tasks as tn on t.product_id = tn.product_id inner join product_user tu on t.product_id = tu.product_id where tu.user_id=?1 and tn.tasks_id=?2")
    List<Product> getProductListFromUserIdByTasksId(Long userId, Long tasksId);


    @Query(nativeQuery = true, value =
            "SELECT * FROM product as t inner join product_expense as tn on t.product_id = tn.product_id inner join product_user tu on t.product_id = tu.product_id where tu.user_id=?1 and tn.expense_id=?2")
    List<Product> getProductListFromUserIdByExpenseId(Long userId, Long expenseId);

}
