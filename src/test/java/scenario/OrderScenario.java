package scenario;

import locator.*;
import org.junit.After;
import org.junit.Test;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.assertTrue;

public abstract class OrderScenario {


    protected WebDriver driver;

    private final String name;
    private final String lastName;
    private final String address;
    private final String metroStation;
    private final String phone;
    private final String rentalPeriod;
    private final String scooterColor;
    private final String comment;

    protected OrderScenario(String name, String lastName, String address, String metroStation, String phone, String rentalPeriod, String scooterColor, String comment) {
        this.name = name;
        this.lastName = lastName;
        this.address = address;
        this.metroStation = metroStation;
        this.phone = phone;
        this.rentalPeriod = rentalPeriod;
        this.scooterColor = scooterColor;
        this.comment = comment;
    }

    protected abstract void init();

    @Parameterized.Parameters
    public static Object[][] getTestData() {
        return new Object[][]{
                {"Жунипер", "Пеппе", "Николая Химушина, 21к2, кв 19", "Бульвар Рокоссовского", "+79777740779", "сутки", "black", ""},
                {"Агропышка", "Виниаминова", "Заповедная, 21, кв 19", "Свиблово", "+79777770777", "трое суток", "grey", "спасибо за доставку!"}
        };
    }

    @Test
    public void testOrderByDownOrderButton() {
        WebDriverWait wait = new WebDriverWait(driver, 2L);
        moveToMainPage();
        moveToPersonalDataPage(MainLocators.MAKE_ORDER_BUTTON_DOWN);
        fillPersonaData();
        moveToAboutRentPage();
        fillRentData(wait);
        makeOrder(wait);
        validePopup(wait);
    }

    @Test
    public void testOrderByUpOrderButton() {
        WebDriverWait wait = new WebDriverWait(driver, 2L);
        moveToMainPage();
        moveToPersonalDataPage(MainLocators.MAKE_ORDER_BUTTON_UP);
        fillPersonaData();
        moveToAboutRentPage();
        fillRentData(wait);
        makeOrder(wait);
        validePopup(wait);
    }

    private void validePopup(WebDriverWait wait) {
        WebElement orderModalHeader = driver.findElement(DoneOrderPopup.ORDER_MODAL_HEADER);
        WebElement orderStatusInfo = driver.findElement(DoneOrderPopup.ORDER_STATUS_INFO);
        wait.until(ExpectedConditions.elementToBeClickable(DoneOrderPopup.CHECK_STATUS_BUTTON));
        WebElement viewStatusButton = driver.findElement(DoneOrderPopup.CHECK_STATUS_BUTTON);

        assertTrue(orderModalHeader.isDisplayed());
        assertTrue(orderStatusInfo.isDisplayed());
        assertTrue(viewStatusButton.isDisplayed());
    }

    private void makeOrder(WebDriverWait wait) {
        WebElement nextButton = driver.findElement(AboutRentLocator.MAKE_ORDER_FINAL_BUTTON);
        nextButton.click();
        WebElement yesButton = driver.findElement(MakeOrderPopupLocators.MAKE_ORDER_YES_BUTTON);
        wait.until(ExpectedConditions.elementToBeClickable(MakeOrderPopupLocators.MAKE_ORDER_YES_BUTTON));
        yesButton.click();
    }

    private void fillRentData(WebDriverWait wait) {
        WebElement deliveryDateField = driver.findElement(AboutRentLocator.DATE_DATA_WHEN_BRING);
        deliveryDateField.click();
        WebElement nextMonthButton = driver.findElement(AboutRentLocator.DATE_NEXT_MONTH_BUTTON);
        nextMonthButton.click();
        wait.until(ExpectedConditions.elementToBeClickable(AboutRentLocator.FIFTEEN_DAY));
        WebElement date15th = driver.findElement(AboutRentLocator.FIFTEEN_DAY);
        date15th.click();

        WebElement rentalPeriodDropdown = driver.findElement(AboutRentLocator.DATE_DATA_RENTAL_PERIOD);
        rentalPeriodDropdown.click();
        WebElement rentalPeriodOption = driver.findElement(By.xpath("//div[@class='Dropdown-option' and text()='" + rentalPeriod + "']")); //не в константах из-за параметра
        rentalPeriodOption.click();

        WebElement scooterColorCheckbox = driver.findElement(By.xpath("//input[@id='" + scooterColor + "']")); //не в константах из-за параметра
        scooterColorCheckbox.click();

        if (!comment.isEmpty()) {
            WebElement commentField = driver.findElement(AboutRentLocator.COURIER_COMMENT);
            commentField.sendKeys(comment);
        }
    }

    private void moveToAboutRentPage() {
        WebElement toPageConfirmDatePage = driver.findElement(PersonalDataLocator.NEXT_PAGE_BUTTON);
        toPageConfirmDatePage.click();
    }

    private void fillPersonaData() {
        WebElement nameField = driver.findElement(PersonalDataLocator.FIRST_NAME);
        nameField.sendKeys(name);

        WebElement lastNameField = driver.findElement(PersonalDataLocator.LAST_NAME);
        lastNameField.sendKeys(lastName);

        WebElement addressField = driver.findElement(PersonalDataLocator.DELIVERY_ADDRESS);
        addressField.sendKeys(address);

        WebElement metroStationField = driver.findElement(PersonalDataLocator.SUBWAY_STATION);
        metroStationField.click();
        WebElement metroStationOption = driver.findElement(By.xpath("//div[@class='select-search__select']/ul/li/button/div[text()='" + metroStation + "']")); //не в константах из-за параметра
        metroStationOption.click();

        WebElement phoneField = driver.findElement(PersonalDataLocator.PHONE);
        phoneField.sendKeys(phone);
    }

    private void moveToPersonalDataPage(By moveToOrderButtonBy) {
        WebElement button = driver.findElement(moveToOrderButtonBy);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", button); //не нужно для верхней кнопки, но ничег не аффектит
        button.click();
    }

    private void moveToMainPage() {
        driver.get("https://qa-scooter.praktikum-services.ru/");

        WebElement cookieBanner = driver.findElement(By.className("App_CookieConsent__1yUIN"));
        if (cookieBanner.isDisplayed()) {
            WebElement acceptButton = driver.findElement(By.id("rcc-confirm-button"));
            acceptButton.click();
        }
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    /*Метод для отладки - расстановка пауз при выполнении*/
    public void customDelay(int milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /*Метод для отладки - подсвечивает красным используемый элемент*/
    private void markElement(By elementBy) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        String jsSyyle = "'3px solid red'";
        WebElement element = driver.findElement(elementBy);
        js.executeScript("arguments[0].style.border=" + jsSyyle, element);
    }

}
