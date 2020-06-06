/**
 * Grupo Aval Acciones y Valores S.A. CONFIDENTIAL
 *
 * <p>Copyright (c) 2018 . All Rights Reserved.
 *
 * <p>NOTICE: This file is subject to the terms and conditions defined in file 'LICENSE', which is
 * part of this source code package.
 *
 */

package co.com.avvillaspasivos.model;

import com.google.gson.JsonObject;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class ActorData {
    private String documentType;
    private String documentNumber;
    private String phone;
    private String firstName;
    private String lastName;
    private String salary;
    private boolean client;
    private boolean updated;
    private boolean channels;
    private boolean cat;
    private boolean restrictiveList;
    private JsonObject jsonObjectDataFlow;
    private JsonObject jsonObjectUser;

    @Override
    public String toString() {
        return "ActorData{" +
            "documentType='" + documentType + '\'' +
            ", documentNumber='" + documentNumber + '\'' +
            ", phone='" + phone + '\'' +
            ", firstName='" + firstName + '\'' +
            ", lastName='" + lastName + '\'' +
            ", salary='" + salary + '\'' +
            ", client=" + client +
            ", updated=" + updated +
            ", channels=" + channels +
            ", cat=" + cat +
            ", restrictiveList=" + restrictiveList +
            '}';
    }
}
