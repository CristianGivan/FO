package com.app.FO.model.remainder;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table (name = "snooze")
@Getter
@Setter
@NoArgsConstructor
public class Snooze {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "snooze_seq")
    @SequenceGenerator(name = "snooze_seq",
            sequenceName = "snooze_seq",
            initialValue = 1,
            allocationSize = 1)
    @Column(name = "snooze_id")
    @Setter(AccessLevel.NONE)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "remainder_id")
    private Remainder remainder;

    @Column(name = "snooze_time")
    private LocalTime snoozeTime;

    @Column(name = "snooze_count")
    private Integer snoozeCount;

    @Override
    public String toString() {
        return "Snooze{" +
                "id=" + id +
                ", remainderId=" + remainder.getId() +
                ", snoozeTime=" + snoozeTime +
                ", snoozeCount=" + snoozeCount +
                '}';
    }
}
