package msg.ticking.show.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import msg.ticking.show.domain.enums.SeatStatusEnum;
import msg.ticking.show.domain.enums.SeatTypeEnum;
import msg.ticking.show.domain.model.vo.LocationInfo;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Seat {
    private Long seatId;
    private SeatTypeEnum seatType;  // 좌석의 타입 (예: REGULAR, VIP 등)
    private Integer x;  // 좌표 x (열 정보 등으로 사용 가능)
    private Integer y;  // 좌표 y (행 정보 등으로 사용 가능)
    private LocationInfo locationInfo;
    private SeatStatusEnum seatStatus;  // 좌석 상태 (예: EMPTY, RESERVED 등)
    private boolean isAvailable;

    // 팩토리 메서드를 통해 좌석을 생성하는 방식 개선
    public static Seat createSeat(SeatTypeEnum seatType, LocationInfo locationInfo) {
        return Seat.builder()
                .seatType(seatType)
                .locationInfo(locationInfo)
                .seatStatus(SeatStatusEnum.AVAILABLE)  // 초기 상태는 EMPTY
                .isAvailable(Boolean.TRUE)
                .build();
    }

    public void closeSeat() {
        this.seatStatus = SeatStatusEnum.CLOSED;
    }

    // 좌석 예약 메서드 추가
    public void reserveSeat() {
        if (!isAvailable) {
            throw new IllegalStateException("현재 좌석은 예약할 수 없는 상태입니다." + this.seatStatus.name());
        }
        this.isAvailable = false;
        this.seatStatus = SeatStatusEnum.RESERVED;
    }

    // 좌석 해제(취소) 메서드 추가
    public void cancelReservation() {
        if (seatStatus != SeatStatusEnum.RESERVED) {
            throw new IllegalStateException("현재 좌석은 예약 상태가 아닙니다.");
        }
        this.isAvailable = true;
        this.seatStatus = SeatStatusEnum.AVAILABLE;
    }

    // 좌석 상태 변경 메서드
    public void updateStatus(SeatStatusEnum newStatus) {
        this.seatStatus = newStatus;
        if (newStatus == SeatStatusEnum.AVAILABLE) {
            this.isAvailable = true;
        } else {
            this.isAvailable = false;
        }
    }
}