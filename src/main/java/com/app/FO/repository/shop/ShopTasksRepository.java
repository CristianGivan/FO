package com.app.FO.repository.shop;

import com.app.FO.model.shop.ShopTasks;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface ShopTasksRepository extends JpaRepository<ShopTasks, Long> {

    @Query(nativeQuery = true, value =
            "SELECT * FROM shop_tasks as tt where tt.shop_id=?1 and tt.tasks_id=?2")
    ShopTasks getShopTasksByShopIdAndTasksId(Long shopId, Long topicId);


}
