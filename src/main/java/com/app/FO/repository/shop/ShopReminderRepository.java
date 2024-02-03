package com.app.FO.repository.shop;

import com.app.FO.model.shop.ShopReminder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ShopReminderRepository extends JpaRepository<ShopReminder, Long> {

    @Query(nativeQuery = true, value =
            "SELECT * FROM shop_reminder as tr where tr.shop_id=?1 and tr.reminder_id=?2")
    ShopReminder getShopReminderByShopIdAndReminderId(Long shopId, Long reminderId);


}
