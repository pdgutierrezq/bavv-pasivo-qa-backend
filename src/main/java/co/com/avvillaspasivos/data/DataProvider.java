package co.com.avvillaspasivos.data;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.aeonbits.owner.ConfigFactory;

import java.util.ArrayList;
import java.util.List;

public class DataProvider {

  private DataProvider() {
    throw new IllegalStateException("Utility class");
  }
  //  @Steps(shared = true)
  private static Environment environment;

  static {
    environment = ConfigFactory.create(Environment.class);
  }

  public static String getJsonUsersType() {
    return environment.usersType();
  }

  public static String getJsonUsers() {
    return environment.users();
  }

  public static List<String> getUsersIdentification() {

    JsonParser parser = new JsonParser();
    List<String> users = new ArrayList<>();

    JsonObject jsonObject = parser.parse(getJsonUsersType()).getAsJsonObject();

    JsonArray jsonElements = jsonObject.get("users").getAsJsonArray();
    jsonElements.forEach(je -> users.add(je.getAsJsonObject().get("name").getAsString()));

    return users;
  }
}
