package org.example;

import io.qameta.allure.*;

import org.junit.jupiter.api.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.LinkedList;
import java.util.List;

import static io.qameta.allure.SeverityLevel.CRITICAL;

public class Mts2Test {
    public static WebDriver driver;

    @BeforeEach
    @Step("Запуск сайта")
    public void setUp() {
        if (driver == null) {
            Allure.step("Вход на сайт 'https://www.mts.by/'", () -> {
                System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
                driver = new ChromeDriver();
                driver.get("https://www.mts.by/");
            });
            Allure.step("Нажатие на кнопку для принятия 'Coockies'", () -> {
                WebDriverWait wait = new WebDriverWait(driver, 20);
                WebElement button = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='cookie__buttons']/button[@id='cookie-agree']")));
                button.click();
            });
        }
    }

    @Test
    @DisplayName("Услуги связи: тест надписей в полях")
    @Description("Проверка соответствия надписей в незаполненных полях ввода для варианта оплаты услуг: услуги связи")
    @Tag("Input")
    @Tag("Connection")
    @Severity(CRITICAL)
    @AllureId("1")
    @Link(name = "Сайт", url = "https://www.mts.by/")
    public void inputTestConnection() {
        Allure.label("parentSuite", "Тесты для проверок на главной странице");
        Allure.label("subSuite", "Тесты для проверок соответствия надписей в незаполненных полях");
        Allure.step("Поиск варианта оплаты 'Услуги связи' и его выбор", () -> {
            WebElement selectElement = driver.findElement(By.xpath("//select[@id='pay']"));
            WebElement selectElement2 = driver.findElement(By.xpath("//div[@class='select']/descendant::p[contains(text(),'Услуги связи')]"));
            openSelect(selectElement, selectElement2);
        });


        Allure.step("Сравнение ожидаемых надписей незаполненных полей ввода и имеющихся надписей", () -> {
            List<WebElement> elementsConnection = driver.findElements(By.xpath("//form[@id='pay-connection']/descendant::input"));

            LinkedList<String> expectedText = new LinkedList<>();
            LinkedList<String> actualText = new LinkedList<>();

            Allure.step("Создание списка ожидаемых надписей незаполненных полей ввода", () -> {

                expectedText.add(0, "Номер телефона");
                expectedText.add(1, "Сумма");
                expectedText.add(2, "E-mail для отправки чека");
            });
            Allure.step("Создание списка имеющихся надписей незаполненных полей ввода", () -> {

                for (WebElement element : elementsConnection) {
                    actualText.add(element.getAttribute("placeholder"));
                }
            });
            Allure.step("Сравнение имеющихся надписей и ожидаемых", () -> {
                Assertions.assertTrue(actualText.equals(expectedText));
                System.out.println("Порядок надписей соответствует порядку полей, значения надписей соответствуют");
            });
        });
    }


    @Test
    @DisplayName("Домашний интернет: тест надписей в полях")
    @Description("Проверка соответствия надписей в незаполненных полях ввода для варианта оплаты услуг: домашний интернет")
    @Tag("Input")
    @Tag("Internet")
    @Severity(CRITICAL)
    @AllureId("2")
    @Link(name = "Сайт", url = "https://www.mts.by/")
    public void inputTestInternet() {
        Allure.label("parentSuite", "Тесты для проверок на главной странице");
        Allure.label("subSuite", "Тесты для проверок соответствия надписей в незаполненных полях");
        Allure.step("Поиск варианта оплаты 'Домашний интернет' и его выбор", () -> {
            WebElement selectElement = driver.findElement(By.xpath("//select[@id='pay']"));
            WebElement selectElement2 = driver.findElement(By.xpath("//div[@class='select']/descendant::p[contains(text(),'Домашний интернет')]"));
            openSelect(selectElement, selectElement2);
        });

        Allure.step("Сравнение ожидаемых надписей незаполненных полей ввода и имеющихся надписей", () -> {
            List<WebElement> elementsInternet = driver.findElements(By.xpath("//form[@id='pay-internet']/descendant::input"));

            LinkedList<String> expectedText = new LinkedList<>();
            LinkedList<String> actualText = new LinkedList<>();
            Allure.step("Создание списка ожидаемых надписей незаполненных полей ввода", () -> {
                expectedText.add(0, "Номер абонента");
                expectedText.add(1, "Сумма");
                expectedText.add(2, "E-mail для отправки чека");
            });
            Allure.step("Создание списка имеющихся надписей незаполненных полей ввода", () -> {
                for (WebElement element : elementsInternet) {
                    actualText.add(element.getAttribute("placeholder"));
                }
            });
            Allure.step("Сравнение имеющихся надписей и ожидаемых", () -> {
                Assertions.assertTrue(actualText.equals(expectedText));
                System.out.println("Порядок надписей соответствует порядку полей, значения надписей соответствуют");
            });
        });
    }

    @Test
    @DisplayName("Рассрочка: тест надписей в полях")
    @Description("Проверка соответствия надписей в незаполненных полях ввода для варианта оплаты услуг: рассрочка")
    @Tag("Input")
    @Tag("Instalment")
    @Severity(CRITICAL)
    @AllureId("3")
    @Link(name = "Сайт", url = "https://www.mts.by/")
    public void inputTestInstalment() {
        Allure.label("parentSuite", "Тесты для проверок на главной странице");
        Allure.label("subSuite", "Тесты для проверок соответствия надписей в незаполненных полях");

        Allure.step("Поиск варианта оплаты 'Рассрочка' и его выбор", () -> {
            WebElement selectElement = driver.findElement(By.xpath("//select[@id='pay']"));
            WebElement selectElement2 = driver.findElement(By.xpath("//div[@class='select']/descendant::p[contains(text(),'Рассрочка')]"));
            openSelect(selectElement, selectElement2);
        });

        Allure.step("Сравнение ожидаемых надписей незаполненных полей ввода и имеющихся надписей", () -> {
            List<WebElement> elementsInstalment = driver.findElements(By.xpath("//form[@id='pay-instalment']/descendant::input"));
            LinkedList<String> expectedText = new LinkedList<>();
            LinkedList<String> actualText = new LinkedList<>();
            Allure.step("Создание списка ожидаемых надписей незаполненных полей ввода", () -> {
                expectedText.add(0, "Номер счета на 44");
                expectedText.add(1, "Сумма");
                expectedText.add(2, "E-mail для отправки чека");
            });
            Allure.step("Создание списка имеющихся надписей незаполненных полей ввода", () -> {
                for (WebElement element : elementsInstalment) {
                    actualText.add(element.getAttribute("placeholder"));
                }
            });
            Allure.step("Сравнение имеющихся надписей и ожидаемых", () -> {
                Assertions.assertTrue(actualText.equals(expectedText));
                System.out.println("Порядок надписей соответствует порядку полей, значения надписей соответствуют");
            });
        });
    }

    @Test
    @DisplayName("Задолженность: тест надписей в полях")
    @Description("Проверка соответствия надписей в незаполненных полях ввода для варианта оплаты услуг: задолженность")
    @Tag("Input")
    @Tag("Arrears")
    @Severity(CRITICAL)
    @AllureId("4")
    @Link(name = "Сайт", url = "https://www.mts.by/")
    public void inputTestArrears() {
        Allure.label("parentSuite", "Тесты для проверок на главной странице");
        Allure.label("subSuite", "Тесты для проверок соответствия надписей в незаполненных полях");

        Allure.step("Поиск варианта оплаты 'Задолженность' и его выбор", () -> {
            WebElement selectElement = driver.findElement(By.xpath("//select[@id='pay']"));
            WebElement selectElement2 = driver.findElement(By.xpath("//div[@class='select']/descendant::p[contains(text(),'Задолженность')]"));
            openSelect(selectElement, selectElement2);
        });

        Allure.step("Сравнение ожидаемых надписей незаполненных полей ввода и имеющихся надписей", () -> {
            List<WebElement> elementsArrears = driver.findElements(By.xpath("//form[@id='pay-arrears']/descendant::input"));
            LinkedList<String> expectedText = new LinkedList<>();
            LinkedList<String> actualText = new LinkedList<>();
            Allure.step("Создание списка ожидаемых надписей незаполненных полей ввода", () -> {
                expectedText.add(0, "Номер счета на 2073");
                expectedText.add(1, "Сумма");
                expectedText.add(2, "E-mail для отправки чека");
            });
            Allure.step("Создание списка имеющихся надписей незаполненных полей ввода", () -> {
                for (WebElement element : elementsArrears) {
                    actualText.add(element.getAttribute("placeholder"));
                }
            });
            Allure.step("Сравнение имеющихся надписей и ожидаемых", () -> {
                Assertions.assertTrue(actualText.equals(expectedText));
                System.out.println("Порядок надписей соответствует порядку полей, значения надписей соответствуют");
            });
        });
    }

    @Test
    @DisplayName("Проверка фрейма")
    @Description("Для фрейма в варианте 'Услуги связи' проверка корректности отображения суммы и надписей в незаполненных полях ввода")
    @Tag("Input")
    @Tag("Frame")
    @Severity(CRITICAL)
    @AllureId("5")
    @Link(name = "Сайт", url = "https://www.mts.by/")
    public void TestConnection() {
        Allure.label("parentSuite", "Тесты для проверок фрейма");
        Allure.label("subSuite", "Тесты для проверок соответствия надписей в незаполненных полях");
        String sum = "1";
        String phone = "297777777";
        Allure.step("Поиск варианта оплаты 'Услуги связи' и его выбор", () -> {
            WebElement selectElement = driver.findElement(By.xpath("//select[@id='pay']"));
            WebElement selectElement2 = driver.findElement(By.xpath("//div[@class='select']/descendant::p[contains(text(),'Услуги связи')]"));
            openSelect(selectElement, selectElement2);
        });

        Allure.step("Отправка значений полей формы для варианта 'Услуги связи'", () -> {
            Allure.step("Заполнение поля 'Телефон'", () -> {
                WebElement inputPhone = driver.findElement(By.xpath("//input[@id='connection-phone']"));
                inputPhone.sendKeys(phone);
            });
            Allure.step("Заполнение поля 'Сумма'", () -> {
                WebElement inputSum = driver.findElement(By.xpath("//input[@id='connection-sum']"));
                inputSum.sendKeys(sum);
            });
            Allure.step("Нажатие кнопки 'Продолжить'", () -> {
                WebElement buttonSubmit = driver.findElement(By.xpath("//form[@id='pay-connection']/button"));
                buttonSubmit.click();
            });

            Allure.step("Переход к окну фрейма", () -> {
                WebDriverWait wait = new WebDriverWait(driver, 20);
                WebElement frameElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//iframe[@class='bepaid-iframe']")));
                driver.switchTo().frame(frameElement);
            });
        });

        Allure.step("Проверка корректности отображения суммы", () -> {
            List<WebElement> elementsSum = driver.findElements(By.xpath("//app-payment-container/descendant::*[contains(text(),'" + sum + "')]"));
            for (WebElement elementSum : elementsSum) {
                String digitText = elementSum.getAttribute("innerHTML").replaceAll("[^.\\d]", "");
                Assertions.assertTrue(Double.parseDouble(digitText) == Double.parseDouble(sum));
                System.out.println("Значение суммы равно заданному значению: " + elementSum.getAttribute("innerHTML"));
            }
        });

        Allure.step("Проверка корректности отображения номера телефона", () -> {
            WebElement elementPhone = driver.findElement(By.xpath("//app-payment-container/descendant::*[contains(text(),'" + phone + "')]"));
            String phoneText = elementPhone.getAttribute("innerHTML").replaceAll("[^.\\d]", "");
            Assertions.assertTrue(phoneText.equals("375" + phone));
            System.out.println("Значение номера телефона совпадает с заданным: " + phoneText);
        });

        Allure.step("Проверка корректности отображения надписей в незаполненных полях", () -> {
            List<WebElement> elementsInput = driver.findElements(By.xpath("//app-payment-container/descendant::input/following-sibling::label"));
            LinkedList<String> expectedText = new LinkedList<>();
            LinkedList<String> actualText = new LinkedList<>();
            Allure.step("Создание списка ожидаемых надписей незаполненных полей ввода", () -> {
                expectedText.add(0, "Номер карты");
                expectedText.add(1, "Срок действия");
                expectedText.add(2, "CVC");
                expectedText.add(3, "Имя держателя (как на карте)");
            });
            Allure.step("Создание списка имеющихся надписей незаполненных полей ввода", () -> {
                for (WebElement element : elementsInput) {
                    actualText.add(element.getAttribute("innerHTML"));
                }
            });
            Allure.step("Сравнение имеющихся надписей и ожидаемых", () -> {
                Assertions.assertTrue(actualText.equals(expectedText));
                System.out.println("Порядок надписей соответствует порядку полей, значения надписей соответствуют");
            });
        });

        Allure.step("Проверка наличия иконок платежных систем", () -> {
            List<WebElement> images = driver.findElements(By.xpath("//app-payment-container/descendant::input[@id='cc-number']/parent::*/following::img"));
            Allure.step("Проверка наличия url для скачивания картинок", () -> {
                for (int i = 0; i < images.size(); i++) {
                    String url = images.get(i).getAttribute("src");
                    Assertions.assertTrue(url != null, "URL картинок пусты");
                }
            });
            Allure.step("Проверка размеров картинок", () -> {
                for (int i = 0; i < images.size(); i++) {
                    double height = images.get(i).getSize().height;
                    double width = images.get(i).getSize().width;
                    Assertions.assertTrue(height > 0);
                    System.out.println("Высота картинки " + i + " равна " + height);
                    Assertions.assertTrue(width > 0);
                    System.out.println("Ширина картинки " + i + " равна " + width);
                }
            });
        });
    }

    @AfterAll
    public static void tearDown() {
        driver.quit();
    }

    @Step("Выбор варианта оплаты услуг")
    void openSelect(WebElement selectElement, WebElement selectElement2) {
        Actions builder = new Actions(driver);
        builder
                .click(selectElement)
                .click(selectElement2)
                .build()
                .perform();
    }
}
