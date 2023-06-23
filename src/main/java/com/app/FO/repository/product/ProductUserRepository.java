package com.app.FO.repository.product;

import com.app.FO.model.product.ProductUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductUserRepository extends JpaRepository<ProductUser, Long> {

    @Query(nativeQuery = true, value =
            "SELECT * FROM product_user as tu where tu.product_id=?1 and tu.user_id=?2")
    ProductUser getProductUserByProductIdAndUserId(Long productId, Long userId);


}
