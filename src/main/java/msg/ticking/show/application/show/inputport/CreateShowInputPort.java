package msg.ticking.show.application.show.inputport;

import lombok.RequiredArgsConstructor;
import msg.ticking.show.application.show.outputport.ShowOutputPort;
import msg.ticking.show.application.show.usecase.CreateShowUseCase;
import msg.ticking.show.domain.model.Show;
import msg.ticking.show.framework.web.dto.show.ShowCreateInputDto;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class CreateShowInputPort implements CreateShowUseCase {

    private final ShowOutputPort showOutputPort;

    @Override
    public ShowCreateInputDto.Response createShow(ShowCreateInputDto.Request request ) {
        Show show = Show.createShow(request.getTitle(), request.getDescription(), request.getBaseTicketPrice());
        Show save = showOutputPort.save(show);
        return ShowCreateInputDto.toDto(save);
    }
}
