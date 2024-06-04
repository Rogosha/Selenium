package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class Page {
    private final WebDriver driver;

    public Page(WebDriver driver) {
        this.driver = driver;
    }

    public void clickCatalogButton() {
        driver.findElement(Locators.MainPage.CATALOG_BUTTON)
                .click();
    }

    public String getTitle() {
        return driver.getTitle();
    }

    public void scrollUp() {
        driver.findElement(By.xpath("//html")).sendKeys(Keys.PAGE_UP);
    }

    public void scrollDown() {
        driver.findElement(By.xpath("//html")).sendKeys(Keys.PAGE_DOWN);
    }

    public void moveToLaptopsAndComputers() {
        Actions action = new Actions(driver);
        action.moveToElement(driver.findElement(Locators.Catalog.LAPTOPS_AND_COMPUTERS)).perform();
    }

    public void moveToAbstract() {
        Actions action = new Actions(driver);
        action.moveToElement(driver.findElement(By.xpath("/html"))).perform();
    }

    public void writelaptops(int a) {
        List<WebElement> laptopsNames = driver.findElements(Locators.LAPTOPS.LAPTOPS_NAMES);
        List<WebElement> laptopsPrices = driver.findElements(Locators.LAPTOPS.LAPTOPS_PRICES);
        List<WebElement> laptopsSales = driver.findElements(Locators.LAPTOPS.LAPTOPS_SALES);
        for (int i = 0; i < a; i++) {
            String resale = "";
            if (laptopsSales.get(i).equals("УЦЕНКА")){
                resale = laptopsSales.get(i).getText();
            }
            System.out.println("Название:" + laptopsNames.get(i).getText() + " Цена:" + laptopsPrices.get(i).getText()
                    + " " + resale);
        }
    }

    public void clickLaptops() {
        driver.findElement(Locators.Catalog.LAPTOPS)
                .click();
    }

    public void clickResale(){
        driver.findElement(Locators.LAPTOPS.RESALE_BUTTON).click();
    }

    public boolean checkResale(int a){
        List<WebElement> laptopsSales = driver.findElements(Locators.LAPTOPS.LAPTOPS_SALES);
        boolean flag =true;
        for (int i = 0; i < a; i++) {
            if (!laptopsSales.get(i).equals("УЦЕНКА")) {
                flag = false;
                break;
            }
        }
        return true;
    }
}
