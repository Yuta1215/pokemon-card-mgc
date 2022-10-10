package management.pokemon.card.domain.models.login;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBDocument;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;

import lombok.Data;

@Data
@DynamoDBTable(tableName = "SessionTable")
public class Session {

  private String token;

  private DynamoDBMap userObject;

  private int expiredAt;

  private int ttl;

  @DynamoDBHashKey(attributeName = "Token")
  public String getToken() {
    return this.token;
  }

  @DynamoDBAttribute(attributeName = "UserObject")
  public DynamoDBMap getUserObject() {
    return this.userObject;
  }

  @DynamoDBAttribute(attributeName = "ExpiredAt")
  public int getExpiredAt() {
    return this.expiredAt;
  }

  @DynamoDBAttribute(attributeName = "Ttl")
  public int getTtl() {
    return this.ttl;
  }

  @Data
  @DynamoDBDocument
  public static class DynamoDBMap {
    private int userId;
    private String name;

    @DynamoDBAttribute(attributeName = "user_id")
    public int getUserId() {
      return this.userId;
    }

    @DynamoDBAttribute(attributeName = "name")
    public String getName() {
      return this.name;
    }
  }
}
