package page.object;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static page.object.MakeOrderPopupPO.clickYesButton;


public class AboutRentPO { // страница "Про Аренду"
    // кнопка Когда привезти самокат
    public static final By DATE_DATA_WHEN_BRING = By.xpath("//input[@placeholder='* Когда привезти самокат']");
    // кнопка Срок аренды
    public static final By DATE_DATA_RENTAL_PERIOD = By.xpath("//div[@class='Dropdown-placeholder' and text()='* Срок аренды']");
    // для теста я использовала выбор кнопки следующего месяца
    public static final By DATE_NEXT_MONTH_BUTTON = By.xpath("//button[@aria-label='Next Month']");
    // для теста я выбрала каждое 15 число месяца
    public static final By FIFTEEN_DAY = By.className("react-datepicker__day--015");
    // кнопка Комментарий для курьера
    public static final By COURIER_COMMENT = By.xpath("//input[@placeholder='Комментарий для курьера']");
    // Кнопка Заказать
    public static final By MAKE_ORDER_FINAL_BUTTON = By.xpath("//button[contains(@class, 'Button_Middle__1CSJM') and text()='Заказать']");
    // Цвет самоката Черный Жемчуг
    public static final By SCOOTER_COLOR_BLACK = By.xpath("//input[@id='black']");
    // Цвет самоката Серая Безысходность
    public static final By SCOOTER_COLOR_GREY = By.xpath("//input[@id='grey']");
    // Кнопки на длительность аренды:
    public static final By ONE_DAY_OPTION = By.xpath("//div[@class='Dropdown-option' and text()='сутки']");
    public static final By TWO_DAYS_OPTION = By.xpath("//div[@class='Dropdown-option' and text()='двое суток']");
    public static final By THREE_DAYS_OPTION = By.xpath("//div[@class='Dropdown-option' and text()='трое суток']");
    public static final By FOUR_DAYS_OPTION = By.xpath("//div[@class='Dropdown-option' and text()='четверо суток']");
    public static final By FIVE_DAYS_OPTION = By.xpath("//div[@class='Dropdown-option' and text()='пятеро суток']");
    public static final By SIX_DAYS_OPTION = By.xpath("//div[@class='Dropdown-option' and text()='шестеро суток']");
    public static final By SEVEN_DAYS_OPTION = By.xpath("//div[@class='Dropdown-option' and text()='семеро суток']");
    public static final By METRO_BULVAR_ROCOSSOVSKOGO = By.xpath("//div[@class='select-search__select']/ul/li/button/div[text()='Бульвар Рокоссовского']");
    public static final By METRO_SVIBLOVO = By.xpath("//div[@class='select-search__select']/ul/li/button/div[text()='Свиблово']");

    public static void fillRentData(WebDriver driver, long waitPeriod, By dayOfMonth, By rentalPeriod, By scooterColor, String comment) {
        clickDeliveryDate(driver);
        clickNextMonthButton(driver);
        clickDate(driver, waitPeriod, dayOfMonth);
        chooseRentalPeriodDropdown(driver, rentalPeriod);
        chooseScooterColor(driver, scooterColor);
        makeComment(driver, comment);
    }
//  нажатие на кнопку Заказать
    private static void clickOrderFinalButton(WebDriver driver) {
        WebElement nextButton = driver.findElement(AboutRentPO.MAKE_ORDER_FINAL_BUTTON);
        nextButton.click();
    }
// встать в поле ввода даты
    private static void clickDeliveryDate(WebDriver driver) {
        WebElement deliveryDateField = driver.findElement(AboutRentPO.DATE_DATA_WHEN_BRING);
        deliveryDateField.click();
    }
// выбрать следующий месяц
    private static void clickNextMonthButton(WebDriver driver) {
        WebElement nextMonthButton = driver.findElement(AboutRentPO.DATE_NEXT_MONTH_BUTTON);
        nextMonthButton.click();
    }
// выбрать день
    private static void clickDate(WebDriver driver, long waitPeriod, By dayOfMonth) {
        WebDriverWait wait = new WebDriverWait(driver, waitPeriod);
        wait.until(ExpectedConditions.elementToBeClickable(dayOfMonth));
        WebElement day = driver.findElement(dayOfMonth);
        day.click();
    }
// выбрать срок аренды
    private static void chooseRentalPeriodDropdown(WebDriver driver, By rentalPeriod) {
        WebElement rentalPeriodDropdown = driver.findElement(AboutRentPO.DATE_DATA_RENTAL_PERIOD);
        rentalPeriodDropdown.click();
        WebElement rentalPeriodOption = driver.findElement(rentalPeriod);
        rentalPeriodOption.click();
    }
// оставить комментарий
    private static void makeComment(WebDriver driver, String comment) {
        if (!comment.isEmpty()) {
            WebElement commentField = driver.findElement(AboutRentPO.COURIER_COMMENT);
            commentField.sendKeys(comment);
        }
    }
// выбрать цвет самоката
    private static void chooseScooterColor(WebDriver driver, By scooterColor) {
        WebElement scooterColorCheckbox = driver.findElement(scooterColor);
        scooterColorCheckbox.click();
    }
// нажать на кнопку Да
    public static void makeOrder(WebDriver driver, long waitPeriod) {
        WebDriverWait wait = new WebDriverWait(driver, waitPeriod);
        clickOrderFinalButton(driver);
        wait.until(ExpectedConditions.elementToBeClickable(MakeOrderPopupPO.MAKE_ORDER_YES_BUTTON));
        clickYesButton(driver, waitPeriod);
    }
}
