package locator;

import org.openqa.selenium.By;

public class DoneOrderPopup { // Попап совершенного заказа
    // заголовок попапа
    public static final By ORDER_MODAL_HEADER = By.className("Order_ModalHeader__3FDaJ");
    //информация о заказе
    public static final By ORDER_STATUS_INFO = By.className("Order_Text__2broi");
    // кнопка Посмотреть статус заказа
    public static final By CHECK_STATUS_BUTTON = By.xpath("//button[text()='Посмотреть статус']");

}
