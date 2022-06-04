package test;

import forFactory.Factory;
import group.GroupPage;
import ok.ProductsPage;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.openqa.selenium.chrome.ChromeDriver;
import ok.LoginPage;
import ok.User;

import java.time.Duration;

import static group.WordContainedInTitleMatcher.WordContainedInTitle;
import static org.hamcrest.MatcherAssert.assertThat;

public class TestOKru {
    private static ChromeDriver driver;
    private LoginPage loginPage;
    private static final User user = new User("89229517124", "pevKeg9", "Миша Мельников");

    @BeforeAll
    static void before() {
        System.setProperty("webdriver.chrome.driver", "C:\\tehnopolis\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://ok.ru/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(user.getLogin(), user.getPass());
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

    @ParameterizedTest
    @ValueSource(strings = {"Велосипед", "Кружка"})
    public void Test2(String argument) {
        ProductsPage productsPage = new Factory()
                .get(driver)
                .openProductsPage()
                .SearchProducts(argument);

        String name = productsPage.GetNameNProduct(3);
        assertThat(argument, WordContainedInTitle(name));
        productsPage.goMainPage();
    }


    @AfterAll
    static void after() {
        new Factory()
                .get(driver)
                .exit();
    }


}
