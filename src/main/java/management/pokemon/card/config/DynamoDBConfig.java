package management.pokemon.card.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
@ConfigurationProperties(prefix = "dynamodb")
public class DynamoDBConfig {
    private String region;
    private String endpoint;
}