package com.app.FO.repository.event;

import com.app.FO.model.event.EventExpenses;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface EventExpensesRepository extends JpaRepository<EventExpenses, Long> {

    @Query(nativeQuery = true, value =
            "SELECT * FROM event_expenses as tt where tt.event_id=?1 and tt.expenses_id=?2")
    EventExpenses getEventExpensesByEventIdAndExpensesId(Long eventId, Long expensesId);


}
