package management.pokemon.card.domains.models.users;

import org.springframework.stereotype.Component;

import lombok.Data;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbEnhancedClient;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbTable;
import software.amazon.awssdk.enhanced.dynamodb.Key;
import software.amazon.awssdk.enhanced.dynamodb.TableSchema;
import software.amazon.awssdk.services.dynamodb.model.DynamoDbException;

@Component
public class SessionRepository {
    private final DynamoDbEnhancedClient dynamoDbEnhancedClient;

    public SessionRepository(DynamoDbEnhancedClient dynamoDbEnhancedClient) {
        this.dynamoDbEnhancedClient = dynamoDbEnhancedClient;
    }

    public <T> void save(T record, Class<T> recordClass) {
        String tableName = recordClass.getSimpleName();
        DynamoDbTable<T> table = dynamoDbEnhancedClient.table(tableName, TableSchema.fromBean(recordClass));
        table.putItem(record);
    }

    public String getItem() {
        try {
            // Create a DynamoDbTable object
            DynamoDbTable<Session> mappedTable = this.dynamoDbEnhancedClient.table("SessionTable",
                    TableSchema.fromBean(Session.class));

            // Create a KEY object
            Key key = Key.builder()
                    .partitionValue("aaaaaaaaa")
                    .build();

            // Get the item by using the key
            Object result = mappedTable.getItem(r -> r.key(key));
            System.out.println(result);
            // System.out.println((Session)result);
            System.out.println(result.getClass());
            System.out.println(result instanceof Session);
            @Data
            class Sample {
                private String id;
            }
            Sample sample = new Sample();
            sample.setId("sample");
            System.out.println(sample);
            System.out.println(sample.getClass());
            System.out.println(sample instanceof Sample);
            @Data
            class MySample {
                private String id;
            }
            MySample my_sample = new MySample();
            my_sample.setId("sample");
            System.out.println(my_sample);
            System.out.println(my_sample.getClass());
            System.out.println(my_sample instanceof MySample);
            return "";

        } catch (DynamoDbException e) {
            System.out.println("---------");
            System.err.println(e.getMessage());
            System.out.println("---------");
        }

        return "";
    }
}
