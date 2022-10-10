package management.pokemon.card.application.login;

import java.util.UUID;

import org.springframework.stereotype.Service;

import management.pokemon.card.application.shared.ApplicationServiceBase;
import management.pokemon.card.domain.models.login.ILoginUserRepository;
import management.pokemon.card.domain.models.login.LoginRequestBody;
import management.pokemon.card.domain.models.login.LoginResponse;
import management.pokemon.card.domain.models.login.SessionRepository;

@Service
public final class LoginApplicationService extends ApplicationServiceBase {

  private final ILoginUserRepository loginUserRepository;
  private final SessionRepository sessionRepository;

  public LoginApplicationService(ILoginUserRepository loginUserRepository, SessionRepository sessionRepository) {
    this.loginUserRepository = loginUserRepository;
    this.sessionRepository = sessionRepository;
  }

  public LoginResponse handle(LoginRequestBody body) {
    long result = this.loginUserRepository.countByEmailAndPasswordAndDeleteFlag(body.getEmail(), body.getPassword(), 0);
    if (result >= 1) {
      UUID uuid = UUID.randomUUID();
      String token = "t-" + uuid.toString();
    }
    return new LoginResponse("dummy");
  }

}
