package page.object;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.assertTrue;

public class MakeOrderPopupPO { // кнопка подтверждения заказа
    public static final By MAKE_ORDER_YES_BUTTON = By.xpath("//button[contains(@class, 'Button_Button__ra12g') and text()='Да']");
    public static final By ORDER_MODAL_HEADER = By.className("Order_ModalHeader__3FDaJ");
    //информация о заказе
    public static final By ORDER_STATUS_INFO = By.className("Order_Text__2broi");
    // кнопка Посмотреть статус заказа
    public static final By CHECK_STATUS_BUTTON = By.xpath("//button[text()='Посмотреть статус']");

    public static void clickYesButton(WebDriver driver, long waitPeriod) {
        WebElement yesButton = driver.findElement(MakeOrderPopupPO.MAKE_ORDER_YES_BUTTON);
        WebDriverWait wait = new WebDriverWait(driver, waitPeriod);
        wait.until(ExpectedConditions.elementToBeClickable(MakeOrderPopupPO.MAKE_ORDER_YES_BUTTON));
        yesButton.click();
    }

    public static String validatePopup(WebDriver driver, long waitPeriod) {
        WebElement orderModalHeader = driver.findElement(ORDER_MODAL_HEADER);
        WebElement orderStatusInfo = driver.findElement(ORDER_STATUS_INFO);
        WebDriverWait wait = new WebDriverWait(driver, waitPeriod);
        wait.until(ExpectedConditions.elementToBeClickable(CHECK_STATUS_BUTTON));
        WebElement viewStatusButton = driver.findElement(CHECK_STATUS_BUTTON);

        // добавила проверку текста "Заказ оформлен"
        assertTrue(orderModalHeader.isDisplayed());
        assertTrue(orderStatusInfo.isDisplayed());
        assertTrue(viewStatusButton.isDisplayed());
        return orderModalHeader.getText();
    }
}
