package management.pokemon.card.controllers.api.login;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import management.pokemon.card.application.login.LoginApplicationService;
import management.pokemon.card.controllers.api.shared.ControllerBase;
import management.pokemon.card.domain.models.login.LoginRequestBody;
import management.pokemon.card.domain.models.login.LoginResponse;

@RestController
public final class LoginController extends ControllerBase {

  private final LoginApplicationService loginApplicationService;

  public LoginController(LoginApplicationService loginApplicationService) {
    this.loginApplicationService = loginApplicationService;
  }

  @PostMapping("/login")
  public LoginResponse index(
      HttpServletRequest httpServletRequest,
      @RequestBody LoginRequestBody loginRequestBody) throws Exception {
    this.httpServletRequest = httpServletRequest;
    this.loginApplicationService.setSession(this.main());
    return this.loginApplicationService.handle(loginRequestBody);
  }
}
