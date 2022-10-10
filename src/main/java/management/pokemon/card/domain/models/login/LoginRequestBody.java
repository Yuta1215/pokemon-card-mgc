package management.pokemon.card.domain.models.login;

import lombok.Data;
import management.pokemon.card.domain.shared.IRequestBody;

@Data
public class LoginRequestBody implements IRequestBody {
  private final String email;
  private final String password;
}
