package scenario;

import locator.FAQListLocator;
import org.junit.Test;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public abstract class FAQListScenario {

    protected WebDriver driver;
    private By questionPanel;
    private By answerPanel;
    private String answerText;

    protected FAQListScenario(By questionPanel, By answerPanel, String answerText) {
        this.questionPanel = questionPanel;
        this.answerPanel = answerPanel;
        this.answerText = answerText;
    }

    // Метод для получения данных
    @Parameterized.Parameters
    public static Object[][] getAccordionData() {
        return new Object[][]{
                // Параметры для каждого теста кнопка и текст
                {FAQListLocator.HOW_MUCH_AND_HOW_TO_PAY_BUTTON, FAQListLocator.HOW_MUCH_AND_HOW_TO_PAY_TEXT,"Сутки — 400 рублей. Оплата курьеру — наличными или картой."},
                {FAQListLocator.SEVERAL_SCOOTERS_BUTTON, FAQListLocator.SEVERAL_SCOOTERS_TEXT,"Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим."},
                {FAQListLocator.RENTAL_TIME_CALCULATION_BUTTON, FAQListLocator.RENTAL_TIME_CALCULATION_TEXT,"Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30."},
                {FAQListLocator.ORDER_TODAY_BUTTON, FAQListLocator.ORDER_TODAY_TEXT,"Только начиная с завтрашнего дня. Но скоро станем расторопнее."},
                {FAQListLocator.EXTEND_OR_RETURN_EARLY_BUTTON, FAQListLocator.EXTEND_OR_RETURN_EARLY_TEXT, "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010."},
                {FAQListLocator.BRING_CHARGER_BUTTON, FAQListLocator.BRING_CHARGER_TEXT, "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится."},
                {FAQListLocator.CANCEL_ORDER_BUTTON, FAQListLocator.CANCEL_ORDER_TEXT, "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои."},
                {FAQListLocator.LIVE_OUTSIDE_MKAD_BUTTON, FAQListLocator.LIVE_OUTSIDE_MKAD_TEXT, "Да, обязательно. Всем самокатов! И Москве, и Московской области."},
        };
    }


    protected abstract void init ();
    // проверка того, что после клика открывается соответсвующий текст
    @Test
    public void shouldOpenCorrespondingTextWhenButtonIsClicked() {

        // Явное ожидание
        WebDriverWait wait = new WebDriverWait(driver, 3L);

        // Открытие главной страницы сервиса
        driver.get("https://qa-scooter.praktikum-services.ru");

        // Ожидание появления кнопки
        WebElement questionButton = wait.until(ExpectedConditions.visibilityOfElementLocated(questionPanel));

        // Скролл до кнопки
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", questionButton);

        // Ожидание, что кнопка станет кликабельной, и нажатие на нее
        wait.until(ExpectedConditions.elementToBeClickable(questionButton)).click();

        // Проверка, что соответствующий текст отображается с использованием явного ожидания
        WebElement answerTextElement = wait.until(ExpectedConditions.visibilityOfElementLocated(answerPanel));
        assertTrue("Ответ не отображается после нажатия на кнопку", answerTextElement.isDisplayed());

        assertEquals(answerText, answerTextElement.getText());
    }

    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }
}
