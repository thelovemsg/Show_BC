package msg.ticking.show.domain.model.vo;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class LocationInfo {
    private int floor;
    private int row;
    private String seatNumber;
    private String section;
}
