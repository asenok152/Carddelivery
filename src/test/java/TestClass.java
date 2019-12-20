import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;

public class TestClass {
    WebDriver driver;
    private String input__control;

    @BeforeAll
    static void setDriverPath(){
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
    }

    @BeforeEach
    void setUp(){
        driver = new ChromeDriver();
    }

    @AfterEach
    void tearDown(){
        driver.quit();
        driver = null;
    }

    @Test
    void someTest(){
        open("http://localhost:9999");
        $$("[class='input__control']").first().setValue("Уфа");

        Date currentDate = new Date();
        Calendar c = Calendar.getInstance();
        c.setTime(currentDate);
        c.add(Calendar.DATE, 2);
        DateFormat df = new SimpleDateFormat("dd.MM.yyyy");
        String meetDateTxtValue = (df.format(c.getTime()));
        $$("[class='input__control']").get(1).setValue(meetDateTxtValue);
        $$("[class='input__control']").get(2).setValue("Петров Василий");
        $$("[class='input__control']").get(3).setValue("+79200000000");
        $("[class='checkbox__box']").click();
        $("[class='button__text']").click();

        $(withText("Встреча успешно забронирована")).waitUntil(Condition.visible,15000);

       }


}
