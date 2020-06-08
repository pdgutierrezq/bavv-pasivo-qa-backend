/**
 * Grupo Aval Acciones y Valores S.A. CONFIDENTIAL
 *
 * <p>Copyright (c) 2018 . All Rights Reserved.
 *
 * <p>NOTICE: This file is subject to the terms and conditions defined in file 'LICENSE', which is
 * part of this source code package.
 */
package co.com.avvillaspasivos.data;

import co.com.avvillaspasivos.model.ActorData;
import co.com.avvillaspasivos.util.Constantes;
import co.com.avvillaspasivos.util.Xml;
import lombok.Getter;
import lombok.Setter;
import net.serenitybdd.core.Serenity;

@Getter
@Setter
public class GlobalData {
        private static GlobalData globalData = null;
        private ActorData actorData;
    private GlobalData()
        {
        }
        public static GlobalData getInstance()
        {
            if (globalData == null)
                globalData = new GlobalData();

            return globalData;
        }



    public  String getOtp(){
        String url= Serenity.getWebdriverManager().getWebdriver().getCurrentUrl();
        String otp ="";

        if (url.contains(Constantes.DEV_VALUE)) {
            otp= Constantes.VALUE_OTP;
        } else if (url.contains(Constantes.STG_VALUE)) {
            DbQuerys dbQuerys = new DbQuerys();
            String dataTagOtp = dbQuerys.getXmlOtp(actorData.getPhone());
             otp= Xml.getDataTextString(dataTagOtp, Constantes.TAG_OTP).substring(8);
        }

        return otp;
    }
}
