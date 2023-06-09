package com.app.FO.repository.shop;

import com.app.FO.model.shop.ShopTopic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ShopTopicRepository extends JpaRepository<ShopTopic, Long> {

    @Query(nativeQuery = true, value =
            "SELECT * FROM shop_topic as tt where tt.shop_id=?1 and tt.topic_id=?2")
    ShopTopic getShopTopicByShopIdAndTopicId(Long shopId, Long topicId);


}
