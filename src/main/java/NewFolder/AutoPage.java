package NewFolder;

import NewFolder.Filters.*;
import org.openqa.selenium.WebDriver;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

public class AutoPage {
    private WebDriver driver;

    public AutoPage(WebDriver driver) {
        this.driver = driver;
    }

    public void startProg(Integer numberCars) {
        ListAuto listAuto = new ListAuto(driver);
        listAuto.DownloadTextAuto(numberCars);
        driver.quit();
    }

    public void startProg(HashMap<Integer, Boolean> condition, HashMap<Integer, Boolean> priceAdditional,
                          HashMap<Integer, Boolean> bodyType, String currency, String priceBefore,
                          String priceFrom, String brand, String model, String dataBefore, String dataFrom, Integer numberCars) {

        VehicleConditionFilter vehicleConditionFilter = new VehicleConditionFilter(driver);
        CurrencyFilter currencyFilter = new CurrencyFilter(driver);
        BrandFilter brandFilterImpl = new BrandFilter(driver);
        YearOfIssueFilter yearOfIssueFilter = new YearOfIssueFilter(driver);
        BodyTypeFilter bodyTypeFilter = new BodyTypeFilter(driver);
        ListAuto listAuto = new ListAuto(driver);

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://ab.onliner.by/");

        vehicleConditionFilter.vehicleCondition(condition);

        currencyFilter.currencyEnter(currency);
        currencyFilter.priceFromEnter(priceFrom);
        currencyFilter.priceBeforeEnter(priceBefore);
        currencyFilter.priceAdditional(priceAdditional);

        brandFilterImpl.EnterBrand(brand);
        brandFilterImpl.EnterModel(model);

        yearOfIssueFilter.dataFrom(dataFrom); //1890 - 2020
        yearOfIssueFilter.dataBefore(dataBefore); //1890 - 2020

        bodyTypeFilter.bodyType(bodyType);

        listAuto.DownloadTextAuto(numberCars);

        System.out.println("Nice bro");
        driver.quit();
    }
}
