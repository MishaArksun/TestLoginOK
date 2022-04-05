package ru.ok;

import com.codeborne.selenide.commands.GetName;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class MusicElement {
    WebElement webElement;
    public MusicElement(WebElement webElement){
        this.webElement=webElement;
    }

    public String getName(){
        return webElement.findElement(By.xpath(".//slot[@name='title']/div/a")).getText();
     }

    public String getAuthor(){
        return webElement.findElement(By.xpath(".//a[@class='artist'][@index='0']")).getText();
    }

    public void play(){
        webElement.findElement(By.xpath(".//slot[@name='cover']")).click();
    }

    public void add(){
        webElement.click();
        webElement.findElement(By.xpath(".//slot[@name='controls']/wm-track-add-button")).click();
    }
}
