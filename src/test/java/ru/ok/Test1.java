package ru.ok;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;
import java.util.ArrayList;

public class Test1 {
    private ChromeDriver driver;
    private LoginPage loginPage;
    private MainPage mainPage;
    private User user = new User("aaa", "aaa", "aaa");
    @Test
    public void Test(){
        System.setProperty("webdriver.chrome.driver", "C:\\tehnopolis\\chromedriver_win32\\chromedriver.exe");

        driver = new ChromeDriver();
        driver.get("https://ok.ru/");

        LoginPage loginPage = new LoginPage(driver);
        MainPage mainPage = loginPage.login(user.login, user.pass);
        Assert.assertEquals(mainPage.getName(), user.name);

        driver.findElement(By.xpath("//*[@id='music_toolbar_button']/div[2]")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.findElement(By.xpath("//*[@id='music_layer']/header/div/div")).click();

        ArrayList<MusicElement> musicElementList = new ArrayList<MusicElement>();

        for(int i=1; i<5; i++){
            musicElementList.add(new MusicElement(driver.findElement(By.xpath("//wm-tracks-list/main/wm-track[" + i + "]"))));
        }

        for(MusicElement a : musicElementList ){
            System.out.println( a.getName());
            a.add();
        }
    }
}

