package management.pokemon.card.domain.models.login;

import org.springframework.stereotype.Component;

import management.pokemon.card.infrastructure.DynamoDB;
import software.amazon.awssdk.services.dynamodb.model.DynamoDbException;

@Component
public class SessionRepository implements ISessionRepository {

    private DynamoDB dynamoDB;

    public SessionRepository(DynamoDB dynamoDB) {
        this.dynamoDB = dynamoDB;
    }

    public Session findByToken(String token) {
        try {
            return this.dynamoDB.getMapper().load(Session.class, token);
        } catch (DynamoDbException e) {
            throw e;
        }
    }
}
