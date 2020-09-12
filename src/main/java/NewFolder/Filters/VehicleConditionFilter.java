package NewFolder.Filters;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.HashMap;

public class VehicleConditionFilter {
    private WebDriver driver;

    public VehicleConditionFilter(WebDriver driver) {
        this.driver = driver;
    }

    private By clickFullVehicle = By.xpath("//div[text()='Новый']/ancestor::div[6]/..");

    public void vehicleCondition(HashMap<Integer, Boolean> condition) {
        driver.findElement(clickFullVehicle).click();
        for (int i = 1; i <= condition.size(); i++) {
            if (condition.get(i) != null) {
                boolean check = driver.findElement(By.xpath("//div[@class='dropdown-style dropdown-style_primary dropdown-style_small dropdown-style_right vehicle-form__dropdown vehicle-form__dropdown_width_ssm dropdown-style_visible']//div[2]//ul[1]//li[" + i + "]//input")).isSelected();
                if (condition.get(i) && !check) {
                    driver.findElement(By.xpath("//div[@class='dropdown-style dropdown-style_primary dropdown-style_small dropdown-style_right vehicle-form__dropdown vehicle-form__dropdown_width_ssm dropdown-style_visible']//div[2]//ul[1]//li[" + i + "]")).click();
                } else if (!condition.get(i) && check) {
                    driver.findElement(By.xpath("//div[@class='dropdown-style dropdown-style_primary dropdown-style_small dropdown-style_right vehicle-form__dropdown vehicle-form__dropdown_width_ssm dropdown-style_visible']//div[2]//ul[1]//li[" + i + "]")).click();
                }
            }
        }
    }
}
