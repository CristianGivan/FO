package com.app.FO.repository.expenses;

import com.app.FO.model.expenses.ExpensesShop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ExpensesShopRepository extends JpaRepository<ExpensesShop, Long> {

    @Query(nativeQuery = true, value =
            "SELECT * FROM expenses_shop as tt where tt.expenses_id=?1 and tt.shop_id=?2")
    ExpensesShop getExpensesShopByExpensesIdAndShopId(Long expensesId, Long shopId);


}
