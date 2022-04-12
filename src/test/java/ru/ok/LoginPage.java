package ru.ok;

import forFactory.MainPage;
import forFactory.Factory;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginPage {
    ChromeDriver driver;
    public LoginPage(ChromeDriver driver) {
        this.driver = driver;
    }

    public MainPage login(String log, String pas){
        driver.findElement(By.xpath("//*[@id='field_email']")).sendKeys(log);
        driver.findElement(By.xpath("//*[@id='field_password']")).sendKeys(pas);
        driver.findElement(By.xpath("//*[@class='login-form-actions']//*[@type]")).click();
        return new Factory().get(driver);
    }

    public void goCantLogin(){
        driver.findElement(By.xpath("//a[@data-l='t,restore']")).click();
    }
}
