package com.app.FO.repository.product;

import com.app.FO.model.product.ProductTag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductTagRepository extends JpaRepository<ProductTag, Long> {

    @Query(nativeQuery = true, value =
            "SELECT * FROM product_tag as tt where tt.product_id=?1 and tt.tag_id=?2")
    ProductTag getProductTagByProductIdAndTagId(Long productId, Long tagId);


}
