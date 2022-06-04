package ok;

import forFactory.Factory;
import forFactory.MainPage;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
public class ProductsPage {
    ChromeDriver driver;
    private final By searchBar = By.xpath("//label[@class='label__t53m6']");
    private final By lowerButton = By.xpath("//span[@class='it_w mr-2x']");
    private final By upperButton = By.xpath("//span[@class='it_w ml-2x']");
    private final By goMain = By.xpath("//*[@id = 'toolbar_logo_id']");
    public ProductsPage(ChromeDriver driver) {
        this.driver = driver;
    }

    public ProductsPage SearchProducts(String product){
        driver.findElement(searchBar).sendKeys(product + "\n");
        new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(searchBar));
        return new ProductsPage(driver);
    }

    public ProductsPage SetLowerBound(String lower){
        driver.findElement(lowerButton).sendKeys(lower);
        return this;
    }

    public ProductsPage SetUpperBound(String upper){
        driver.findElement(upperButton).sendKeys(upper);
        return this;
    }

    public String GetNameNProduct(int i){
        ProductsElement productsElement = new ProductsElement(driver.findElement(By.xpath("//div[@class='ugrid_cnt']/div[" + i + "]")));
        return productsElement.getName();
    }

    public MainPage goMainPage(){
        driver.findElement(goMain).click();
        return new Factory().get(driver);
    }

}
