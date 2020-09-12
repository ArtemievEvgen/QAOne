package NewFolder;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.HashMap;
import java.util.Scanner;

public class ManualInput {

    private HashMap<Integer, Boolean> condition;
    private HashMap<Integer, Boolean> priceAdditional;
    private HashMap<Integer, Boolean> bodyType;

    public ManualInput() {}

    public void Enter() {
        condition = new HashMap<>(3);
        condition.put(1, false);
        condition.put(2, false);
        condition.put(3, false);
        priceAdditional = new HashMap<>(2);
        priceAdditional.put(1, false);
        priceAdditional.put(2, false);
        Scanner in = new Scanner(System.in);
        String currency = null;
        String priceFrom = null;
        String priceBefore = null;
        String brand = null;
        String model = null;
        String dataFrom = null;
        String dataBefore = null;
        Integer numberCars = 10;
        bodyType = new HashMap<>(12);
        for (int b = 1; b <= 12; b++) {
            bodyType.put(b, false);
        }
        int i;
        do {
            System.out.println("1. Состояние продоваемого автомобиля");
            System.out.println("2. Цена автомобиля");
            System.out.println("3. Марка автомобиля");
            System.out.println("4. Год выпуска");
            System.out.println("5. Тип кузова");
            System.out.println("6. Число сохранннх автомобилей. Сейчас "+numberCars);
            System.out.println("0. Ок, продолжить");
            i = in.nextInt();
            switch (i) {
                case 1:
                    do {
                        System.out.println("1. Новый                                       " + condition.get(1));
                        System.out.println("2. С пробегом                                  " + condition.get(2));
                        System.out.println("3. Аварийный                                   " + condition.get(3));
                        System.out.println("4. Любое");
                        System.out.println("0. Ок, продолжить");
                        i = in.nextInt();
                        switch (i) {
                            case 1:
                                if (!condition.get(1) || condition.get(1) == null) {
                                    condition.put(1, true);
                                } else if (condition.get(1)) {
                                    condition.put(1, false);
                                }
                                break;
                            case 2:
                                if (!condition.get(2) || condition.get(2) == null) {
                                    condition.put(2, true);
                                } else if (condition.get(2)) {
                                    condition.put(2, false);
                                }
                                break;
                            case 3:
                                if (!condition.get(3) || condition.get(3) == null) {
                                    condition.put(3, true);
                                } else if (condition.get(3)) {
                                    condition.put(3, false);
                                }
                                break;
                            case 4:
                                condition.put(1, false);
                                condition.put(2, false);
                                condition.put(3, false);
                                break;
                        }
                    } while (i != 0);
                    break;
                case 2:
                    do {
                        System.out.println("1. Подходящая валюта для поиска                " + currency);
                        System.out.println("2. Цена автомобиля с                           " + priceFrom);
                        System.out.println("3. Цена автомобиля до                          " + priceBefore);
                        System.out.println("4. Искать автомобиль с возможностью обмена     " + priceAdditional.get(1));
                        System.out.println("5. Искать автомобиль с НДС                     " + priceAdditional.get(2));
                        System.out.println("0. Ок, продолжить");
                        i = in.nextInt();
                        switch (i) {
                            case 1:
                                System.out.println("Возможные варианты");
                                System.out.println("1. BYN");
                                System.out.println("2. USD");
                                System.out.println("3. EUR");
                                i = in.nextInt();
                                switch (i) {
                                    case 1:
                                        currency = "BYN";
                                        break;
                                    case 2:
                                        currency = "USD";
                                        break;
                                    case 3:
                                        currency = "EUR";
                                        break;
                                }
                                break;
                            case 2:
                                System.out.println("Введите с какой цены осуществлять поиск автомоболя ");
                                priceFrom = in.next();
                                break;
                            case 3:
                                System.out.println("Введите до какой цены осуществлять поиск автомоболя ");
                                priceBefore = in.next();
                                break;
                            case 4:
                                if (!priceAdditional.get(1) || priceAdditional.get(1) == null) {
                                    priceAdditional.put(1, true);
                                } else if (priceAdditional.get(1)) {
                                    priceAdditional.put(1, false);
                                }
                                break;
                            case 5:
                                if (!priceAdditional.get(2) || priceAdditional.get(2) == null) {
                                    priceAdditional.put(2, true);
                                } else if (priceAdditional.get(2)) {
                                    priceAdditional.put(2, false);
                                }
                                break;
                        }
                    } while (i != 0);
                    break;
                case 3:
                    do {
                        System.out.println("1. Выбрать марку автомобиля                    " + brand);
                        System.out.println("2. Ввсти марку автомобиля");
                        System.out.println("3. Ввести модель автомобиля                    " + model);
                        System.out.println("4. Ввести поколение (Не работает)");
                        System.out.println("5. Добавить ещё одну марку для поиска (Не работает)");
                        System.out.println("9. Убрать марку");
                        System.out.println("0. Ок, продолжить");
                        i = in.nextInt();
                        switch (i) {
                            case 1:
                                System.out.println("Выберите одну из марок (цыфру возле интересующей вас марки)");
                                System.out.println("1.Volkswagen; 2.BMW; 3.Opel; 4.Ford; 5.Renault; 6.Audi;");
                                System.out.println("7.Mercedes-benz; 8.Peugeot; 9.Citroen; 10.Nissan; 11.Mazda; 12.Toyota.");
                                System.out.println("13. Оставить пустм");
                                i = in.nextInt();
                                switch (i) {
                                    case 1:
                                        brand = "Volkswagen";
                                        break;
                                    case 2:
                                        brand = "BMW";
                                        break;
                                    case 3:
                                        brand = "Opel";
                                        break;
                                    case 4:
                                        brand = "Ford";
                                        break;
                                    case 5:
                                        brand = "Renault";
                                        break;
                                    case 6:
                                        brand = "Audi";
                                        break;
                                    case 7:
                                        brand = "Mercedes-benz";
                                        break;
                                    case 8:
                                        brand = "Peugeot";
                                        break;
                                    case 9:
                                        brand = "Citroen";
                                        break;
                                    case 10:
                                        brand = "Nissan";
                                        break;
                                    case 11:
                                        brand = "Mazda";
                                        break;
                                    case 12:
                                        brand = "Toyota";
                                        break;
                                    case 13:
                                        brand = null;
                                        break;
                                }
                                break;
                            case 2:
                                System.out.println("<-----Введите интересующую вас название марки (Коректное название)----->");
                                brand = in.next();
                                break;
                            case 3:
                                if(brand==null){
                                    System.out.println("Для того чтобы ввести модель нужно сразу ввести марку");
                                    break;
                                }
                                System.out.println("Введите интересующую вас модель " + brand + "(Коректное название)");
                                model = in.next();
                                break;
                            case 4:
                                break;
                            case 5:
                                break;
                            case 9:
                                model = null;
                                break;
                            case 0:
                                break;
                        }
                    } while (i != 0);
                    break;
                case 4:
                    do {
                        System.out.println("Введите желаемый год выпуска для поиска");
                        System.out.println("1. Год выпуска с                                   " + dataFrom);
                        System.out.println("2. Год выпуска до                                  " + dataBefore);
                        System.out.println("0. Ок, продолжить");
                        i = in.nextInt();
                        switch (i) {
                            case 1:
                                System.out.println("Введите год (1890 - 2020)");
                                dataFrom = in.next();
                                break;
                            case 2:
                                System.out.println("Введите год (1890 - 2020)");
                                dataBefore = in.next();
                                break;
                        }
                    } while (i != 0);
                    break;
                case 5:
                    do {
                        System.out.println("1. Седан                                       " + bodyType.get(1));
                        System.out.println("2. Внедорожник                                 " + bodyType.get(2));
                        System.out.println("3. Универсал                                   " + bodyType.get(3));
                        System.out.println("4. Хетчбэк                                     " + bodyType.get(4));
                        System.out.println("5. Лифтбэк                                     " + bodyType.get(5));
                        System.out.println("6. Минивен                                     " + bodyType.get(6));
                        System.out.println("7. Микроавтобус                                " + bodyType.get(7));
                        System.out.println("8. Купе                                        " + bodyType.get(8));
                        System.out.println("9. Фургон                                      " + bodyType.get(9));
                        System.out.println("10. Пикап                                      " + bodyType.get(10));
                        System.out.println("11. Кабриолет                                  " + bodyType.get(11));
                        System.out.println("12. Лимузин                                    " + bodyType.get(12));
                        System.out.println("13. Любое");
                        System.out.println("0. Ок, продолжить");
                        i = in.nextInt();
                        if (i != 0 && i != 13) {
                            if (!bodyType.get(i) || bodyType.get(i) == null) {
                                bodyType.put(i, true);
                            } else if (bodyType.get(i)) {
                                bodyType.put(i, false);
                            }
                        } else if (i == 13) {
                            for (int b = 1; b <= 12; b++) {
                                bodyType.put(b, false);
                            }
                        }
                    } while (i != 0);
                    break;
                case 6:
                    System.out.println("Введде желаемое чимло автомобилей для сохранения");
                    numberCars = in.nextInt();
                    break;
                case 0:
                    i = 0;
                    break;
            }
            System.out.println("Начаем?");
            System.out.println("1.ДА   2.Нет");
            i = in.nextInt();
        } while (i != 1);
        WebDriver driver = new ChromeDriver();
        AutoPage autoPage = new AutoPage(driver);
        autoPage.startProg(condition,priceAdditional,bodyType,currency,priceBefore,priceFrom,brand,model,dataBefore,dataFrom,numberCars);
    }

}
