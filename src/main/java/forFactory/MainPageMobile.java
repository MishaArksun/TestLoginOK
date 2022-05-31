package forFactory;

import group.GroupPage;
import ok.LoginPage;
import ok.ProductsPage;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class MainPageMobile implements MainPage{
    ChromeDriver driver;
    private final By nameMobile = By.xpath("//*[@class='l-sidebar_profile_name_main js-text-username']");
    private final By iconGroup = By.xpath("//*[@id='sidebar-userAltGroups']");
    private final By iconProducts = By.xpath("//*[@id='sidebar-mall']");
    private final By exitButton = By.xpath("//li[@id ='sidebar-logoff']");
    public MainPageMobile(ChromeDriver driver) {
        this.driver = driver;
    }

    @Override
    public String getName() {
        return driver.findElement(nameMobile).getText();
    }

    @Override
    public GroupPage openGroupPage() {
        driver.findElement(iconGroup).click();
        return new GroupPage(driver);
    }

    @Override
    public ProductsPage openProductsPage() {
        driver.findElement(iconProducts).click();
        return new ProductsPage(driver);
    }

    @Override
    public LoginPage exit(){
        driver.findElement(exitButton).click();
        return new LoginPage(driver);
    }
}
