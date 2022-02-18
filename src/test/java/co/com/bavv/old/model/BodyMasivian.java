/**
 * Grupo Aval Acciones y Valores S.A. CONFIDENTIAL
 *
 * <p>Copyright (c) 2018 . All Rights Reserved.
 *
 * <p>NOTICE: This file is subject to the terms and conditions defined in file 'LICENSE', which is
 * part of this source code package.
 */
package co.com.bavv.old.model;

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
