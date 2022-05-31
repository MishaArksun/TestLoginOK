package ok;

import forFactory.Factory;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginPage {
    ChromeDriver driver;
    private final By loginBar = By.xpath("//*[@id='field_email']");
    private final By passBar = By.xpath("//*[@id='field_password']");
    private final By loginButton = By.xpath("//*[@class = 'button-pro __wide']");
    public LoginPage(ChromeDriver driver) {
        this.driver = driver;
    }

    public void login(String log, String pas){
        driver.findElement(loginBar).sendKeys(log);
        driver.findElement(passBar).sendKeys(pas);
        driver.findElement(loginButton).click();
        new Factory().get(driver);
    }
}
