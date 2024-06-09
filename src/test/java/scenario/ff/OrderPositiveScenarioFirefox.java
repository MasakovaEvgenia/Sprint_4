package scenario.ff;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.firefox.FirefoxDriver;
import scenario.OrderScenario;

@RunWith(Parameterized.class)
public class OrderPositiveScenarioFirefox extends OrderScenario {

    public OrderPositiveScenarioFirefox(String name, String lastName, String address, String metroStation, String phone, String rentalPeriod, String scooterColor, String comment) {
        super(name, lastName, address, metroStation, phone, rentalPeriod, scooterColor, comment);
        init();
    }

    @Override
    public void init() {
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
    }

    @Test
    public void testOrderByUpOrderButton() {
        super.testOrderByUpOrderButton();
    }

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
