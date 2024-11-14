package msg.ticking.show.domain.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import msg.ticking.show.domain.enums.ScheduleStatusEnum;
import msg.ticking.show.domain.model.vo.Money;
import msg.ticking.show.domain.model.vo.ShowTimeRange;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
public class ShowSchedule {
    private Long showScheduleId;
    private List<Venue> venueList = new ArrayList<>();
    private ShowTimeRange showTimeRange;
    private ScheduleStatusEnum showScheduleStatus = ScheduleStatusEnum.PREPARING;
    private Money finalPrice;

    // Private 생성자를 통해 외부에서 직접 호출 불가
    private ShowSchedule(ShowTimeRange showTimeRange, Money finalPrice) {
        this.showTimeRange = showTimeRange;
        this.finalPrice = finalPrice;
    }

    private void addVenue(Venue venue) {
        this.venueList.add(venue);
    }

    private void removeVenue(Venue venue) {
        this.venueList.remove(venue);
    }

    public void updateStatus(ScheduleStatusEnum scheduleStatusEnum) {
        this.showScheduleStatus = scheduleStatusEnum;
    }

//    public static ShowSchedule create(ShowTimeRange showTimeRange, BigDecimal finalPrice) {
//        return new ShowSchedule(showTimeRange, finalPrice);
//    }

}
