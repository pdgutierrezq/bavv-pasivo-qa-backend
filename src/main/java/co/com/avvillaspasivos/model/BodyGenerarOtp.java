package co.com.avvillaspasivos.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class BodyGenerarOtp {

  @JsonProperty("DocumentType")
  public String documentType;

  @JsonProperty("DocumentNumber")
  public String documentNumber;

  @JsonProperty("LastName")
  public String lastName;

  @JsonProperty("FirstName")
  public String firstName;

  @JsonProperty("Phone")
  public String phone;
}
