package management.pokemon.card.domain.models.users;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;

import lombok.Data;

@Data
@DynamoDBTable(tableName="SessionTable")
public class Session {

  private String token;

  private String userObject;

  @DynamoDBHashKey(attributeName = "Token")
  public String getToken() {
    return this.token;
  }

  @DynamoDBAttribute(attributeName = "UserObject")
  public String getValue() {
    return this.userObject;
  }
  
}
