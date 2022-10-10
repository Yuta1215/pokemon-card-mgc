package management.pokemon.card.code;

import lombok.Getter;

@Getter
public enum ErrorCode {
  BAD_REQUEST("EC001"),
  SESSION_TOKEN_NOT_FOUND("EC002"),
  AWS_EXCEPTION("EC101");

  private final String code;

  private ErrorCode(String code) {
    this.code = code;
  }

}
