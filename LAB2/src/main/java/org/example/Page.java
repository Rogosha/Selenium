package org.example;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class Page {
    private final WebDriver driver;
    public Page(WebDriver driver) {
        this.driver = driver;
    }

    public void clickTimetable(){
        driver.findElement(Locators.MainPage.TIMETABLE_BUTTON).click();
        driver.findElement(By.xpath("/html")).sendKeys(Keys.END);
        driver.findElement(By.xpath("/html")).sendKeys(Keys.HOME);
    }

    public void clickLookOnSite(){
        driver.findElement(Locators.Timetable.LOOK_ON_SITE).click();
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
            driver.switchTo().window(tabs.get(0));
            driver.close();
            driver.switchTo().window(tabs.get(1));
    }

    public int PutGroupNumber(String text){
        WebElement textbox = driver.findElement(Locators.TimetableSecond.TEXTBOX);
        textbox.sendKeys(text);
        textbox.sendKeys(Keys.ENTER);
        Sleeping.sweet(1000);
        List<WebElement> webElements1 = driver.findElements(
                By.xpath("//div[@class='found-groups row not-print']/div"));
        return webElements1.size();
    }

    public String SelectGroup () {
        WebElement group = driver.findElement(Locators.TimetableSecond.GROUP);
        group.click();
        WebElement weekTimetable;
        Sleeping.sweet(200);
        weekTimetable = driver.findElement(Locators.TimetableSecond.TIMETABLE_FOR_WEEK);
        Calendar calendar = Calendar.getInstance();
        WebElement currentDay = driver.findElement(By.xpath("//html/body/div/div[5]/div[1]/div[" +
                (calendar.get(Calendar.DAY_OF_WEEK)-1) + "]"));
        return currentDay.getAttribute("class");
    }

}
