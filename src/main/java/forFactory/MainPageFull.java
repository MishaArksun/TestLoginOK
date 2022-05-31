package forFactory;

import group.GroupPage;
import ok.LoginPage;
import ok.ProductsPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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

    @Override
    public ProductsPage openProductsPage() {
        driver.findElement(By.xpath("//a[@data-l='t,mall']")).click();
        return new ProductsPage(driver);
    }

    public LoginPage exit(){
        driver.findElement(By.xpath("//*[@class = 'ucard-mini toolbar_ucard js-toolbar-menu']")).click();
        driver.findElement(By.xpath("//a[@data-l='t,logout']")).click();
        WebElement explicitWait = (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.presenceOfElementLocated(
                        By.xpath("//input[@data-l='t,logout']")));
        driver.findElement(By.xpath("//input[@data-l='t,logout']")).click();
        return new LoginPage(driver);
    }
}
