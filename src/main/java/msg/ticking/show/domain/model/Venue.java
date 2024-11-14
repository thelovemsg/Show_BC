package msg.ticking.show.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import msg.ticking.show.domain.model.vo.Address;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Venue {
    private Long venueId;
    private Address location;
    private String description;
    private List<SeatTemplate> seatTemplateList = new ArrayList<>();
    private List<Section> sectionList = new ArrayList<>();
    private int totalSeatNumber;  // 총 좌석 수는 좌석 생성 후 계산됨
    private boolean isClosed;

    // 팩토리 메서드를 통해 생성
    public static Venue createEmptyVenue(Address location, String description) {
        return Venue.builder()
                .location(location)
                .description(description)
                .totalSeatNumber(0)
                .isClosed(false)
                .build();
    }

    public void addSection(Section section) {
        this.sectionList.add(section);
    }

    public void addSeatTemplate(SeatTemplate seatTemplate) {
        this.seatTemplateList.add(seatTemplate);
    }

    // 공연장을 폐쇄하는 메서드
    public void closeVenue() {
        if (isClosed) {
            throw new IllegalStateException("이미 폐쇄된 공연장입니다.");
        }

        for (Section section : sectionList) {
            section.closeSection();
        }

        isClosed = true;
    }

    // 공연장 재개방 메서드
    public void reopenVenue() {
        if (!isClosed) {
            throw new IllegalStateException("공연장은 이미 열려 있습니다.");
        }
        isClosed = false;
    }

    public void createSeatsByTemplate() {
        for (Section section : sectionList) {
            for (SeatTemplate seatTemplate : seatTemplateList) {
                List<Seat> generatedSeats = seatTemplate.createSeats();
                section.addSeats(generatedSeats);
                this.totalSeatNumber += generatedSeats.size();  // 전체 좌석 수 업데이트
            }
        }
    }
}