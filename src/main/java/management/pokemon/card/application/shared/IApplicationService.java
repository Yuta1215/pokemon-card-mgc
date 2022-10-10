package management.pokemon.card.application.shared;

import org.springframework.stereotype.Service;

import management.pokemon.card.domain.models.login.Session;

@Service
public interface IApplicationService {
  public void setSession(Session session);
}
