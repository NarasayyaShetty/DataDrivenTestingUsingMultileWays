package PropertiesFiles;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ExtractDataFromPropertyFile {
    Properties p=new Properties();

    public ExtractDataFromPropertyFile(){
        try{
            FileInputStream fs=new FileInputStream("src/test/resources/dataLocators.properties");
            p.load(fs);

        }catch(IOException e){
            e.printStackTrace();
        }
    }
    public  String getLocator(String key){
        return p.getProperty(key);
    }
}
