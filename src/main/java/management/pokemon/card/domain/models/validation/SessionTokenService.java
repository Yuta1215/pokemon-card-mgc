package management.pokemon.card.domain.models.validation;

import org.springframework.stereotype.Service;

import management.pokemon.card.domain.models.login.ISessionRepository;
import management.pokemon.card.domain.models.login.Session;
import management.pokemon.card.exception.request.SessionTokenNotFoundException;

@Service
public class SessionTokenService {
  private final ISessionRepository sessionRepository;

  public SessionTokenService(ISessionRepository sessionRepository) {
    this.sessionRepository = sessionRepository;
  }

  public Session handle(String token) throws Exception {
    Session result = this.sessionRepository.findByToken(token);
    if (result == null) {
      throw new SessionTokenNotFoundException();
    }
    return result;
  }
}
