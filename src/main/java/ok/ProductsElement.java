package ok;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ProductsElement {
    WebElement webElement;
    public ProductsElement(WebElement webElement){
        this.webElement=webElement;
    }

    public String getName(){
        return webElement.findElement(By.xpath(".//*[@class='mall-title __item lp']")).getText();
    }
}
