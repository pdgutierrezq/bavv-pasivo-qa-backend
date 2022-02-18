/**
 * Grupo Aval Acciones y Valores S.A. CONFIDENTIAL
 *
 * <p>Copyright (c) 2018 . All Rights Reserved.
 *
 * <p>NOTICE: This file is subject to the terms and conditions defined in file 'LICENSE', which is
 * part of this source code package.
 *
 */

package co.com.bavv.old.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Xml {
    private Xml() {
        throw new IllegalStateException("Utility class");
    }
    public static String getDataTextString(String string, String tag) {
        String getData = "";
        Pattern pattern = Pattern.compile("<" + tag + ">(.*?)" + "</" + tag + ">");
        Matcher matcher = pattern.matcher(string);
        if (matcher.find()) {
            getData = matcher.group(1);
        }
        return getData;
    }
}
