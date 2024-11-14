package msg.ticking.show.application.show.usecase;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public interface CreateShowScheduleUseCase {
    void createShowSchedule(LocalDateTime startDateTime, LocalDateTime endDateTime, BigDecimal finalPrice);
}
