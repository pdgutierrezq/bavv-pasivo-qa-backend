package co.com.bavv.pasivo.api.data.model;

import com.peterland.cucumber.datadriven.model.data.BaseDataBean;
import com.peterland.cucumber.datadriven.model.data.DataProvider;
import java.util.HashMap;

public class GeneralParametersBean extends BaseDataBean {
    @DataProvider(
        dataFile = "src/test/resources/data/general/users.csv",
        separator = ';',
        key = "USUARIO"
    )
    public static HashMap<String, HashMap> userList;

    @DataProvider(
        dataFile = "src/test/resources/data/general/expressions.csv",
        separator = ';',
        key = "EXP"
    )
    public static HashMap<String, HashMap> expressionsList;
}
