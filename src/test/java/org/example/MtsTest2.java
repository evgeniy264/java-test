package org.example;

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


public class MtsTest2 {
    public static WebDriver driver;

    @BeforeAll
    public static void setUp() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
        driver = new ChromeDriver();
        driver.get("https://www.mts.by/");
        WebDriverWait wait = new WebDriverWait(driver, 20);
        WebElement button = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='cookie__buttons']/button[@id='cookie-agree']")));
        //Нажатие кнопки для принятия Coockies.
        button.click();
    }

    @Test
    @DisplayName("Услуги связи: тест надписей в полях")
    public void inputTestConnection() {
        WebElement selectElement = driver.findElement(By.xpath("//select[@id='pay']"));
        WebElement selectElement2 = driver.findElement(By.xpath("//div[@class='select']/descendant::p[contains(text(),'Услуги связи')]"));

        Actions builder = new Actions(driver);
        builder
                .click(selectElement)
                .click(selectElement2)
                .build()
                .perform();

        List<WebElement> elementsConnection = driver.findElements(By.xpath("//form[@id='pay-connection']/descendant::input"));
        LinkedList<String> expectedText = new LinkedList<>();
        expectedText.add(0, "Номер телефона");
        expectedText.add(1, "Сумма");
        expectedText.add(2, "E-mail для отправки чека");
        LinkedList<String> actualText = new LinkedList<>();
        for (WebElement element : elementsConnection) {
            actualText.add(element.getAttribute("placeholder"));
        }
        Assertions.assertTrue(actualText.equals(expectedText));
        System.out.println("Порядок надписей соответствует порядку полей, значения надписей соответствуют");
    }

    @Test
    @DisplayName("Домашний интернет: тест надписей в полях")
    public void inputTestInternet() {
        WebElement selectElement = driver.findElement(By.xpath("//select[@id='pay']"));
        WebElement selectElement2 = driver.findElement(By.xpath("//div[@class='select']/descendant::p[contains(text(),'Домашний интернет')]"));

        Actions builder = new Actions(driver);
        builder
                .click(selectElement)
                .click(selectElement2)
                .build()
                .perform();

        List<WebElement> elementsInternet = driver.findElements(By.xpath("//form[@id='pay-internet']/descendant::input"));
        LinkedList<String> expectedText = new LinkedList<>();
        expectedText.add(0, "Номер абонента");
        expectedText.add(1, "Сумма");
        expectedText.add(2, "E-mail для отправки чека");
        LinkedList<String> actualText = new LinkedList<>();
        for (WebElement element : elementsInternet) {
            actualText.add(element.getAttribute("placeholder"));
        }
        Assertions.assertTrue(actualText.equals(expectedText));
        System.out.println("Порядок надписей соответствует порядку полей, значения надписей соответствуют");
    }

    @Test
    @DisplayName("Рассрочка: тест надписей в полях")
    public void inputTestInstalment() {
        WebElement selectElement = driver.findElement(By.xpath("//select[@id='pay']"));
        WebElement selectElement2 = driver.findElement(By.xpath("//div[@class='select']/descendant::p[contains(text(),'Рассрочка')]"));

        Actions builder = new Actions(driver);
        builder
                .click(selectElement)
                .click(selectElement2)
                .build()
                .perform();

        List<WebElement> elementsInstalment = driver.findElements(By.xpath("//form[@id='pay-instalment']/descendant::input"));
        LinkedList<String> expectedText = new LinkedList<>();
        expectedText.add(0, "Номер счета на 44");
        expectedText.add(1, "Сумма");
        expectedText.add(2, "E-mail для отправки чека");
        LinkedList<String> actualText = new LinkedList<>();
        for (WebElement element : elementsInstalment) {
            actualText.add(element.getAttribute("placeholder"));
        }
        Assertions.assertTrue(actualText.equals(expectedText));
        System.out.println("Порядок надписей соответствует порядку полей, значения надписей соответствуют");
    }

    @Test
    @DisplayName("Задолженность: тест надписей в полях")
    public void inputTestArrears() {
        WebElement selectElement = driver.findElement(By.xpath("//select[@id='pay']"));
        WebElement selectElement2 = driver.findElement(By.xpath("//div[@class='select']/descendant::p[contains(text(),'Задолженность')]"));

        Actions builder = new Actions(driver);
        builder
                .click(selectElement)
                .click(selectElement2)
                .build()
                .perform();

        List<WebElement> elementsArrears = driver.findElements(By.xpath("//form[@id='pay-arrears']/descendant::input"));
        LinkedList<String> expectedText = new LinkedList<>();
        expectedText.add(0, "Номер счета на 2073");
        expectedText.add(1, "Сумма");
        expectedText.add(2, "E-mail для отправки чека");
        LinkedList<String> actualText = new LinkedList<>();
        for (WebElement element : elementsArrears) {
            actualText.add(element.getAttribute("placeholder"));
        }
        Assertions.assertTrue(actualText.equals(expectedText));
        System.out.println("Порядок надписей соответствует порядку полей, значения надписей соответствуют");
    }

    @Test
    @DisplayName("Проверка фрейма")
    public void TestConnection() {
        String sum = "1";
        String phone = "297777777";
        WebElement selectElement = driver.findElement(By.xpath("//select[@id='pay']"));
        WebElement selectElement2 = driver.findElement(By.xpath("//div[@class='select']/descendant::p[contains(text(),'Услуги связи')]"));

        Actions builder = new Actions(driver);
        builder
                .click(selectElement)
                .click(selectElement2)
                .build()
                .perform();


        //Заполняем поле для телефона
        WebElement inputPhone = driver.findElement(By.xpath("//input[@id='connection-phone']"));
        inputPhone.sendKeys(phone);
        //Заполняем поле для суммы
        WebElement inputSum = driver.findElement(By.xpath("//input[@id='connection-sum']"));
        inputSum.sendKeys(sum);
        //Нажимаем кнопку "Продолжить"
        WebElement buttonSubmit = driver.findElement(By.xpath("//form[@id='pay-connection']/button"));
        buttonSubmit.click();
        //Задержка для фрейма
        WebDriverWait wait = new WebDriverWait(driver, 20);
        WebElement frameElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//iframe[@class='bepaid-iframe']")));
        driver.switchTo().frame(frameElement);

        //Проверяем корректность отображения суммы
        List<WebElement> elementsSum = driver.findElements(By.xpath("//app-payment-container/descendant::*[contains(text(),'" + sum + "')]"));
        for (WebElement elementSum : elementsSum) {
            String digitText = elementSum.getAttribute("innerHTML").replaceAll("[^.\\d]", "");
            Assertions.assertTrue(Double.parseDouble(digitText) == Double.parseDouble(sum));
            System.out.println("Значение суммы равно заданному значению: " + elementSum.getAttribute("innerHTML"));
        }

        //Проверяем корректность отображения номера телефона
        WebElement elementPhone = driver.findElement(By.xpath("//app-payment-container/descendant::*[contains(text(),'" + phone + "')]"));
        String phoneText = elementPhone.getAttribute("innerHTML").replaceAll("[^.\\d]", "");
        Assertions.assertTrue(phoneText.equals("375" + phone));
        System.out.println("Значение номера телефона совпадает с заданным: " + phoneText);

        //Проверяем корректность отображения надписей в незаполненных полях
        List<WebElement> elementsInput = driver.findElements(By.xpath("//app-payment-container/descendant::input/following-sibling::label"));
        LinkedList<String> expectedText = new LinkedList<>();
        expectedText.add(0, "Номер карты");
        expectedText.add(1, "Срок действия");
        expectedText.add(2, "CVC");
        expectedText.add(3, "Имя держателя (как на карте)");
        LinkedList<String> actualText = new LinkedList<>();
        for (WebElement element : elementsInput) {
            actualText.add(element.getAttribute("innerHTML"));
        }
        Assertions.assertTrue(actualText.equals(expectedText));
        System.out.println("Порядок надписей соответствует порядку полей, значения надписей соответствуют");

        //Проверяем наличие иконок платежных систем
        List<WebElement> images = driver.findElements(By.xpath("//app-payment-container/descendant::input[@id='cc-number']/parent::*/following::img"));
        for (int i = 0; i < images.size(); i++) {
            String url = images.get(i).getAttribute("src");
            if (url != null) {
                double height = images.get(i).getSize().height;
                double width = images.get(i).getSize().width;
                Assertions.assertTrue(height > 0);
                System.out.println("Высота картинки " + url + " равна " + height);
                Assertions.assertTrue(width > 0);
                System.out.println("Ширина картинки " + url + " равна " + width);
            } else {
                System.out.println("URL картинок пусты");
            }
        }
    }

    @AfterAll
    public static void tearDown() {
        driver.quit();
    }
}
