package ru.ok;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginPage {
    ChromeDriver driver;
    public LoginPage(ChromeDriver driver) {
        this.driver = driver;
    }

    public void login(String log){
        driver.findElement(By.xpath("//*[@id=\'field_email\']")).sendKeys(log);
    }

    public void password(String pas){
        driver.findElement(By.xpath("//*[@id=\'field_password\']")).sendKeys(pas);
    }

    public void button(){
        driver.findElement(By.xpath("//*[@class='login-form-actions']//*[@type]")).click();
    }
}
