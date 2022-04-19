package test;

import forFactory.Factory;
import group.GroupPage;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.openqa.selenium.chrome.ChromeDriver;
import ok.LoginPage;
import ok.User;

public class TestOKru {
    private static ChromeDriver driver;
    private LoginPage loginPage;
    private static final User user = new User("aaa", "aaa", "aaa");

    @BeforeAll
    static void before() {
        System.setProperty("webdriver.chrome.driver", "C:\\tehnopolis\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://ok.ru/");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(user.login, user.pass);
    }

    @ParameterizedTest
    @ValueSource(ints = {2, 3})
    public void testAddNGroups(int argument) {
        GroupPage groupPage = new Factory()
                .get(driver)
                .openGroupPage();

        int numSubBefore = groupPage.getNumSub();
        int numSubAfter = groupPage
                .openOfficialGroup()
                .addNGroups(argument)
                .refresh()
                .scroll()
                .getNumSub();

        Assertions.assertEquals(numSubBefore + argument, numSubAfter);

        groupPage
                .exitNGroup(argument)
                .goMainPage();
    }

    @AfterAll
    static void after() {
        new Factory()
                .get(driver)
                .exit();
    }
}
