package com.app.FO.repository.person;

import com.app.FO.model.person.PersonAddress;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonAddressRepository extends JpaRepository<PersonAddress, Long> {

    @Query(nativeQuery = true, value =
            "SELECT * FROM person_address as tt where tt.person_id=?1 and tt.address_id=?2")
    PersonAddress getPersonAddressByPersonIdAndAddressId(Long personId, Long addressId);


}
