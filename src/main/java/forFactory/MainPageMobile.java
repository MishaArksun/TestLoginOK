package forFactory;

import group.GroupPage;
import ok.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class MainPageMobile implements MainPage{
    ChromeDriver driver;
    public MainPageMobile(ChromeDriver driver) {
        this.driver = driver;
    }

    @Override
    public String getName() {
        return driver.findElement(By.xpath("//*[@class='l-sidebar_profile_name_main js-text-username']")).getText();
    }

    @Override
    public GroupPage openGroupPage() {
        driver.findElement(By.xpath("//*[@id='sidebar-userAltGroups']")).click();
        return new GroupPage(driver);
    }
    @Override
    public LoginPage exit(){
        driver.findElement(By.className("ucard-mini toolbar_ucard js-toolbar-menu")).click();
        driver.findElement(By.className("//a[@data-l='t,logout']")).click();
        driver.findElement(By.className("//input[@data-l='t,logout']")).click();
        return new LoginPage(driver);
    }
}
