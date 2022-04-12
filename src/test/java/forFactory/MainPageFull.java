package forFactory;

import group.GroupPage;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

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
}
