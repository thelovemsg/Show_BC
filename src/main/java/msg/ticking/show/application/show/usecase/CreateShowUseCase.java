package msg.ticking.show.application.show.usecase;

import msg.ticking.show.framework.web.dto.show.ShowCreateInputDto;

public interface CreateShowUseCase {
    ShowCreateInputDto.Response createShow(ShowCreateInputDto.Request request);
}
