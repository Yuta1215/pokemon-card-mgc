package management.pokemon.card.domains.models.users;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;

import lombok.Data;

@Data
@DynamoDBTable(tableName="SessionTable2")
public class Session2 {

  private String token;

  private String value;

  @DynamoDBHashKey(attributeName = "Token")
  public String getToken() {
    return this.token;
  }

  @DynamoDBAttribute(attributeName = "Value")
  public String getValue() {
    return this.value;
  }
  
}
