package management.pokemon.card.infrastructure;

import org.springframework.stereotype.Component;

import com.amazonaws.client.builder.AwsClientBuilder.EndpointConfiguration;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;

import management.pokemon.card.config.DynamoDB;

@Component
public class DynamoDB {

    private AmazonDynamoDB amazonDynamoDB;

    public DynamoDB(DynamoDB dynamoDBConfig) {
        AmazonDynamoDBClientBuilder builder = AmazonDynamoDBClientBuilder.standard();
        if (dynamoDBConfig.getEndpoint() != null) {
            EndpointConfiguration config = new EndpointConfiguration(dynamoDBConfig.getEndpoint(),
                    dynamoDBConfig.getRegion());
            builder.setEndpointConfiguration(config);
        }
        this.amazonDynamoDB = builder.build();
    }

    public DynamoDBMapper getMapper() {
        return new DynamoDBMapper(this.amazonDynamoDB);
    }
}
