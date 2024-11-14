package msg.ticking.show.domain.model;

import lombok.Data;
import msg.ticking.show.domain.enums.SeatTypeEnum;
import msg.ticking.show.domain.model.vo.LocationInfo;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Data
public class SeatTemplate {
    private Long seatTemplateId;
    private String templateName;
    private String section;
    private int floor;
    private int totalRows;
    private int totalColumns;
    private SeatTypeEnum seatType;

    public List<Seat> createSeats() {
        List<String> sectionLetters = IntStream.rangeClosed(1, totalRows)
                .mapToObj(this::convertRowNumberToAlphabet)
                .collect(Collectors.toList());

        return IntStream.rangeClosed(1, totalRows)
                .boxed()
                .flatMap(row -> IntStream.rangeClosed(1, totalColumns)
                        .mapToObj(column -> {
                            String section = sectionLetters.get(row-1);
                            String seatNumber = section + "-" + row + "열-" + column + "번";
                            return Seat.createSeat(seatType, new LocationInfo(floor, row, seatNumber, section));
                        }))
                .collect(Collectors.toList());
    }

    private String convertRowNumberToAlphabet(int rowNumber) {
        StringBuilder result = new StringBuilder();
        rowNumber--; // 1부터 시작하도록 조정

        while (rowNumber >= 0) {
            result.insert(0, (char) ('A' + (rowNumber % 26)));
            rowNumber = (rowNumber / 26) - 1;
        }
        return result.toString();
    }

}
