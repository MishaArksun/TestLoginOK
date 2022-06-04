package group;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

public class GroupElement {
    WebElement webElement;
    private final By nameGroup = By.xpath(".//a[@class='o group-name-link']");
    private final By subGroup = By.xpath(".//*[@class = 'friends-in-group_label']/span");
    private final By addButton = By.xpath(".//*[@class = 'button-pro group-join_btn __small __sec']");

    public GroupElement(WebElement webElement) {
        this.webElement = webElement;
    }

    public String getName() {
        return webElement.findElement(nameGroup).getText();
    }

    public String getSub() {
        return webElement.findElement(subGroup).getText();
    }

    public GroupElement add() {
        webElement.findElement(addButton).click();
        return this;
    }

    public boolean checkSub() {

        try {
            webElement.findElement(addButton);
        } catch (NoSuchElementException e) {
            return true;
        }
        return false;
    }
}
