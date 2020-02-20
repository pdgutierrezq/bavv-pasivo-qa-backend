/**
 * Grupo Aval Acciones y Valores S.A. CONFIDENTIAL
 *
 * <p>Copyright (c) 2018 . All Rights Reserved.
 *
 * <p>NOTICE: This file is subject to the terms and conditions defined in file 'LICENSE', which is
 * part of this source code package.
 */
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
