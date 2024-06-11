package scenario;

import io.github.bonigarcia.wdm.WebDriverManager;
import page.object.AboutRentPO;
import page.object.MainPO;
import page.object.PersonalDataPO;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import static page.object.AboutRentPO.METRO_BULVAR_ROCOSSOVSKOGO;
import static page.object.AboutRentPO.METRO_SVIBLOVO;
import static page.object.MakeOrderPopupPO.validatePopup;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;

@RunWith(Parameterized.class)
public class OrderScenarioTest { // Тест заказа самоката в разных браузерах и с разными вводными данными

    public static final String CHROME = "chrome";
    public static final String FIREFOX = "firefox";
    private final String expectedOrderText = "Заказ оформлен";


    private final long TWO_SECOND = 2L;
    protected WebDriver driver;

    private final String name;
    private final String lastName;
    private final String address;
    private final String phone;
    private final By metroStation;
    private final By dayOfMonth;
    private final By scooterColor;
    private final String comment;
    private final By rentalPeriod;

    public OrderScenarioTest(String browser, String name, String lastName, String address, By metroStation, String phone, By dateOfMonth, By rentalPeriod, By scooterColor, String comment) {
        this.name = name;
        this.lastName = lastName;
        this.address = address;
        this.metroStation = metroStation;
        this.phone = phone;
        this.dayOfMonth = dateOfMonth;
        this.rentalPeriod = rentalPeriod;
        this.scooterColor = scooterColor;
        this.comment = comment;
        init(browser);
    }

    public void init(String browser) {
        if (CHROME.equalsIgnoreCase(browser)) { // если браузер хром, тест запуститься на хроме
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        } else if (FIREFOX.equalsIgnoreCase(browser)) { // если браузер фф, то запуститься на фф
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        }
    }

    @Parameterized.Parameters
    public static Object[][] getTestData() {
        return new Object[][]{
                {CHROME, "Жунипер", "Пеппе", "Николая Химушина, 21к2, кв 19", METRO_BULVAR_ROCOSSOVSKOGO, "+79777740779", AboutRentPO.FIFTEEN_DAY, AboutRentPO.ONE_DAY_OPTION, AboutRentPO.SCOOTER_COLOR_BLACK, ""},
                {CHROME, "Агропышка", "Виниаминова", "Заповедная, 21, кв 19", METRO_SVIBLOVO, "+79777770777", AboutRentPO.FIFTEEN_DAY, AboutRentPO.THREE_DAYS_OPTION, AboutRentPO.SCOOTER_COLOR_GREY, "спасибо за доставку!"},
                {FIREFOX, "Жунипер", "Пеппе", "Николая Химушина, 21к2, кв 19", METRO_BULVAR_ROCOSSOVSKOGO, "+79777740779", AboutRentPO.FIFTEEN_DAY, AboutRentPO.ONE_DAY_OPTION, AboutRentPO.SCOOTER_COLOR_BLACK, ""},
                {FIREFOX, "Агропышка", "Виниаминова", "Заповедная, 21, кв 19", METRO_SVIBLOVO, "+79777770777", AboutRentPO.FIFTEEN_DAY, AboutRentPO.THREE_DAYS_OPTION, AboutRentPO.SCOOTER_COLOR_GREY, "спасибо за доставку!"}
        };
    }

    @Test
    public void testOrderByDownOrderButton() {
        //WebDriverWait wait = new WebDriverWait(driver, TWO_SECOND);
        MainPO.moveToMainPage(driver);
        MainPO.moveToPersonalDataPageWithDownButton(driver);
        PersonalDataPO.fillPersonaData(driver, name, lastName, address, metroStation, phone);
        PersonalDataPO.moveToAboutRentPage(driver);
        AboutRentPO.fillRentData(driver, TWO_SECOND, dayOfMonth, rentalPeriod, scooterColor, comment);
        AboutRentPO.makeOrder(driver, TWO_SECOND);
        String orderStatus = validatePopup(driver, TWO_SECOND);
        assertThat(orderStatus, containsString(expectedOrderText)); // проверка текста Заказ оформлен
    }

    @Test
    public void testOrderByUpOrderButton() {
        WebDriverWait wait = new WebDriverWait(driver, TWO_SECOND);
        MainPO.moveToMainPage(driver);
        MainPO.moveToPersonalDataPageWithUpButton(driver);
        PersonalDataPO.fillPersonaData(driver, name, lastName, address, metroStation, phone);
        PersonalDataPO.moveToAboutRentPage(driver);
        AboutRentPO.fillRentData(driver, TWO_SECOND, dayOfMonth, rentalPeriod, scooterColor, comment);
        AboutRentPO.makeOrder(driver, TWO_SECOND);
        String orderStatus = validatePopup(driver, TWO_SECOND);
        assertThat(orderStatus, containsString(expectedOrderText)); // проверка текста Заказ оформлен
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

}
