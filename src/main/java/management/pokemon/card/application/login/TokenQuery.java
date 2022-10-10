package management.pokemon.card.application.login;

import lombok.Getter;

public class TokenQuery {
  @Getter
  private final String token;

  public TokenQuery(String token) {
    this.token = token;
  }
}
