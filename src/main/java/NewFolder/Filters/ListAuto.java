package NewFolder.Filters;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.*;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class ListAuto {
    private WebDriver driver;

    public ListAuto(WebDriver driver) {
        this.driver = driver;
    }

    public void DownloadTextAuto(Integer numberCars) {
        if (numberCars != null) {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Date date = new Date();
            String myJarPath = ListAuto.class.getProtectionDomain().getCodeSource().getLocation().getPath();
            String dirPath = new File(myJarPath).getParent();
            SimpleDateFormat formatForDateNow = new SimpleDateFormat("yyyy.MM.dd");
            File dir = new File(dirPath+"/"+formatForDateNow.format(date));
            String dir1 = dirPath+"/"+formatForDateNow.format(date);
            boolean create = dir.mkdir();
            try {
                FileWriter writer = new FileWriter(dir + "//TextAuto.txt", false);
                for (int i = 0; i <= numberCars - 1; ) {
                    List<WebElement> autoName = driver.findElements(By.xpath("//div[@class='vehicle-form__offers-part vehicle-form__offers-part_title']"));
                    List<WebElement> autoMileage = driver.findElements(By.xpath("//div[@class='vehicle-form__offers-part vehicle-form__offers-part_mileage']"));
                    List<WebElement> autoYear = driver.findElements(By.xpath("//div[@class='vehicle-form__offers-part vehicle-form__offers-part_year']"));
                    List<WebElement> autoCity = (driver.findElements(By.xpath("//div[@class='vehicle-form__offers-part vehicle-form__offers-part_city']")));
                    List<WebElement> autoParameter = driver.findElements(By.xpath("//div[@class='vehicle-form__offers-part vehicle-form__offers-part_parameter']"));
                    List<WebElement> autoPrice = driver.findElements(By.xpath("//div[@class='vehicle-form__offers-part vehicle-form__offers-part_price']"));
                    List<WebElement> autoImg = driver.findElements(By.xpath("//div[@class='vehicle-form__panorama-list']/div[1]/div[1]/div[1]"));
                    try {
                        for (i = 0; i <= numberCars - 1; i++) {
                            if (i == 50) {
                                i = 0;
                                numberCars = numberCars - 50;
                                driver.findElement(By.xpath("//a[@class='vehicle-pagination__main']")).click();
                                try {
                                    Thread.sleep(3000);
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                                break;
                            }
                            String image = autoImg.get(i).getCssValue("background-image");
                            image = image.replace("url(\"", "");
                            image = image.replace("\")", "");
                            String name = autoName.get(i).getText();
                            DownloadIMG(image, name, dir1);
                            String year = autoYear.get(i).getText();
                            String parameter = autoParameter.get(i).getText();
                            String mileage = autoMileage.get(i).getText();
                            String city = autoCity.get(i).getText();
                            String price = autoPrice.get(i).getText();
                            writer.write(i + ".) Марка автомобиля: " + name + ".\t Год выпуска: " + year + ".\t Параметры автомобиля: " + parameter + ".\t Пробег: " + mileage + ".\t Город продажи: " + city + ".\t Цена: " + price + ".");
                            writer.append('\n');
                            writer.flush();
                        }
                    } catch (Exception e) {
                        break;
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void DownloadIMG(String imageUrl, String name, String dir) throws IOException {
        URL url = new URL(imageUrl);
        byte[] b = new byte[2048];
        int length;
        try {
            InputStream is = url.openStream();
            OutputStream os = new FileOutputStream(dir + "/" + name + ".jpeg");
            while ((length = is.read(b)) != -1) {
                os.write(b, 0, length);
            }
            is.close();
            os.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

