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
    private final By nameFull = By.xpath("//*[@class='tico ellip']");
    private final By iconGroup = By.xpath("//a[@data-l='t,userAltGroup']");
    private final By iconProducts = By.xpath("//a[@data-l='t,mall']");
    private final By iconProfile  = By.xpath("//*[@class = 'ucard-mini toolbar_ucard js-toolbar-menu']");
    private final By exitButton = By.xpath("//a[@data-l='t,logout']");
    private final By exitButtonInWindow = By.xpath("//input[@data-l='t,logout']");
    public MainPageFull(ChromeDriver driver) {
        this.driver = driver;
    }

    public String getName(){
        return driver.findElement(nameFull).getText();
    }

    public GroupPage openGroupPage(){
        driver.findElement(iconGroup).click();
        return new GroupPage(driver);
    }

    @Override
    public ProductsPage openProductsPage() {
        driver.findElement(iconProducts).click();
        return new ProductsPage(driver);
    }

    public LoginPage exit(){
        driver.findElement(iconProfile).click();
        driver.findElement(exitButton).click();
        new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(exitButton));
        driver.findElement(exitButtonInWindow).click();
        return new LoginPage(driver);
    }
}
