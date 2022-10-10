package management.pokemon.card.domain.models.validation;

import management.pokemon.card.domain.models.login.ISessionRepository;

public class SessionTokenService {
  private ISessionRepository sessionRepository;

  public SessionTokenService(ISessionRepository sessionRepository){
    this.sessionRepository = sessionRepository;
  }
}
