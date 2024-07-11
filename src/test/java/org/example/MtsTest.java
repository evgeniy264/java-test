package org.example;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.List;

public class MtsTest {
    public static WebDriver driver;

    @BeforeAll
    public static void setUp() {
        System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver");
        driver = new ChromeDriver();
        driver.get("https://www.mts.by/");
        WebDriverWait wait = new WebDriverWait(driver, 20);
        WebElement button= wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='cookie__buttons']/button[@id='cookie-agree']")));
        //Нажатие кнопки для принятия Coockies.
        button.click();
    }

    @Test
    @DisplayName("Тест на соответствие названия")
    public void nameTest(){
        String expectedText = "Онлайн пополнение без комиссии";
        String actualText = driver.findElement(By.xpath("//div[@class='pay__wrapper']/h2")).getText().replaceAll("\\n", " ");
        Assertions.assertEquals(expectedText,actualText);
        System.out.println("Указанное название соответствует текущему названию блока.");
    }

    @Test
    @DisplayName("Тест на наличие логотипов платежных систем")
    public void imgTest(){
        List<WebElement> images = driver.findElements(By.xpath("//div[@class='pay__partners']/descendant::img"));
        for(int i=0;i<images.size();i++){
            String url = images.get(i).getAttribute("src");
            Assertions.assertTrue(url != null,"URL картинок пусты");
            double height=images.get(i).getSize().height;
            double width=images.get(i).getSize().width;
            Assertions.assertTrue(height>0);
            System.out.println("Высота картинки "+url+" равна "+height);
            Assertions.assertTrue(width>0);
            System.out.println("Ширина картинки "+url+" равна "+width);
        }
    }

    @Test
    @DisplayName("Тест на проверку работы ссылки")
    public void linkTest(){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement button= wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Подробнее о сервисе")));
        String urlButton= button.getAttribute("href");
        button.click();
        Assertions.assertEquals(driver.getCurrentUrl(),urlButton);
        System.out.println("Кнопка кликабельна. Адрес ссылки соответствует открываемой странице.");
        driver.navigate().back();
    }

    @Test
    @DisplayName("Тест на проверку работы кнопки")
    public void submitTest(){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement buttonSubmit= wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//form[@id='pay-connection']")));
        //Заполняем поле для телефона
        WebElement inputPhone = driver.findElement(By.xpath("//input[@id='connection-phone']"));
        inputPhone.sendKeys("297777777");
        //Заполняем поле для суммы
        WebElement inputSum = driver.findElement(By.xpath("//input[@id='connection-sum']"));
        inputSum.sendKeys("1");
        //Нажимаем кнопку "Продолжить"
        buttonSubmit.click();
        System.out.println("Кнопка работает должным образом");
    }

    @AfterAll
    public static void tearDown() {
        driver.quit();
    }
}


