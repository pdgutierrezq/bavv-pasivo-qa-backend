/**
 * Grupo Aval Acciones y Valores S.A. CONFIDENTIAL
 *
 * <p>Copyright (c) 2018 . All Rights Reserved.
 *
 * <p>NOTICE: This file is subject to the terms and conditions defined in file 'LICENSE', which is
 * part of this source code package.
 */
package co.com.bavv.old.data;

import static co.com.bavv.old.util.Constantes.DATA_CAT_PROP;
import static co.com.bavv.old.util.Constantes.DATA_CHANNELS_PROP;
import static co.com.bavv.old.util.Constantes.DATA_CLIENT_PROP;
import static co.com.bavv.old.util.Constantes.DATA_FIRST_NAME_PROP;
import static co.com.bavv.old.util.Constantes.DATA_INSURANCE;
import static co.com.bavv.old.util.Constantes.DATA_LAST_NAME_PROP;
import static co.com.bavv.old.util.Constantes.DATA_NUMDOC_PROP;
import static co.com.bavv.old.util.Constantes.DATA_PHONE_PROP;
import static co.com.bavv.old.util.Constantes.DATA_REST_LIST_PROP;
import static co.com.bavv.old.util.Constantes.DATA_SALARY_PROP;
import static co.com.bavv.old.util.Constantes.DATA_TIPODOC_PROP;
import static co.com.bavv.old.util.Constantes.DATA_UPDATED_PROP;
import static co.com.bavv.old.util.Constantes.DATA_USERS_PROP;
import static co.com.bavv.old.util.Report.LOGGER;

import co.com.bavv.old.model.ActorData;
import co.com.bavv.old.model.BodyWs;
import co.com.bavv.old.model.City;
import co.com.bavv.old.model.CityList;
import co.com.bavv.old.model.ClientConditions;
import co.com.bavv.old.util.Constantes;
import com.github.javafaker.Faker;
import com.google.common.collect.Streams;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import org.aeonbits.owner.ConfigFactory;

public class DataProvider {

    private DataProvider() {
        throw new IllegalStateException("Utility class");
    }

    private static Environment environment;

    static {
        environment = ConfigFactory.create(Environment.class);
    }

    private static String getJsonUsers() {
        return environment.users();
    }

    public static BodyWs getBodyIdentification(String tipoUsuario) {
        JsonObject jsonObjectUser = filterUsersList(tipoUsuario, getUsers());

        return BodyWs.builder()
            .documentType(jsonObjectUser.get(DATA_TIPODOC_PROP).getAsString())
            .documentNumber(jsonObjectUser.get(DATA_NUMDOC_PROP).getAsString())
            .firstName(jsonObjectUser.get(DATA_FIRST_NAME_PROP).getAsString())
            .lastName(jsonObjectUser.get(DATA_LAST_NAME_PROP).getAsString())
            .phone(jsonObjectUser.get(DATA_PHONE_PROP).getAsString())
            .build();
    }

    public static ActorData getActorData(ClientConditions clientConditions) {

        JsonObject joMain = getDataMain();
        JsonObject jsonObjectUser = JsonFile.getUser(joMain, clientConditions);

        return buildActorData(jsonObjectUser, joMain);
    }

    private static JsonObject getDataMain() {
        JsonObject joMain = null;
        try {
            joMain = JsonFile.readJsonFile();
        } catch (FileNotFoundException e) {
            LOGGER.error("Fail reading json data file->".concat(e.getMessage()));
        }
        return joMain;
    }

    public static String getCompanyCity(String daneCode, String cityListType) {
        CityList cityList = null;
        String city = "";

        if (!daneCode.equals("0")) {
            try {
                cityList = JsonFile.readCitiesFile(cityListType);
            } catch (FileNotFoundException e) {
                LOGGER.error("Fail reading json country cities file->".concat(e.getMessage()));
            }
            daneCode = (daneCode.startsWith("0")) ? daneCode.substring(1) : daneCode;
            city = filterCity(cityList, daneCode);
        }

        return city;
    }

    private static String filterCity(CityList listCities, String daneCode) {
        return Objects.requireNonNull(listCities).getCity().stream()
            .filter(e -> e.getCodeDANE().equals(daneCode))
            .map(City::getMunicipality)
            .findFirst()
            .orElseGet(() -> "Ciudad no encontrada");
    }

    private static String fixNull(JsonObject jo, String tag, String ifNull) {
        return (Objects.isNull(jo.get(tag))) ? ifNull : jo.get(tag).getAsString();
    }

    private static boolean fixNull(JsonObject jo, String tag, boolean ifNull) {
        return (Objects.isNull(jo.get(tag))) ? ifNull : jo.get(tag).getAsBoolean();
    }

    private static ActorData buildActorData(JsonObject jsonObjectUser, JsonObject joMain) {
        Faker faker = new Faker();

        String docType = fixNull(jsonObjectUser, DATA_TIPODOC_PROP, "CC");
        String firstName = fixNull(jsonObjectUser, DATA_FIRST_NAME_PROP, faker.name().firstName());
        String lastName = fixNull(jsonObjectUser, DATA_LAST_NAME_PROP, faker.name().lastName());
        String phone = fixNull(jsonObjectUser, DATA_PHONE_PROP, "3256768989");
        String salary = fixNull(jsonObjectUser, DATA_SALARY_PROP, "2000000");
        boolean client = fixNull(jsonObjectUser, DATA_CLIENT_PROP, true);
        boolean updated = fixNull(jsonObjectUser, DATA_UPDATED_PROP, true);
        boolean channels = fixNull(jsonObjectUser, DATA_CHANNELS_PROP, true);
        boolean cat = fixNull(jsonObjectUser, DATA_CAT_PROP, true);
        boolean restList = fixNull(jsonObjectUser, DATA_REST_LIST_PROP, false);
        boolean insurance = fixNull(jsonObjectUser, DATA_INSURANCE, false);

        return ActorData.builder()
            .documentType(docType)
            .documentNumber(jsonObjectUser.get(DATA_NUMDOC_PROP).getAsString())
            .firstName(firstName)
            .lastName(lastName)
            .phone(phone)
            .salary(salary)
            .client(client)
            .updated(updated)
            .channels(channels)
            .cat(cat)
            .insurance(insurance)
            .restrictiveList(restList)
            .jsonObjectDataFlow(joMain)
            .jsonObjectUser(jsonObjectUser)
            .build();
    }

    public static List<JsonObject> getUsers() {

        return Streams.stream(
                JsonParser.parseString(getJsonUsers())
                    .getAsJsonObject()
                    .get(DATA_USERS_PROP)
                    .getAsJsonArray()
                    .iterator())
            .map(JsonElement::getAsJsonObject)
            .collect(Collectors.toList());
    }

    private static JsonObject filterUsersList(String userType, List<JsonObject> list) {
        return list.stream()
            .filter(e -> e.get("tipoUser").getAsString().equals(userType))
            .findFirst()
            .orElse(new JsonObject());
    }

    public static String getOtp() {
        return Constantes.VALUE_OTP;
    }
}
