package scenario;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import page.object.MainPO;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class FAQListScenarioTest { // тест для Вопросы о важном в двух браузерах

    private static final long TWO_SECOND = 2L;
    protected WebDriver driver;
    private final By questionPanel;
    private final By answerPanel;
    private final String expectedAnswer;
    public static final String CHROME = "chrome";
    public static final String FIREFOX = "firefox";


    public FAQListScenarioTest(String browser, By questionPanel, By answerPanel, String expectedAnswer) {
        this.questionPanel = questionPanel;
        this.answerPanel = answerPanel;
        this.expectedAnswer = expectedAnswer;
        init(browser);
    }

    // Метод для получения данных
    @Parameterized.Parameters
    public static Object[][] getAccordionData() {
        return new Object[][]{
                {CHROME, MainPO.HOW_MUCH_AND_HOW_TO_PAY_BUTTON, MainPO.HOW_MUCH_AND_HOW_TO_PAY_TEXT, "Сутки — 400 рублей. Оплата курьеру — наличными или картой."},
                {CHROME, MainPO.SEVERAL_SCOOTERS_BUTTON, MainPO.SEVERAL_SCOOTERS_TEXT, "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим."},
                {CHROME, MainPO.RENTAL_TIME_CALCULATION_BUTTON, MainPO.RENTAL_TIME_CALCULATION_TEXT, "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30."},
                {CHROME, MainPO.ORDER_TODAY_BUTTON, MainPO.ORDER_TODAY_TEXT, "Только начиная с завтрашнего дня. Но скоро станем расторопнее."},
                {CHROME, MainPO.EXTEND_OR_RETURN_EARLY_BUTTON, MainPO.EXTEND_OR_RETURN_EARLY_TEXT, "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010."},
                {CHROME, MainPO.BRING_CHARGER_BUTTON, MainPO.BRING_CHARGER_TEXT, "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится."},
                {CHROME, MainPO.CANCEL_ORDER_BUTTON, MainPO.CANCEL_ORDER_TEXT, "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои."},
                {CHROME, MainPO.LIVE_OUTSIDE_MKAD_BUTTON, MainPO.LIVE_OUTSIDE_MKAD_TEXT, "Да, обязательно. Всем самокатов! И Москве, и Московской области."},
                {FIREFOX, MainPO.HOW_MUCH_AND_HOW_TO_PAY_BUTTON, MainPO.HOW_MUCH_AND_HOW_TO_PAY_TEXT, "Сутки — 400 рублей. Оплата курьеру — наличными или картой."},
                {FIREFOX, MainPO.SEVERAL_SCOOTERS_BUTTON, MainPO.SEVERAL_SCOOTERS_TEXT, "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим."},
                {FIREFOX, MainPO.RENTAL_TIME_CALCULATION_BUTTON, MainPO.RENTAL_TIME_CALCULATION_TEXT, "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30."},
                {FIREFOX, MainPO.ORDER_TODAY_BUTTON, MainPO.ORDER_TODAY_TEXT, "Только начиная с завтрашнего дня. Но скоро станем расторопнее."},
                {FIREFOX, MainPO.EXTEND_OR_RETURN_EARLY_BUTTON, MainPO.EXTEND_OR_RETURN_EARLY_TEXT, "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010."},
                {FIREFOX, MainPO.BRING_CHARGER_BUTTON, MainPO.BRING_CHARGER_TEXT, "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится."},
                {FIREFOX, MainPO.CANCEL_ORDER_BUTTON, MainPO.CANCEL_ORDER_TEXT, "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои."},
                {FIREFOX, MainPO.LIVE_OUTSIDE_MKAD_BUTTON, MainPO.LIVE_OUTSIDE_MKAD_TEXT, "Да, обязательно. Всем самокатов! И Москве, и Московской области."},
        };
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

    // проверка того, что после клика открывается соответсвующий текст
    @Test
    public void shouldOpenCorrespondingTextWhenButtonIsClicked() {
        MainPO.moveToMainPage(driver);
        String answer = MainPO.findAnswer(driver, TWO_SECOND, questionPanel, answerPanel);
        assertEquals(expectedAnswer, answer);
    }
    
    // Закрываю браузер
    @After
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
