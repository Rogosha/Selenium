import org.example.Page;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.example.Sleeping;

public class TestA {
    private WebDriver driver;

    @Before
    public void starting() {
        String url = "https://lambdatest.github.io/sample-todo-app/";
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(url);
        Sleeping.sleep(2);
    }

    @Test
    public void continuation() {
        Page page = new Page(driver);

        //проверка на присутствие текста
        Assert.assertEquals(page.getText(), "5 of 5 remaining");

        //проверка, что первый элемент не зачёрнут
        Assert.assertEquals(page.getTargetClass(1), "done-false");

        //ставим галочки и проверяем, зачёркнут ли элемент и проверяем отображаемое число оставшихся элементов
        for (int i = 1; i < 6; i++) {
            page.clickButton(i);
            Assert.assertEquals(page.getTargetClass(i), "done-true");
            Assert.assertEquals(page.getText(), (5 - i) + " of 5 remaining");
        }

        int check = page.getCountOfTargets();
        //добавляем новый элемент
        Assert.assertTrue(page.newTarget("sixth item"));

        //проверяем, что новый элемент не зачёрнут
        Assert.assertEquals(page.getTargetClass(page.getCountOfTargets()), "done-false");
        //проверяем, что количество элементов увеличилось на 1
        Assert.assertEquals(page.getCountOfTargets(), check + 1);

        check = page.getCountOfCompletedTargets();
        //нажимаем на новый элемент списка
        page.clickButton(page.getCountOfTargets());
        //проверяем, что новый элемент списка становится зачёркнутым
        Assert.assertEquals(page.getTargetClass(page.getCountOfTargets()), "done-true");
        //проверяем, что отображаемое число оставшихся элементов уменьшается на 1
        Assert.assertEquals(page.getCountOfCompletedTargets(), check - 1);
        Sleeping.sleep(1000);

    }

    @After
    public void ending() {
        driver.quit();
    }
}
