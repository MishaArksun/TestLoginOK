package group;

import forFactory.Factory;
import forFactory.MainPage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import static com.codeborne.selenide.Configuration.timeout;

public class GroupPage {
    ChromeDriver driver;
    private final By inGroupButton = By.xpath("//*[@class='dropdown __wide h-mod']");
    private final By exitGroupButton = By.xpath("//*[@class='dropdown_n']");
    private final By backButton = By.xpath("//*[@id='toolbar_back_id']");
    private final By countGroup = By.xpath("//span[@class='portlet_h_count']");
    private final By offGroupButton = By.xpath("//a[@class='filter_i __without-ico'][@href='/groups/official']");
    private final By goMain = By.xpath("//a[@data-l='t,userMain']");
    private final By offGroup = By.xpath("//a[@class='filter_i __without-ico __active']");
    private final By joinButton = By.xpath("(//*[@class='button-pro group-join_btn __small __sec'])[1]");

    public GroupPage(ChromeDriver driver) {
        this.driver = driver;
    }

    public GroupPage addNGroups(int n) {
        for (int i = 1; i < n + 1; i++) {
            new WebDriverWait(driver, timeout)
                    .ignoring(StaleElementReferenceException.class)
                    .until(ExpectedConditions.elementToBeClickable(joinButton));
            driver.findElement(joinButton).click();
            refresh();
        }
        return this;
    }

    public GroupPage exitNGroup(int n) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        for (int i = 1; i <= n; i++) {
            wait.until(ExpectedConditions.presenceOfElementLocated
                    (By.xpath("//*[@class='scroll-slider_item mr-x'][" + i + "]")));
            driver.findElement(By.xpath("//*[@class='scroll-slider_item mr-x'][" + i + "]")).click();
            wait.until(ExpectedConditions.presenceOfElementLocated(inGroupButton));
            driver.findElement(inGroupButton).click();
            driver.findElement(exitGroupButton).click();
            driver.findElement(backButton).click();
        }
        return this;
    }

    public int getNumSub() {
        new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(countGroup));
        return Integer.parseInt(driver.findElement(countGroup).getText());
    }

    public GroupPage openOfficialGroup() {
        new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(offGroupButton));
        driver.findElement(offGroupButton).click();
        return new GroupPage(driver);
    }

    public MainPage goMainPage() {
        driver.findElement(goMain).click();
        return new Factory().get(driver);
    }

    public GroupPage scroll() {
        JavascriptExecutor je = (JavascriptExecutor) driver;
        WebElement element = driver.findElement(offGroup);
        je.executeScript("arguments[0].scrollIntoView(true);", element);
        return this;
    }

    public GroupPage refresh() {
        driver.navigate().refresh();
        return new GroupPage(driver);
    }
}
