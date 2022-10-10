package management.pokemon.card.domain.models.login;

import lombok.Getter;
import management.pokemon.card.domain.shared.ResponseBase;

@Getter
public final class LoginResponse extends ResponseBase {
  private final String sessionToken;

  public LoginResponse(String sessionToken) {
    this.sessionToken = sessionToken;
  }
}
