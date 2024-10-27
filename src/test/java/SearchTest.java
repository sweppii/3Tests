import org.example.Main;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

public class SearchTest {
    WebDriver driver;
    Main main;

    @BeforeTest
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://zoolandia.com.ua/ua/");
        main = new Main(driver);
    }

    @Test
    public void searchForAquarium() {
        main.enterAquarium();
        main.pressEnter();

        List<WebElement> results = driver.findElements(By.className("product-list__caption-title"));

        Assert.assertTrue(results.size() > 0, "Не знайдено жодного товару.");
        Assert.assertTrue(results.get(0).getText().toLowerCase().contains("акваріум"),
                "Перший товар у списку не містить слово 'акваріум'.");
    }

    @AfterTest
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
