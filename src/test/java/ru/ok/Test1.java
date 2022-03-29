package ru.ok;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test1 {
    private ChromeDriver driver;
    private LoginPage loginPage;
    private MainPage mainPage;
    private User user = new User("89229517124", "pevKeg9", "Миша Мельников");

    @Test
    public void Test(){
        System.setProperty("webdriver.chrome.driver", "C:\\tehnopolis\\chromedriver_win32\\chromedriver.exe");

        driver = new ChromeDriver();
        driver.get("https://ok.ru/");

        LoginPage loginPage = new LoginPage(driver);
        MainPage mainPage = loginPage.login(user.login, user.pass);
        Assert.assertEquals(mainPage.getName(), user.name);
    }
}
