package utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
    static Properties property;
    public static Properties configReader (String filePath){
        try {
            FileInputStream file = new FileInputStream(filePath);
            property=new Properties();
            property.load(file);




        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


        return property;
    }


    // getting data
    public static String getPropertyValue(String key) {

      return   property.getProperty(key);
    }
}
