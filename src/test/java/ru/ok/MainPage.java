package ru.ok;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class MainPage {
    ChromeDriver driver;
    public MainPage(ChromeDriver driver) {
        this.driver = driver;
    }

    public String getName(){
        return driver.findElement(By.xpath("//*[@id=\"hook_Block_Navigation\"]/div/div/a[1]/div")).getText();
    }
}
