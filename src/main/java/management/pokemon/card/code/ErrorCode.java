package management.pokemon.card.code;

import lombok.Getter;

@Getter
public enum ErrorCode {
  BAD_REQUEST("EC001");

  private final String code;

  private ErrorCode(String code) {
    this.code = code;
  }

}
