package locator;

import org.openqa.selenium.By;

public class AboutRentLocator { // страница "Про Аренду"
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

    // Кнопки на длительность аренды:
    public static final By ONE_DAY_OPTION = By.xpath("//div[@class='Dropdown-option' and text()='сутки']");
    public static final By TWO_DAYS_OPTION = By.xpath("//div[@class='Dropdown-option' and text()='двое суток']");
    public static final By THREE_DAYS_OPTION = By.xpath("//div[@class='Dropdown-option' and text()='трое суток']");
    public static final By FOUR_DAYS_OPTION = By.xpath("//div[@class='Dropdown-option' and text()='четверо суток']");
    public static final By FIVE_DAYS_OPTION = By.xpath("//div[@class='Dropdown-option' and text()='пятеро суток']");
    public static final By SIX_DAYS_OPTION = By.xpath("//div[@class='Dropdown-option' and text()='шестеро суток']");
    public static final By SEVEN_DAYS_OPTION = By.xpath("//div[@class='Dropdown-option' and text()='семеро суток']");


}
