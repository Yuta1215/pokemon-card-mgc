package management.pokemon.card.domain.models.login;

public interface ISessionRepository {
    Session findByToken(String token);
}