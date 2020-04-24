/**
 * Grupo Aval Acciones y Valores S.A. CONFIDENTIAL
 *
 * <p>Copyright (c) 2018 . All Rights Reserved.
 *
 * <p>NOTICE: This file is subject to the terms and conditions defined in file 'LICENSE', which is
 * part of this source code package.
 *
 */

package co.com.avvillaspasivos.data;

import co.com.avvillaspasivos.model.ActorData;
import co.com.avvillaspasivos.util.Constantes;
import co.com.avvillaspasivos.util.Xml;

public class GlobalData {
    public static ActorData actorData;
    public static String otp;


    public static String getOtp(){
        DbQuerys dbQuerys = new DbQuerys();
        String dataTagOtp = dbQuerys.getXmlOtp(actorData.getPhone());
        String otp=Xml.getDataTextString(dataTagOtp, Constantes.TAG_OTP);

        return otp.substring(8);
    }

}
