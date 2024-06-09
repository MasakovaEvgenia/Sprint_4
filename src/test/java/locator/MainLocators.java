package locator;

import org.openqa.selenium.By;

public class MainLocators { // Основные кнопки заказать внизу и в хэдэре
    public static final By MAKE_ORDER_BUTTON_DOWN = By.xpath("//button[(text()='Заказать') and (contains(@class, 'Button_UltraBig__UU3Lp') or  contains(@class, 'Button_Middle__1CSJM'))]");
    public static final By MAKE_ORDER_BUTTON_UP = By.xpath("//button[contains(@class, 'Button_Button__ra12g') and text()='Заказать']");
}
