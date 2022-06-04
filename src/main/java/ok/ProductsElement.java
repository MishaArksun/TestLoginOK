package ok;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ProductsElement {
    WebElement webElement;
    private final By nameProducts = By.xpath("//a[@class='filter_i __without-ico __active']");

    public ProductsElement(WebElement webElement) {
        this.webElement = webElement;
    }

    public String getName() {
        return webElement.findElement(nameProducts).getText();
    }
}
