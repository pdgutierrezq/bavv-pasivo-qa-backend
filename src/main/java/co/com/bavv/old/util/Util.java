/**
 * Grupo Aval Acciones y Valores S.A. CONFIDENTIAL
 *
 * <p>Copyright (c) 2018 . All Rights Reserved.
 *
 * <p>NOTICE: This file is subject to the terms and conditions defined in file 'LICENSE', which is
 * part of this source code package.
 */
package co.com.bavv.old.util;

import co.com.bavv.old.model.CrmResponseData;
import com.github.javafaker.Faker;

public class Util {
  private Util() {
    throw new IllegalStateException("Utility class");
  }

  public static String cleanMoneyFormat(String frontValue) {
    return frontValue.replace("$", "").replace(" ", "").replace(",", "").replace(".", "");
  }

  public static CrmResponseData buildContactData(){
      Faker faker = new Faker();

      String mail = faker.internet().emailAddress();

      return CrmResponseData.builder()
          .mail(mail)
          .cityAddress("Bogotá D.C. - Bogotá D.C.")
          .address(faker.address().streetName().concat(faker.address().fullAddress()))
          .companyName(faker.dragonBall().character())
          .neighborhood(faker.address().streetName())
          .build();
  }
  public static String deleteSpecialChar(String text){
      return text.replaceAll("[^a-zA-Z0-9]"," ");
  }
}
