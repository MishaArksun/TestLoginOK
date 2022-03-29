package ru.ok;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test1 {
    public static ChromeDriver driver;
    public static LoginPage loginPage;
    public static MainPage mainPage;

    @Test
    public void Test(){
        System.setProperty("webdriver.chrome.driver", "C:\\tehnopolis\\chromedriver_win32\\chromedriver.exe");

        driver = new ChromeDriver();
        driver.get("https://ok.ru/");
        loginPage = new LoginPage(driver);
        mainPage = new MainPage(driver);

        loginPage.login(User.login);
        loginPage.password(User.pass);
        loginPage.button();

        Assert.assertEquals(mainPage.getName(), User.name);
    }
}
