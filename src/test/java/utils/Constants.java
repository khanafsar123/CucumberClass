package utils;

import org.apache.poi.xssf.model.MapInfo;
import org.apache.xmlbeans.impl.xb.xsdschema.Public;

public class Constants {
    public static final String CONFIGURATION_FILEPATH =
            System.getProperty("user.dir") + "/src/test/resources/config/config.properties";


    public static final int EXPLICIT_WAIT = 20;
    public static final int IMPLICIT_WAIT = 10;

    public static final String TESTDATA_FILEPATH =
            System.getProperty("user.dir") + "/src/test/resources/testData/batch14excel.xlsx";
    public static final String SCREENSHOT_FILEPATH =   System.getProperty("user.dir") + "/screenshots/";

    public static void main (String[] args) {

    }
}
