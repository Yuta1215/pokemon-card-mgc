package management.pokemon.card.domain.models.validation;

import javax.servlet.http.HttpServletRequest;

import management.pokemon.card.exception.request.HeaderException;

public class HeaderRequiredSpecification {
  private final HttpServletRequest request;

  public HeaderRequiredSpecification(HttpServletRequest request) {
    this.request = request;
  }

  public void handle() throws HeaderException {
    if (this.request.getMethod().equals("POST")) {
      this.contentType();
    }
    if (!this.request.getRequestURI().equals("/api/login")) {
      this.token();
    }
  }

  private void contentType() throws HeaderException {
    String contentType = this.request.getHeader("Content-Type");
    if (contentType == null) {
      throw new HeaderException();
    }
    if (!contentType.equals("application/json")) {
        throw new HeaderException();
    }
  }

  private void token() throws HeaderException {
    String sessionToken = this.request.getHeader("X-Session-Token");
    if (sessionToken == null) {
      throw new HeaderException();
    }
  }
}
