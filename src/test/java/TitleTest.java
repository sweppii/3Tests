import org.example.Main;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TitleTest {
    WebDriver driver;
    Main main;

    @BeforeTest
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        main = new Main(driver);
        driver.get("https://zoolandia.com.ua/ua/");
    }

    @Test
    public void verifyHomePageTitle() {

        String expectedTitle = "Зоомагазин - купити зоотовари для тварин в інтернет-магазині Zoolandia";
        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle, expectedTitle, "Заголовок сторінки не збігається.");
    }

    @AfterTest
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
