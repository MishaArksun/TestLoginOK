package forFactory;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.chrome.ChromeDriver;

public class Factory {
    private final By nameInMobile = By.xpath("//*[@class='l-sidebar_profile_name']");
    public MainPage get(ChromeDriver driver){
        if (isMobile(driver)){
            return new MainPageMobile(driver);
        } else {
            return new MainPageFull(driver);
        }
    }

    private boolean isMobile(ChromeDriver driver){
        try {
            driver.findElement(nameInMobile);
        } catch (NoSuchElementException e) {
            return false;
        }
        return true;
    }
}
