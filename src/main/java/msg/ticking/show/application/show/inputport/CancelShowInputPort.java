package msg.ticking.show.application.show.inputport;

import lombok.RequiredArgsConstructor;
import msg.ticking.show.application.show.outputport.ShowOutputPort;
import msg.ticking.show.application.show.usecase.CancelShowUseCase;
import msg.ticking.show.domain.model.Show;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.NoSuchElementException;

@Service
@Transactional
@RequiredArgsConstructor
public class CancelShowInputPort implements CancelShowUseCase {

    private final ShowOutputPort showOutputPort;

    @Override
    public void cancelShow(Long showId) {
        Show show = showOutputPort.findById(showId).orElseThrow(() -> new NoSuchElementException());
        // TODO : 예약된 티켓들은 취소 처리요청해야함.

    }
}
