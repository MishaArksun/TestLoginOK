package group;

import forFactory.Factory;
import forFactory.MainPage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.ArrayList;

public class GroupPage {
    ChromeDriver driver;
    public GroupPage(ChromeDriver driver) {
        this.driver = driver;
    }

    public GroupPage addNGroups(int n){
        ArrayList<GroupElement> groupElementList = new ArrayList<GroupElement>();
        int i=1, count = 0;
        while(count != n){
            GroupElement groupElement = new GroupElement(driver.findElement(By.xpath("//div[@class='ugrid_cnt']/div[" + i + "]")));
            if  (!groupElement.checkSub()){
                groupElementList.add(groupElement);
                i++;
                count++;
            }
            else i++;
        }


        for(GroupElement a : groupElementList ){
            System.out.println(a.getName());
            a.add();
        }
        return this;
    }

    public GroupPage exitNGroup(int n){
        for(int i=1; i <= n; i++){
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
            driver.findElement(By.xpath("//*[@class='scroll-slider_item mr-x'][" + i + "]")).click();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
            driver.findElement(By.xpath("//*[@class='dropdown __wide h-mod']")).click();
            driver.findElement(By.xpath("//*[@class='dropdown_n']")).click();
            driver.findElement(By.xpath("//*[@id='toolbar_back_id']")).click();
        }
        return this;
    }

    public int getNumSub(){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        return Integer.parseInt(driver.findElement(By.xpath("//span[@class='portlet_h_count']")).getText());
    }

    public GroupPage openOfficialGroup(){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.findElement(By.xpath("//a[@class='filter_i __without-ico'][@href='/groups/official']")).click();
        return new GroupPage(driver);
    }

    public MainPage goMainPage(){
        driver.findElement(By.xpath("//a[@data-l='t,userMain']")).click();
        return new Factory().get(driver);
    }
    public GroupPage scroll(){
        JavascriptExecutor je = (JavascriptExecutor) driver;
        WebElement element = driver.findElement(By.xpath("//a[@class='filter_i __without-ico __active']"));
        je.executeScript("arguments[0].scrollIntoView(true);", element);
        return this;
    }
    public GroupPage refresh(){
        driver.navigate().refresh();
        return new GroupPage(driver);
    }
}
