package co.com.avvillaspasivos.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class BodyMasivian {
  @JsonProperty("UserName")
  public String userName;

  @JsonProperty("Password")
  public String password;

  @JsonProperty("RememberMe")
  public Boolean rememberMe;

  @JsonProperty("commit")
  public String commit;
}
