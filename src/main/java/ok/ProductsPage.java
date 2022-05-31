package ok;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProductsPage {
    ChromeDriver driver;
    //WebDriverWait wait = new WebDriverWait(driver,10);
    public ProductsPage(ChromeDriver driver) {
        this.driver = driver;
    }

    public ProductsPage SearchProducts(String product){
        driver.findElement(By.xpath("//label[@class='label__t53m6']")).sendKeys(product + "\n");
        WebElement explicitWait = (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.presenceOfElementLocated(
                        By.xpath("//span[@class='it_w mr-2x']")));
        return new ProductsPage(driver);
    }

    public ProductsPage SetLowerBound(String lower){
        driver.findElement(By.xpath("//span[@class='it_w mr-2x']")).sendKeys(lower);
        return this;
    }

    public ProductsPage SetUpperBound(String upper){
        driver.findElement(By.xpath("//span[@class='it_w ml-2x']")).sendKeys(upper);
        return this;
    }

    public String GetNameNProduct(int i){
        ProductsElement productsElement = new ProductsElement(driver.findElement(By.xpath("//div[@class='ugrid_cnt']/div[" + i + "]")));
        return productsElement.getName();
    }

}
