package management.pokemon.card.application.shared;

import org.springframework.stereotype.Service;

import lombok.Setter;
import management.pokemon.card.domain.models.login.Session;

@Service
public abstract class ApplicationServiceBase implements IApplicationService {
  @Setter
  protected Session session;
}
