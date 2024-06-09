package locator;

import org.openqa.selenium.By;

public class PersonalDataLocator { // страница "Для кого Самокат"
    // Поле ввода имени
    public static final By FIRST_NAME = By.xpath("//input[@placeholder='* Имя']");
    // Поле ввода фимлии
    public static final By LAST_NAME = By.xpath("//input[@placeholder='* Фамилия']");
    // поле ввода адреса
    public static final By DELIVERY_ADDRESS = By.xpath("//input[@placeholder='* Адрес: куда привезти заказ']");
    // поле выбора станции
    public static final By SUBWAY_STATION = By.xpath("//input[@placeholder='* Станция метро']");
    // поле ввода номера
    public static final By PHONE = By.xpath("//input[@placeholder='* Телефон: на него позвонит курьер']");
    // кнопка Далее для оформления заказа
    public static final By NEXT_PAGE_BUTTON = By.xpath("//button[contains(@class, 'Button_Button__ra12g') and text()='Далее']");

}
