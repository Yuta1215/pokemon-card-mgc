package management.pokemon.card.application.login;

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
    long result = this.loginUserRepository.countByEmailAndPassword(body.getEmail(), body.getPassword());
    System.out.println(result);
    return new LoginResponse("dummy");
  }

}
