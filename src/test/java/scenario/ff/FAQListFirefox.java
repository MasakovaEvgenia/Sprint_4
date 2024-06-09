package scenario.ff;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import scenario.FAQListScenario;

@RunWith(Parameterized.class)
public class FAQListFirefox extends FAQListScenario {


    // Конструктор с параметрами
    public FAQListFirefox(By questionPanel, By answerPanel, String answerText) {
        super(questionPanel, answerPanel, answerText);
        init();
    }

    @Override
    protected void init() {
        WebDriverManager.firefoxdriver().setup();
        super.setDriver(new FirefoxDriver());
    }

    @Test
    public void shouldOpenCorrespondingTextWhenButtonIsClicked(){
        super.shouldOpenCorrespondingTextWhenButtonIsClicked();
    }

    // Закрываю браузер
    @After
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }


}
