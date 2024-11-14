package msg.ticking.show.domain.enums;

public enum SeatStatusEnum {
    BROKEN("고장"),
    AVAILABLE("사용가능"),
    RESERVED("예약됨"),
    CLOSED("닫힘"),
    ;

    private final String name;

    SeatStatusEnum(String name) {
        this.name = name;
    }
}
