import org.example.Page;
import org.example.Sleeping;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestA {
    private WebDriver driver;
    @Before
    public void starting() {
        String url = "https://mospolytech.ru/";
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(url);
        Sleeping.sweet(2);
    }

    @Test
    public void continuation() {
        Page mospolytech = new Page(driver);
        Sleeping.sweet(2000);
        mospolytech.clickTimetable();
        Sleeping.sweet(2000);
        mospolytech.clickLookOnSite();
        Sleeping.sweet(2000);
        int b = mospolytech.PutGroupNumber("221-323");
        Assert.assertEquals(b,1);
        Sleeping.sweet(1000 );
        String a = mospolytech.SelectGroup();
        Assert.assertEquals(a,"schedule-day schedule-day_today");
        Sleeping.sweet(1000 );
    }

    @After
    public void ending() {

        driver.quit();
    }
}
