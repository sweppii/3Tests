import org.example.Main;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class MenuTest {
    WebDriver driver;
    Actions actions;
    Main main;

    @BeforeTest
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        actions = new Actions(driver);
        driver.get("https://zoolandia.com.ua/ua/");
        main = new Main(driver);
    }

    @Test
    public void verifyMenuNavigation() {
        main.moveToForFishes();
        main.checkAquarium();
        main.clickAquariums();

        String expectedUrl = "https://zoolandia.com.ua/ua/shop/ribam/akvariumi";
        Assert.assertEquals(driver.getCurrentUrl(), expectedUrl, "URL сторінки не збігається.");
    }

    @AfterTest
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
