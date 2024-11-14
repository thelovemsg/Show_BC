package msg.ticking.show.domain.model;

import msg.ticking.show.domain.model.vo.Address;

import java.util.ArrayList;
import java.util.List;

public class Section {
    private Long sectionId;
    private String sectionName;
    private String description;
    private List<Seat> seats = new ArrayList<>();
    private Address address;
    private boolean isClosed;

    public void addSeats(List<Seat> newSeats) {
        if (isClosed) {
            throw new IllegalStateException("폐쇄된 섹션에는 좌석을 추가할 수 없습니다.");
        }
        this.seats.addAll(newSeats);
    }

    public void closeSection() {
        this.isClosed = true;
        for (Seat seat : seats) {
            seat.closeSeat();
        }
        // 섹션 내의 모든 좌석도 비활성화 또는 예약 불가 상태로 변경
    }
}
