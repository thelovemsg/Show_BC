package msg.ticking.show.domain.model;

import lombok.*;
import msg.ticking.show.domain.enums.ShowStatusEnum;
import msg.ticking.show.domain.model.policy.PricePolicy;
import msg.ticking.show.domain.model.vo.Money;
import msg.ticking.show.domain.model.vo.ShowTimeRange;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Show {
    private Long showId;
    private String title;
    private String description;
    private Money baseTicketPrice;
    private ShowStatusEnum showStatusEnum;
    private List<PricePolicy> pricePolicyList = new ArrayList<>();
    private List<ShowSchedule> showScheduleList = new ArrayList<>();

    public Show(String title, String description, Money baseTicketPrice) {
        this.title = title;
        this.description = description;
        this.baseTicketPrice = baseTicketPrice;
    }

    public void addPricePolicy(PricePolicy policy) {
        this.pricePolicyList.add(policy);
    }

    public void removePricePolicy(PricePolicy policy) {
        this.pricePolicyList.remove(policy);
    }

    // 비즈니스 로직: 공연 중단
    public void stopShow() {
        if (this.showStatusEnum == ShowStatusEnum.WAITING) {
            this.showStatusEnum = ShowStatusEnum.STOPPED;
        } else {
            throw new IllegalStateException("공연이 대기중 일때만 중단할 수 있습니다.");
        }
    }

    public static Show createShow(String title, String description, Money baseTicketPrice) {
        return new Show(title, description, baseTicketPrice);
    }

//    public void cancelShow() {
//        this.showStatusEnum = ShowStatusEnum.CANCELED;
//        // TODO : cancel의 경우 티켓이 판매된 건이 존재하기에 환불 event를 호출해야함.
//    }

//    public void addSchedule(LocalDateTime startDateTime, LocalDateTime endDateTime, BigDecimal finalPrice) {
//        showScheduleList.add(ShowSchedule.create(new ShowTimeRange(startDateTime, endDateTime), finalPrice));
//    }

}
