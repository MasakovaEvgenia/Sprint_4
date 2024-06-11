package page.object;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PersonalDataPO { // страница "Для кого Самокат"
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

    public static void moveToAboutRentPage(WebDriver driver) {
        WebElement toPageConfirmDatePage = driver.findElement(NEXT_PAGE_BUTTON);
        toPageConfirmDatePage.click();
    }
    public static void choseMetroStationField(WebDriver driver, By station) {
        WebElement metroStationField = driver.findElement(SUBWAY_STATION);
        metroStationField.click();

        WebElement metroStationOption = driver.findElement(station); //не в константах из-за параметра
        metroStationOption.click();
    }
    // заполнение персональных данных
    public static void fillPersonaData(WebDriver driver, String name, String lastName, String address, By metroStation, String phone) {
        WebElement nameField = driver.findElement(FIRST_NAME);
        nameField.sendKeys(name);

        WebElement lastNameField = driver.findElement(LAST_NAME);
        lastNameField.sendKeys(lastName);

        WebElement addressField = driver.findElement(DELIVERY_ADDRESS);
        addressField.sendKeys(address);

        PersonalDataPO.choseMetroStationField(driver, metroStation);

        WebElement phoneField = driver.findElement(PHONE);
        phoneField.sendKeys(phone);
    }
}
