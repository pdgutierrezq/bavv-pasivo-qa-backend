/**
 * Grupo Aval Acciones y Valores S.A. CONFIDENTIAL
 *
 * <p>Copyright (c) 2018 . All Rights Reserved.
 *
 * <p>NOTICE: This file is subject to the terms and conditions defined in file 'LICENSE', which is
 * part of this source code package.
 */
package co.com.avvillaspasivos.tasks;

import co.com.avvillaspasivos.ui.AddressPage;
import com.github.javafaker.Faker;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Enter;

public class SmallTasks {
  private SmallTasks() {
    throw new IllegalStateException("Utility class");
  }

  public static Performable leaveEmptyFields() {
    Faker faker = new Faker();
    return Task.where(
        "{0} ingresa una ciudad sin cobertura",
        leaveEmptyCityField(),
        Enter.theValue(" ").into(AddressPage.TEXT_ADDRESS)
    );
  }
  public static Performable leaveEmptyCityField() {
    Faker faker = new Faker();
    return Task.where(
        "{0} ingresa una ciudad sin cobertura",
        Enter.theValue(" ").into(AddressPage.TEXT_CITY)
    );
  }

  public static Performable insertInvalidCity() {
    Faker faker = new Faker();
    return Task.where(
        "{0} ingresa una ciudad sin cobertura",
        Enter.theValue(faker.address().city()).into(AddressPage.TEXT_CITY)
    );
  }

  public static Performable writeTextWithSize(int size) {
    Faker faker = new Faker();
    return Task.where(
        "{0} ingresa una direccion tamaño #size",
        Enter.theValue(faker.lorem().characters(size - 1)).into(AddressPage.TEXT_ADDRESS));
  }

  public static Performable writeAddressWithAtSymbol() {
    Faker faker = new Faker();
    return Task.where(
        "{0} ingresa una direccion con @ en cualquier posicion",
        Enter.theValue(faker.address().streetName() + "@" + faker.address().fullAddress())
            .into(AddressPage.TEXT_ADDRESS));
  }

  public static Performable writeAnyNumberOnAddress() {
    Faker faker = new Faker();
    return Task.where(
        "{0} ingresa un numero en la primera posicion de direccion de envio",
        Enter.theValue(faker.number().randomDigit() + faker.address().secondaryAddress())
            .into(AddressPage.TEXT_ADDRESS));
  }
}
