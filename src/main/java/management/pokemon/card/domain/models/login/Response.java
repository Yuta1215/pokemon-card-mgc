package management.pokemon.card.domain.models.login;

import org.springframework.stereotype.Component;

import management.pokemon.card.domain.shared.ResponseBase;

@Component
public class Response extends ResponseBase {
    private final String sessionToken;

    Response(String sessionToken) {
        this.sessionToken = sessionToken;
    }
}
