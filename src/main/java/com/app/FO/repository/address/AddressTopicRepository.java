package com.app.FO.repository.address;

import com.app.FO.model.address.AddressTopic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressTopicRepository extends JpaRepository<AddressTopic, Long> {

    @Query(nativeQuery = true, value =
            "SELECT * FROM address_topic as tt where tt.address_id=?1 and tt.topic_id=?2")
    AddressTopic getAddressTopicByAddressIdAndTopicId(Long addressId, Long topicId);


}
