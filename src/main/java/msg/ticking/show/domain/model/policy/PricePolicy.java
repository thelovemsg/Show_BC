package msg.ticking.show.domain.model.policy;

import msg.ticking.show.domain.enums.SeatTypeEnum;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public class PricePolicy {
    private Long pricePolicyId;
    private Long showId;
    private SeatTypeEnum seatType;
    private BigDecimal additionalPrice;
    private float percentageDiscount;
    private BigDecimal amountDiscount;
    private LocalDate startDate;
    private LocalDate endDate;
    private int priority;
    private List<PolicyCondition> policyConditionList;
    private boolean isActive;
}
