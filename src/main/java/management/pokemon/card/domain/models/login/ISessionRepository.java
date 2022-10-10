package management.pokemon.card.domain.models.login;

import org.springframework.stereotype.Repository;

import management.pokemon.card.exception.aws.DynamoDBException;

@Repository
public interface ISessionRepository {
    Session findByToken(String token) throws DynamoDBException;
}