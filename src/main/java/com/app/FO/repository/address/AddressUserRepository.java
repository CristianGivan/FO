package com.app.FO.repository.address;

import com.app.FO.model.address.AddressUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressUserRepository extends JpaRepository<AddressUser, Long> {

    @Query(nativeQuery = true, value =
            "SELECT * FROM address_user as tu where tu.address_id=?1 and tu.user_id=?2")
    AddressUser getAddressUserByAddressIdAndUserId(Long addressId, Long userId);


}
