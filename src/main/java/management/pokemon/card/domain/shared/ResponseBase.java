package management.pokemon.card.domain.shared;

import lombok.Getter;

@Getter
public abstract class ResponseBase implements IResponse {
  protected int result = 0;
}
