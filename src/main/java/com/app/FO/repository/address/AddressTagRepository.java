package com.app.FO.repository.address;

import com.app.FO.model.address.AddressTag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressTagRepository extends JpaRepository<AddressTag, Long> {

    @Query(nativeQuery = true, value =
            "SELECT * FROM address_tag as tt where tt.address_id=?1 and tt.tag_id=?2")
    AddressTag getAddressTagByAddressIdAndTagId(Long addressId, Long tagId);


}
