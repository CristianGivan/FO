package com.app.FO.repository.remainder;

import com.app.FO.model.remainder.Remainder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RemainderRepository extends JpaRepository<Remainder, Long> {
    //-- GET
    @Query(value = "SELECT * FROM  remainder as r where r.remainder_id=?1 and r.user_id=?2"
            ,nativeQuery = true)
    Remainder getRemainderByRemainderIdFromUser(Long remainderId, Long userId);

//    List<Remainder> getAllByUserId(Long userId);
    @Query(nativeQuery = true,value =
            "SELECT * FROM  remainder as r where r.user_id=?1")
    List<Remainder> getRemainderListByUserId(Long userId);

    //-- Set

}
