package com.app.FO.repository.shop;

import com.app.FO.model.shop.ShopUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ShopUserRepository extends JpaRepository<ShopUser, Long> {

    @Query(nativeQuery = true, value =
            "SELECT * FROM shop_user as tu where tu.shop_id=?1 and tu.user_id=?2")
    ShopUser getShopUserByShopIdAndUserId(Long shopId, Long userId);


}
