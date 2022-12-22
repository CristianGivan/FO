package com.app.FO.dto.remainder;

import com.app.FO.model.remainder.Snooze;

import java.time.LocalDateTime;
import java.util.List;

public class RemainderDTO {
    private Double remainderId;
    private String remainder;
    private LocalDateTime createdDateTime;
    private LocalDateTime remainderDateTime;
    private List<Snooze> snoozes;
    //todo  o sa  continui dupa snooze
}
