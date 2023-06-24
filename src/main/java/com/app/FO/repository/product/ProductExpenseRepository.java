package com.app.FO.repository.product;

import com.app.FO.model.product.ProductExpense;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface ProductExpenseRepository extends JpaRepository<ProductExpense, Long> {

    @Query(nativeQuery = true, value =
            "SELECT * FROM product_expense as tt where tt.product_id=?1 and tt.expense_id=?2")
    ProductExpense getProductExpenseByProductIdAndExpenseId(Long productId, Long topicId);


}
