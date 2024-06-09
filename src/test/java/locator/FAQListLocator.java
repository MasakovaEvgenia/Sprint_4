package locator;

import org.openqa.selenium.By;

public class FAQListLocator { // Класс выпадлающего списка раздела "Вопросы о важном", описание локаторов с помощью Page Object


        // Список вопросов Вопросы о важном
        // Кнопка-выпадающий список Сколько это стоит? И как оплатить?
        public static final By HOW_MUCH_AND_HOW_TO_PAY_BUTTON = By.id("accordion__heading-0");
        // Ответ после нажатия на кнопку
        public static final By HOW_MUCH_AND_HOW_TO_PAY_TEXT = By.id("accordion__panel-0");

        // Кнопка-выпадающий список "Хочу сразу несколько самокатов! Так можно?"
        public static final By SEVERAL_SCOOTERS_BUTTON = By.id("accordion__heading-1");
        // Ответ после нажатия на кнопку
        public static final By SEVERAL_SCOOTERS_TEXT = By.id("accordion__panel-1");

        // Кнопка-выпадающий список "Как рассчитывается время аренды?"
        public static final By RENTAL_TIME_CALCULATION_BUTTON = By.id("accordion__heading-2");
        // Ответ после нажатия на кнопку
        public static final By RENTAL_TIME_CALCULATION_TEXT = By.id("accordion__panel-2");

        // Кнопка-выпадающий список "Можно ли заказать самокат прямо на сегодня?"
        public static final By ORDER_TODAY_BUTTON = By.id("accordion__heading-3");
        // Ответ после нажатия на кнопку
        public static final By ORDER_TODAY_TEXT = By.id("accordion__panel-3");

        // Кнопка-выпадающий список "Можно ли продлить заказ или вернуть самокат раньше?"
        public static final By EXTEND_OR_RETURN_EARLY_BUTTON = By.id("accordion__heading-4");
        // Ответ после нажатия на кнопку
        public static final By EXTEND_OR_RETURN_EARLY_TEXT = By.id("accordion__panel-4");

        // Кнопка-выпадающий список "Вы привозите зарядку вместе с самокатом?"
        public static final By BRING_CHARGER_BUTTON = By.id("accordion__heading-5");
        // Ответ после нажатия на кнопку
        public static final By BRING_CHARGER_TEXT = By.id("accordion__panel-5");

        // Кнопка-выпадающий список "Можно ли отменить заказ?"
        public static final By CANCEL_ORDER_BUTTON = By.id("accordion__heading-6");
        // Ответ после нажатия на кнопку
        public static final By CANCEL_ORDER_TEXT = By.id("accordion__panel-6");

        // Кнопка-выпадающий список "Я живу за МКАДом, привезёте?"
        public static final By LIVE_OUTSIDE_MKAD_BUTTON = By.id("accordion__heading-7");
        // Ответ после нажатия на кнопку
        public static final By LIVE_OUTSIDE_MKAD_TEXT = By.id("accordion__panel-7");

    }


