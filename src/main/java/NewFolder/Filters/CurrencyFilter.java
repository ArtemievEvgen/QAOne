package NewFolder.Filters;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import java.util.HashMap;

public class CurrencyFilter {
    private WebDriver driver;

    public CurrencyFilter(WebDriver driver) {
        this.driver = driver;
    }

    private By priceFromXp = By.xpath("//div[@class='vehicle-form__line']//input[@placeholder='от']");
    private By priceBeforeXp = By.xpath("//div[@class='vehicle-form__line']//input[@placeholder='до']");
    private By exchange = By.xpath("//*[@class='vehicle-form__field']//*[text()='Обмен']/..");

    public CurrencyFilter currencyEnter(String currency) {
        if (currency != null) {
            driver.findElement(By.xpath("//a[contains(text(),'" + currency + "')]")).click();
        }
        return this;
    }

    public CurrencyFilter priceFromEnter(String priceFrom) {
        if (priceFrom != null) {
            driver.findElement(priceFromXp).sendKeys(priceFrom);
            driver.findElement(priceBeforeXp).click();
        }
        return this;
    }

    public CurrencyFilter priceBeforeEnter(String priceBefore) {
        if (priceBefore != null) {
            driver.findElement(priceBeforeXp).sendKeys(priceBefore);
            driver.findElement(priceFromXp).click();
        }
        return this;
    }

    public void priceAdditional(HashMap<Integer, Boolean> priceAdditional) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", driver.findElement(exchange));
        for (int i = 1; i <= priceAdditional.size(); i++) {
            if (priceAdditional.get(i) != null) {
                boolean check = driver.findElement(By.xpath("//div[@class='vehicle-form__row'][2]//div[@class='vehicle-form__field']/li[" + i + "]//input")).isSelected();
                if (priceAdditional.get(i) && !check) {
                    driver.findElement(By.xpath("//div[@class='vehicle-form__row'][2]//div[@class='vehicle-form__field']/li[" + i + "]")).click();
                } else if (!priceAdditional.get(i) && check) {
                    driver.findElement(By.xpath("//div[@class='vehicle-form__row'][2]//div[@class='vehicle-form__field']/li[" + i + "]")).click();
                }
            }
        }
    }
}
