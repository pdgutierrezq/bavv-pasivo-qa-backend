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
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GlobalData {
        // static variable single_instance of type Singleton
        private static GlobalData globalData = null;
        // variable of type String
        private ActorData actorData;
        // private constructor restricted to this class itself
    private GlobalData()
        {
        }
        // static method to create instance of Singleton class
        public static GlobalData getInstance()
        {
            if (globalData == null)
                globalData = new GlobalData();

            return globalData;
        }



    public  String getOtp(){
        DbQuerys dbQuerys = new DbQuerys();
        String dataTagOtp = dbQuerys.getXmlOtp(actorData.getPhone());
        String otp= Xml.getDataTextString(dataTagOtp, Constantes.TAG_OTP);

        return otp.substring(8);
    }
}
