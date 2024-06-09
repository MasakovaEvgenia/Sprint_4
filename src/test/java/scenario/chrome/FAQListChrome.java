package scenario.chrome;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import scenario.FAQListScenario;

@RunWith(Parameterized.class)
public class FAQListChrome extends FAQListScenario {

    // Конструктор с параметрами
    public FAQListChrome(By questionPanel, By answerPanel, String answerText) {
        super(questionPanel, answerPanel, answerText);
        init();
    }


    @Override
    public void init() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @Test
    public void shouldOpenCorrespondingTextWhenButtonIsClicked() {
        super.shouldOpenCorrespondingTextWhenButtonIsClicked();
    }

    // Закрываю браузер
    @After
    public void teardown() {
        // Закрой браузер
        if (driver != null) {
            driver.quit();
        }
    }



}

