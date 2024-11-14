package msg.ticking.show.domain.enums;

import lombok.Getter;

@Getter
public enum ScheduleStatusEnum {
    SCHEDULED("Scheduled"),
    CANCELED("Canceled"),
    POSTPONED("Postponed"),
    ONGOING("Ongoing"),
    COMPLETED("Completed"),
    PREPARING("Preparing");

    private final String name;

    ScheduleStatusEnum(String name) {
        this.name = name;
    }
}
