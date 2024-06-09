package locator;

import org.openqa.selenium.By;

public class PersonalDataLocator {
    public static final By FIRST_NAME = By.xpath("//input[@placeholder='* Имя']");
    public static final By LAST_NAME = By.xpath("//input[@placeholder='* Фамилия']");
    public static final By DELIVERY_ADDRESS = By.xpath("//input[@placeholder='* Адрес: куда привезти заказ']");
    public static final By SUBWAY_STATION = By.xpath("//input[@placeholder='* Станция метро']");
    public static final By PHONE = By.xpath("//input[@placeholder='* Телефон: на него позвонит курьер']");

    public static final By NEXT_PAGE_BUTTON = By.xpath("//button[contains(@class, 'Button_Button__ra12g') and text()='Далее']");

}
