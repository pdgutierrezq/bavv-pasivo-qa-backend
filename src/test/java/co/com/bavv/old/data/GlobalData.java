/**
 * Grupo Aval Acciones y Valores S.A. CONFIDENTIAL
 *
 * <p>Copyright (c) 2018 . All Rights Reserved.
 *
 * <p>NOTICE: This file is subject to the terms and conditions defined in file 'LICENSE', which is
 * part of this source code package.
 */
package co.com.bavv.old.data;

import co.com.bavv.old.model.ActorData;
import lombok.Getter;
import lombok.Setter;

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


}
