package ru.ok;

import forFactory.Factory;
import group.GroupPage;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestOKru {
    private ChromeDriver driver;
    private LoginPage loginPage;
    //private MainPageFull mainPage;
    private final User user = new User("aaa", "bbb", "ccc");

    @Test
    public void Test(){
        System.setProperty("webdriver.chrome.driver", "C:\\tehnopolis\\chromedriver_win32\\chromedriver.exe");

        driver = new ChromeDriver();
        driver.get("https://ok.ru/");
        int n = 2;
        LoginPage loginPage = new LoginPage(driver);
        String userNameFromTest = loginPage
                .login(user.login, user.pass)
                .getName();

        GroupPage groupPage = new Factory()
                .get(driver)
                .openGroupPage();

        int numSubBefore = groupPage.getNumSub();
        System.out.print(numSubBefore);

        groupPage
                .openOfficialGroup()
                .addNGroups(n);

        driver.navigate().refresh();
        System.out.print(groupPage.getNumSub());

        Assert.assertEquals(numSubBefore + n, groupPage.getNumSub());
        Assert.assertEquals(userNameFromTest, user.name);

        groupPage
                .exitNGroup(n)
                .goMainPage();
    }
}
