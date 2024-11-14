package msg.ticking.show.framework.web.dto.show;

import lombok.*;
import msg.ticking.show.domain.enums.ShowStatusEnum;
import msg.ticking.show.domain.model.Show;
import msg.ticking.show.domain.model.vo.Money;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ShowCreateInputDto {

    @Getter
    @Setter
    public static class Request{
        private String title;
        private String description;
        private Money baseTicketPrice;
    }

    @Getter
    @Setter
    @NoArgsConstructor
    @Builder
    @AllArgsConstructor
    public static class Response{
        private Long showId;
        private String title;
        private String description;
        private Money baseTicketPrice;
        private ShowStatusEnum showStatusEnum;
    }

    public static Response toDto(Show show) {
        return Response
                .builder()
                .showId(show.getShowId())
                .showStatusEnum(show.getShowStatusEnum())
                .title(show.getTitle())
                .description(show.getDescription())
                .baseTicketPrice(show.getBaseTicketPrice())
                .build();
    }
}
