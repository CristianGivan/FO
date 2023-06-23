package com.app.FO.repository.product;

import com.app.FO.model.product.ProductTopic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductTopicRepository extends JpaRepository<ProductTopic, Long> {

    @Query(nativeQuery = true, value =
            "SELECT * FROM product_topic as tt where tt.product_id=?1 and tt.topic_id=?2")
    ProductTopic getProductTopicByProductIdAndTopicId(Long productId, Long topicId);


}
