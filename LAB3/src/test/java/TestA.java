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
        String url = "https://market.yandex.ru";
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(url);
        Sleeping.sweet(2);
    }

    @Test
    public void continuation() {
        Page page = new Page(driver);

        //проверяем, что открылась нужная страница
        Assert.assertEquals(page.getTitle(), "Интернет-магазин Яндекс Маркет — покупки с быстрой доставкой");
        Sleeping.sweet(500);

        page.clickCatalogButton();
        Sleeping.sweet(2000);
        Sleeping.sweet(1000);
        page.moveToLaptopsAndComputers();
        page.moveToAbstract();
        Sleeping.sweet(4000);
        page.clickLaptops();
        Sleeping.sweet(500);
        page.scrollDown();
        page.writelaptops(5);
        page.clickResale();
        Sleeping.sweet(500);
        page.scrollDown();
        Assert.assertTrue(page.checkResale(10));
        Sleeping.sweet(5000);
    }

    @After
    public void ending() {
        //driver.quit();
    }
}
