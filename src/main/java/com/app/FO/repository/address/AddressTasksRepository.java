package com.app.FO.repository.address;

import com.app.FO.model.address.AddressTasks;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface AddressTasksRepository extends JpaRepository<AddressTasks, Long> {

    @Query(nativeQuery = true, value =
            "SELECT * FROM address_tasks as tt where tt.address_id=?1 and tt.tasks_id=?2")
    AddressTasks getAddressTasksByAddressIdAndTasksId(Long addressId, Long topicId);


}
