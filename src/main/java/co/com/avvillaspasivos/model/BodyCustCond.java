package co.com.avvillaspasivos.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class BodyCustCond {
  private String documentType;
  private String documentNumber;
}
