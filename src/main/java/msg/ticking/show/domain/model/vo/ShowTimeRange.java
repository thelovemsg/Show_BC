package msg.ticking.show.domain.model.vo;

import java.time.LocalDateTime;

public class ShowTimeRange {
    private LocalDateTime startDateTime;
    private LocalDateTime endDateTime;

    public ShowTimeRange(LocalDateTime startDateTime, LocalDateTime endDateTime) {
        if (startDateTime.isAfter(endDateTime)) {
            throw new IllegalArgumentException("시작 시간이 종료 시간보다 늦을 수 없습니다.");
        }
        this.startDateTime = startDateTime;
        this.endDateTime = endDateTime;
    }
}
