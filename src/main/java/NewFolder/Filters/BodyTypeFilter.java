package NewFolder.Filters;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;
import java.util.HashMap;

public class BodyTypeFilter {
    private WebDriver driver;
    public BodyTypeFilter(WebDriver driver) {
        this.driver = driver;
    }

    private By clickFullBodyType = By.xpath("//*[text()='Тип кузова']/ancestor::div[4]//div[@class='input-style__real']/..");

    public void bodyType(ArrayList<String> body) {
        if (body != null) {
            driver.findElement(clickFullBodyType).click();
            for (String text : body) {
                if (text.equals("Любой")) {
                    driver.findElement(By.xpath("//div[text()='Тип кузова']/ancestor::div[4]//div[@class='dropdown-style__container']//div[text()='Любой']")).click();
                    break;
                }
                driver.findElement(By.xpath("//*[@class='dropdown-style__checkbox-text']/div[text()='" + text + "']/..")).click();
            }
        }
    }

    public void bodyType(HashMap<Integer,Boolean> bodyType){
        driver.findElement(clickFullBodyType).click();
        for (int i=1; i<=bodyType.size(); i++){
            boolean check = driver.findElement(By.xpath("//div[@class='dropdown-style dropdown-style_primary dropdown-style_small dropdown-style_right vehicle-form__dropdown vehicle-form__dropdown_width_ssm dropdown-style_visible']//div[2]//ul[1]//li["+i+"]//input")).isSelected();
            if (bodyType.get(i) && !check) {
                driver.findElement(By.xpath("//div[@class='dropdown-style dropdown-style_primary dropdown-style_small dropdown-style_right vehicle-form__dropdown vehicle-form__dropdown_width_ssm dropdown-style_visible']//div[2]//ul[1]//li["+i+"]")).click();
            } else if (!bodyType.get(i) && check) {
                driver.findElement(By.xpath("//div[@class='dropdown-style dropdown-style_primary dropdown-style_small dropdown-style_right vehicle-form__dropdown vehicle-form__dropdown_width_ssm dropdown-style_visible']//div[2]//ul[1]//li["+i+"]")).click();
            }
        }
    }
}
