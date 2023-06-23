package com.app.FO.repository.product;

import com.app.FO.model.product.ProductTasks;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface ProductTasksRepository extends JpaRepository<ProductTasks, Long> {

    @Query(nativeQuery = true, value =
            "SELECT * FROM product_tasks as tt where tt.product_id=?1 and tt.tasks_id=?2")
    ProductTasks getProductTasksByProductIdAndTasksId(Long productId, Long topicId);


}
