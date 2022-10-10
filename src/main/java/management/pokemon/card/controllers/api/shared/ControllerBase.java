package management.pokemon.card.controllers.api.shared;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import management.pokemon.card.domain.models.login.ISessionRepository;
import management.pokemon.card.domain.models.validation.HeaderRequiredSpecification;

@RequestMapping("/api")
public abstract class ControllerBase {
  protected HttpServletRequest httpServletRequest;

  @Autowired
  private ISessionRepository sessionRepository;

  protected void main() throws Exception {
    this.validHeader();
    this.sessionRepository.findByToken(this.httpServletRequest.getHeader("X-Session-Token"));
  }

  private void validHeader() throws Exception {
    HeaderRequiredSpecification hrs = new HeaderRequiredSpecification(this.httpServletRequest);
    hrs.handle();
  }
}
