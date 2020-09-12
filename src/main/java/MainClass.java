import NewFolder.AutoPage;
import NewFolder.ConfigInput;
import NewFolder.ManualInput;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.Scanner;

public class MainClass {
    public static void main(String[] args) throws IOException {

        Properties property = new Properties();
        String myJarPath = MainClass.class.getProtectionDomain().getCodeSource().getLocation().getPath();
        String dirPath = new File(myJarPath).getParent();
        File fis = new File(dirPath + "/config.properties");
        property.load(new FileReader(fis));
        Scanner in = new Scanner(System.in);
        if(isWindows()){
            System.setProperty("webdriver.chrome.driver", dirPath + "/chromedriver_win32/chromedriver.exe");
        }else if(isMac()){
            System.setProperty("webdriver.chrome.driver", dirPath + "/chromedriver_mac64/chromedriver");
        }else if(isUnix ()){
            System.setProperty("webdriver.chrome.driver", dirPath + "/chromedriver_linux64/chromedriver");
        }else{
            System.out.println("This is unknown OS");
        }
        System.out.println("Введите число чтобы продолжить:");
        System.out.println("1. Самостоятельно вводить данные ");
        System.out.println("2. Запустить с заданными конйигурациями");
        System.out.println("3. По умолчанию (Скачать информация первых 10 автомобилей)");
        System.out.println("Любое другое число отключит программу");
        Integer i = in.nextInt();
        if (i == 1) {
            ManualInput manualInput = new ManualInput();
            manualInput.Enter();
        } else if (i == 2) {
            ConfigInput configInput = new ConfigInput();
            configInput.input();
        } else if (i == 3) {
            Integer numberCars = (10);
            WebDriver driver = new ChromeDriver();
            AutoPage autoPage = new AutoPage(driver);
            autoPage.startProg(numberCars);
        } else {
            System.exit(0);
        }
    }
    public static boolean isWindows(){

        String os = System.getProperty("os.name").toLowerCase();
        //windows
        return (os.indexOf( "win" ) >= 0);

    }

    public static boolean isMac(){

        String os = System.getProperty("os.name").toLowerCase();
        //Mac
        return (os.indexOf( "mac" ) >= 0);

    }

    public static boolean isUnix (){

        String os = System.getProperty("os.name").toLowerCase();
        //linux or unix
        return (os.indexOf( "nix") >=0 || os.indexOf( "nux") >=0);

    }
    public static String getOSVerion() {
        String os = System.getProperty("os.version");
        return os;
    }
}

