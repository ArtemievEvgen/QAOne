package NewFolder.Filters;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BrandFilter {
    private WebDriver driver;

    public BrandFilter(WebDriver driver) {
        this.driver = driver;
    }

    private By allBrand = By.xpath("//*[@class='vehicle-form__field']//*[text()='Марка']/ancestor::div[1]");
    private By allModel = By.xpath("//*[@class='vehicle-form__field']//*[text()='Модель']/ancestor::div[1]");
    private By searchBrand = By.xpath("//input[@placeholder='Найти марку']");

    public void EnterBrand(String text) {
        if (text != null && !text.equals("Любая")) {
            driver.findElement(allBrand).click();
            driver.findElement(searchBrand).sendKeys(text);
            try {
                driver.findElement(By.xpath("//div[@class='dropdown-style__checkbox-sign'][contains(text(),'" + text + "')]")).click();
            } catch (Exception ex) {
                driver.findElement(allBrand).click();
            }
        }
    }

    public void EnterModel(String text) {
        if (text != null && !text.equals("Любой")) {
        driver.findElement(allModel).click();

            driver.findElement(By.xpath("//input[@placeholder='Найти модель']")).sendKeys(text);
            try {
                driver.findElement(By.xpath("//div[@class='dropdown-style__checkbox-sign'][contains(text(),'" + text + "')]")).click();
            } catch (Exception ex) {
                driver.findElement(allBrand).click();
            }
        }
    }
}
