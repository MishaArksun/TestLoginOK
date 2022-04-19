package forFactory;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.chrome.ChromeDriver;

public class Factory {

    public MainPage get(ChromeDriver driver){
        if (isMobile(driver)){
            return new MainPageMobile(driver);
        } else {
            return new MainPageFull(driver);
        }
    }

    private boolean isMobile(ChromeDriver driver){
        try {
            driver.findElement(By.xpath("//*[@class='l-sidebar_profile_name']"));
        } catch (NoSuchElementException e) {
            return false;
        }
        return true;
    }
}
