package forFactory;

import group.GroupPage;
import ok.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class MainPageFull implements MainPage {
    ChromeDriver driver;
    public MainPageFull(ChromeDriver driver) {
        this.driver = driver;
    }

    public String getName(){
        return driver.findElement(By.xpath("//*[@class='tico ellip']")).getText();
    }

    public GroupPage openGroupPage(){
        driver.findElement(By.xpath("//a[@data-l='t,userAltGroup']")).click();
        return new GroupPage(driver);
    }
    public LoginPage exit(){
        driver.findElement(By.xpath("//*[@class = 'ucard-mini toolbar_ucard js-toolbar-menu']")).click();
        driver.findElement(By.xpath("//a[@data-l='t,logout']")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.findElement(By.xpath("//input[@data-l='t,logout']")).click();
        return new LoginPage(driver);
    }
}
