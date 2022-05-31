package group;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

public class GroupElement {
    WebElement webElement;
    public GroupElement(WebElement webElement){
        this.webElement=webElement;
    }

    public String getName(){
        return webElement.findElement(By.xpath(".//div[@class='caption']/div/a")).getText();
    }

    public String getSub(){
        return webElement.findElement(By.xpath(".//div[@class='caption']/div[2]//span")).getText();
    }

    public GroupElement add(){
        webElement.findElement(By.xpath(".//div[@class='caption']/div[3]//a")).click();
        return this;
    }

    public boolean checkSub(){

        try {
            webElement.findElement(By.xpath(".//div[@class='caption']/div[3]//a"));
        } catch (NoSuchElementException e) {
            return true;
        }
        return false;
    }
}
