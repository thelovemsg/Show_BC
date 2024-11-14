package msg.ticking.show.domain.enums;

public enum CurrencyEnum {
    WON("원"), DOLLAR("Dollar");

    CurrencyEnum(String currency) {
        this.currency = currency;
    }

    private final String currency;
}
