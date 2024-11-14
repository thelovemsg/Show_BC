package msg.ticking.show.application.show.outputport;

import msg.ticking.show.domain.model.Show;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ShowOutputPort {
    Show save(Show show);
    Optional<Show> findById(Long showId);
}
