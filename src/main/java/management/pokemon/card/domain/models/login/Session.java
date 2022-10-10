package management.pokemon.card.domain.models.login;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;

import lombok.Data;

@Data
@DynamoDBTable(tableName = "SessionTable")
public class Session {

  private String token;

  private String userObject;

  private int expiredAt;

  private int ttl;

  @DynamoDBHashKey(attributeName = "Token")
  public String getToken() {
    return this.token;
  }

  @DynamoDBAttribute(attributeName = "UserObject")
  public String getUserObject() {
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
}
