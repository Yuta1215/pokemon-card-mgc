package management.pokemon.card.controllers.api.shared;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import management.pokemon.card.domain.models.login.Session;
import management.pokemon.card.domain.models.validation.HeaderRequiredSpecification;
import management.pokemon.card.domain.models.validation.SessionTokenService;

@RequestMapping("/api")
public abstract class ControllerBase {
  protected HttpServletRequest httpServletRequest;

  @Autowired
  private SessionTokenService sessionTokenService;

  protected Session main() throws Exception {
    HeaderRequiredSpecification hrs = new HeaderRequiredSpecification(this.httpServletRequest);
    hrs.handle();
    return this.sessionTokenService.handle(this.httpServletRequest.getHeader("X-Session-Token"));
  }
}
