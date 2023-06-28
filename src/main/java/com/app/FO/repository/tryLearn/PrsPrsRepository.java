package com.app.FO.repository.tryLearn;

import com.app.FO.model.tryLearn.PrsPrs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PrsPrsRepository extends JpaRepository<PrsPrs, Long> {

    @Query(nativeQuery = true, value =
            "SELECT * FROM prs_prs as tt where tt.prs_id=?1 and tt.related_prs_id=?2")
    PrsPrs getPrsPrsByPrsIdAndPrsId(Long prsId, Long relatedPrsId);
}
