package management.pokemon.card.controllers.api.login;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import management.pokemon.card.domain.models.login.LoginResponse;

@RestController
public final class LogoutController {

  @PostMapping("/logout")
  public LoginResponse index() {
    return new LoginResponse("dummy");
  }
}
