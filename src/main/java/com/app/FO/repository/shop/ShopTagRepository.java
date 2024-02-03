package com.app.FO.repository.shop;

import com.app.FO.model.shop.ShopTag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ShopTagRepository extends JpaRepository<ShopTag, Long> {

    @Query(nativeQuery = true, value =
            "SELECT * FROM shop_tag as tt where tt.shop_id=?1 and tt.tag_id=?2")
    ShopTag getShopTagByShopIdAndTagId(Long shopId, Long tagId);


}
