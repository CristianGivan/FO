package com.app.FO.repository.product;

import com.app.FO.model.product.ProductReminder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductReminderRepository extends JpaRepository<ProductReminder, Long> {

    @Query(nativeQuery = true, value =
            "SELECT * FROM product_reminder as tr where tr.product_id=?1 and tr.reminder_id=?2")
    ProductReminder getProductReminderByProductIdAndReminderId(Long productId, Long reminderId);


}
