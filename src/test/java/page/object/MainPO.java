package page.object;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.assertTrue;

public class MainPO { // Основные кнопки заказать внизу и в хэдэре

    public static final String START_URL = "https://qa-scooter.praktikum-services.ru/";
    public static final By MAKE_ORDER_BUTTON_UP = By.xpath("//button[contains(@class, 'Button_Button__ra12g') and text()='Заказать']");
    public static final By MAKE_ORDER_BUTTON_DOWN = By.xpath("//button[(text()='Заказать') and (contains(@class, 'Button_UltraBig__UU3Lp') or  contains(@class, 'Button_Middle__1CSJM'))]");


    // Список вопросов Вопросы о важном
    // Кнопка-выпадающий список Сколько это стоит? И как оплатить?
    public static final By HOW_MUCH_AND_HOW_TO_PAY_BUTTON = By.id("accordion__heading-0");
    // Ответ после нажатия на кнопку
    public static final By HOW_MUCH_AND_HOW_TO_PAY_TEXT = By.id("accordion__panel-0");

    // Кнопка-выпадающий список "Хочу сразу несколько самокатов! Так можно?"
    public static final By SEVERAL_SCOOTERS_BUTTON = By.id("accordion__heading-1");
    // Ответ после нажатия на кнопку
    public static final By SEVERAL_SCOOTERS_TEXT = By.id("accordion__panel-1");

    // Кнопка-выпадающий список "Как рассчитывается время аренды?"
    public static final By RENTAL_TIME_CALCULATION_BUTTON = By.id("accordion__heading-2");
    // Ответ после нажатия на кнопку
    public static final By RENTAL_TIME_CALCULATION_TEXT = By.id("accordion__panel-2");

    // Кнопка-выпадающий список "Можно ли заказать самокат прямо на сегодня?"
    public static final By ORDER_TODAY_BUTTON = By.id("accordion__heading-3");
    // Ответ после нажатия на кнопку
    public static final By ORDER_TODAY_TEXT = By.id("accordion__panel-3");

    // Кнопка-выпадающий список "Можно ли продлить заказ или вернуть самокат раньше?"
    public static final By EXTEND_OR_RETURN_EARLY_BUTTON = By.id("accordion__heading-4");
    // Ответ после нажатия на кнопку
    public static final By EXTEND_OR_RETURN_EARLY_TEXT = By.id("accordion__panel-4");

    // Кнопка-выпадающий список "Вы привозите зарядку вместе с самокатом?"
    public static final By BRING_CHARGER_BUTTON = By.id("accordion__heading-5");
    // Ответ после нажатия на кнопку
    public static final By BRING_CHARGER_TEXT = By.id("accordion__panel-5");

    // Кнопка-выпадающий список "Можно ли отменить заказ?"
    public static final By CANCEL_ORDER_BUTTON = By.id("accordion__heading-6");
    // Ответ после нажатия на кнопку
    public static final By CANCEL_ORDER_TEXT = By.id("accordion__panel-6");

    // Кнопка-выпадающий список "Я живу за МКАДом, привезёте?"
    public static final By LIVE_OUTSIDE_MKAD_BUTTON = By.id("accordion__heading-7");
    // Ответ после нажатия на кнопку
    public static final By LIVE_OUTSIDE_MKAD_TEXT = By.id("accordion__panel-7");


    public static void moveToMainPage(WebDriver driver) {
        driver.get(START_URL);
        acceptCookies(driver);
    }
// принятие куки
    public static void acceptCookies(WebDriver driver) {
        WebElement cookieBanner = driver.findElement(By.className("App_CookieConsent__1yUIN"));
        if (cookieBanner.isDisplayed()) {
            WebElement acceptButton = driver.findElement(By.id("rcc-confirm-button"));
            acceptButton.click();
        }
    }
// нажать на кнопку заказть в хэдэрк
    public static void moveToPersonalDataPageWithUpButton(WebDriver driver) {
        WebElement button = driver.findElement(MAKE_ORDER_BUTTON_UP);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", button); //не нужно для верхней кнопки, но ничег не аффектит
        button.click();
    }
// нажать на кнопку заказать внизу страницу
    public static void moveToPersonalDataPageWithDownButton(WebDriver driver) {
        WebElement button = driver.findElement(MAKE_ORDER_BUTTON_DOWN);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", button); //не нужно для верхней кнопки, но ничег не аффектит
        button.click();
    }

    public static String findAnswer(WebDriver driver, long waitPeriod, By questionPanel, By answerPanel) {
        WebDriverWait wait = new WebDriverWait(driver, waitPeriod);

        // Ожидание появления кнопки
        WebElement questionButton = wait.until(ExpectedConditions.visibilityOfElementLocated(questionPanel));

        // Скролл до кнопки
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", questionButton);

        // Ожидание, что кнопка станет кликабельной, и нажатие на нее
        wait.until(ExpectedConditions.elementToBeClickable(questionButton)).click();

        // Проверка, что соответствующий текст отображается с использованием явного ожидания
        WebElement answerTextElement = wait.until(ExpectedConditions.visibilityOfElementLocated(answerPanel));
        assertTrue("Ответ не отображается после нажатия на кнопку", answerTextElement.isDisplayed());
        return answerTextElement.getText();
    }
}
