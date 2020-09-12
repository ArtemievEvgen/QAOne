package NewFolder;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Properties;

public class ConfigInput {
    public void input() throws IOException {
        Properties property = new Properties();
        String myJarPath = ConfigInput.class.getProtectionDomain().getCodeSource().getLocation().getPath();
        String dirPath = new File(myJarPath).getParent();
        File fis = new File(dirPath + "/config.properties");
        property.load(new FileReader(fis));

        HashMap<Integer,Boolean> condition = new HashMap<>(3);
        condition.put(1,Boolean.parseBoolean(property.getProperty("CARS_CONDITION_NEW")));
        condition.put(2,Boolean.parseBoolean(property.getProperty("CARS_CONDITION_WITH_MILEAGE")));
        condition.put(3,Boolean.parseBoolean(property.getProperty("CARS_CONDITION_CRASH")));

        String currency = property.getProperty("CARS_CURRENCY");
        String priceFrom = property.getProperty("CARS_PRICE_FROM");
        String priceBefore = property.getProperty("CARS_PRICE_BEFORE");
        HashMap<Integer,Boolean> priceAdditional = new HashMap<>(3);
        priceAdditional.put(1,Boolean.parseBoolean(property.getProperty("CARS_EXCHANGE")));
        priceAdditional.put(2,Boolean.parseBoolean(property.getProperty("CARS_PRICE_WITH_VAT")));

        String brand = property.getProperty("CARS_BRAND");
        String model = property.getProperty("CARS_MODEL");
        String dataFrom = property.getProperty("CARS_DATA_FROM");
        String dataBefore = property.getProperty("CARS_DATA_BEFORE");

       HashMap<Integer,Boolean> bodyType = new HashMap<>(12);
        bodyType.put(1,Boolean.parseBoolean(property.getProperty("CARS_TYPE_BODY_SEDAN")));
        bodyType.put(2,Boolean.parseBoolean(property.getProperty("CARS_TYPE_BODY_SUV")));
        bodyType.put(3,Boolean.parseBoolean(property.getProperty("CARS_TYPE_BODY_UNIVERSALIS")));
        bodyType.put(4,Boolean.parseBoolean(property.getProperty("CARS_TYPE_BODY_HATCHBACK")));
        bodyType.put(5,Boolean.parseBoolean(property.getProperty("CARS_TYPE_BODY_LIFTBACK")));
        bodyType.put(6,Boolean.parseBoolean(property.getProperty("CARS_TYPE_BODY_MINIVAN")));
        bodyType.put(7,Boolean.parseBoolean(property.getProperty("CARS_TYPE_BODY_MINIBUS")));
        bodyType.put(8,Boolean.parseBoolean(property.getProperty("CARS_TYPE_BODY_COUPE")));
        bodyType.put(9,Boolean.parseBoolean(property.getProperty("CARS_TYPE_BODY_VAN")));
        bodyType.put(10,Boolean.parseBoolean(property.getProperty("CARS_TYPE_BODY_WAGON")));
        bodyType.put(11,Boolean.parseBoolean(property.getProperty("CARS_TYPE_BODY_CABRIOLET")));
        bodyType.put(12,Boolean.parseBoolean(property.getProperty("CARS_TYPE_BODY_LIMOUSINE")));

        Integer numberCars = Integer.parseInt(property.getProperty("CARS_COUNT"));

        WebDriver driver = new ChromeDriver();
        AutoPage autoPage = new AutoPage(driver);
        autoPage.startProg(condition,priceAdditional,bodyType,currency,priceBefore,priceFrom,brand,model,dataBefore,dataFrom,numberCars);
    }
}
