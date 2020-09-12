package NewFolder.Filters;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class YearOfIssueFilter {
    private WebDriver driver;
    public  YearOfIssueFilter(WebDriver driver) {
        this.driver = driver;
    }

    public void dataFrom(String text){
        if(text!=null){
            driver.findElement(By.xpath("//*[text()='Год выпуска']/ancestor::div[4]/div[2]/div[1]/div[1]//option[text()='"+text+"']")).click();
        }
    }

    public void dataBefore(String text){
        if(text!=null){
            driver.findElement(By.xpath("//*[text()='Год выпуска']/ancestor::div[4]/div[2]/div[1]/div[2]//option[text()='"+text+"']")).click();
        }
    }
}
