package management.pokemon.card.domains.models.users;

import org.springframework.stereotype.Component;

import com.amazonaws.client.builder.AwsClientBuilder.EndpointConfiguration;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;

import software.amazon.awssdk.enhanced.dynamodb.DynamoDbEnhancedClient;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbTable;
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
            // DynamoDbTable<Session> mappedTable = this.dynamoDbEnhancedClient.table("SessionTable",
            //         TableSchema.fromBean(Session.class));

            // DynamoDbClient client = DynamoDbClient.builder()
            //         .endpointOverride(URI.create("http://127.0.0.1:8000")).region(Region.AP_NORTHEAST_1).build();

            AmazonDynamoDBClientBuilder builder = AmazonDynamoDBClientBuilder.standard();
            EndpointConfiguration config = new EndpointConfiguration("http://127.0.0.1:8000", "ap-northeast-1");

            builder.setEndpointConfiguration(config);
            AmazonDynamoDB client = builder.build();

            DynamoDBMapper mapper = new DynamoDBMapper(client);

            /*/
            Session2 tmp = new Session2();
            tmp.setToken("aaaaaaaaa");
            tmp.setValue("sample");
            mapper.save(tmp);
            */

            Session2 result = mapper.load(Session2.class, "aaaaaaaaa");
            System.out.println(result);
            System.out.println(result.getToken());
            System.out.println(result.getValue());

            // Create a KEY object
            /*
            // Key key = Key.builder()
            //         .partitionValue("aaaaaaaaa")
            //         .build();

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
            MySample mySample = new MySample();
            mySample.setId("sample");
            System.out.println(mySample);
            System.out.println(mySample.getClass());
            System.out.println(mySample instanceof MySample);
            */
            return "";

        } catch (DynamoDbException e) {
            System.out.println("---------");
            System.err.println(e.getMessage());
            System.out.println("---------");
        }

        return "";
    }
}
