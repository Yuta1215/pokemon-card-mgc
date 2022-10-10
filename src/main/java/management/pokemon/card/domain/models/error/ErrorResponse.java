package management.pokemon.card.domain.models.error;

import lombok.Getter;
import management.pokemon.card.domain.shared.ResponseBase;

@Getter
public class ErrorResponse extends ResponseBase {
  private final String code;

  public ErrorResponse(String code) {
    this.result = 1;
    this.code = code;
  }
}
