package management.pokemon.card.domains.models.users;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbBean;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbPartitionKey;

@Data
@DynamoDbBean
public class Session {
    @Getter(AccessLevel.NONE)
    private String token;

    private String value;

    @DynamoDbPartitionKey
    public String getToken() {
        return this.token;
    }
}
