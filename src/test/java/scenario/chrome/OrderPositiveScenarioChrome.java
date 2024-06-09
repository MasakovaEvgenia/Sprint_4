package scenario.chrome;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.junit.Assert.assertTrue;
import io.github.bonigarcia.wdm.WebDriverManager;
import scenario.OrderScenario;

import java.util.concurrent.TimeUnit;

@RunWith(Parameterized.class)
public class OrderPositiveScenarioChrome extends OrderScenario {

    public OrderPositiveScenarioChrome(String name, String lastName, String address, String metroStation, String phone, String rentalPeriod, String scooterColor, String comment) {
        super(name, lastName, address, metroStation, phone, rentalPeriod, scooterColor, comment);
    }


    @Before
    public void init() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    }
    // Нажатие на кнопку Заказать в Хэдэре
    @Test
    public void testOrderByUpOrderButton() {
        super.testOrderByUpOrderButton();
    }
    // Нажаитие на кнопку заказать внизу страницы
    @Test
    public void testOrderByDownOrderButton() {
        super.testOrderByDownOrderButton();
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
