package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Page {
    private final WebDriver driver;
    private WebElement[][] targets = new WebElement[100][2];

    public Page(WebDriver driver) {
        this.driver = driver;
        for (int i = 0; i < 5; i++) {
            targets[i][0] = driver.findElement(By.xpath("//html/body/div/div/div/ul/li[" + (i + 1) + "]/span"));
            targets[i][1] = driver.findElement(By.xpath("//html/body/div/div/div/ul/li[" + (i + 1) + "]/input"));
        }
    }

    public void checkTitle() {
        driver.findElement(Locators.window.TITLE);
    }

    public String getText() {
        return driver.findElement(Locators.window.TEXT).getText();
    }

    public String getTargetClass(int a) {
        return targets[a - 1][0].getAttribute("class");
    }

    public void clickButton(int a) {
        targets[a - 1][1].click();
        Sleeping.sleep(200);
    }

    public boolean newTarget(String text) {
        int check = getCountOfTargets();
        driver.findElement(Locators.list.YOUR_TEXTBOX).sendKeys(text);
        Sleeping.sleep(200);
        driver.findElement(Locators.list.YOUR_TEXTBOX_BUTTON).click();
        Sleeping.sleep(200);
        if (check == getCountOfTargets() - 1) {
            targets[getCountOfTargets() - 1][0] = driver.findElement(By.xpath(
                    "//html/body/div/div/div/ul/li[" + getCountOfTargets() + "]/span"));
            targets[getCountOfTargets() - 1][1] = driver.findElement(By.xpath(
                    "//html/body/div/div/div/ul/li[" + getCountOfTargets() + "]/input"));
            return true;
        } else {
            return false;
        }

    }

    public int getCountOfTargets() {
        return Character.getNumericValue(getText().charAt(5));
    }

    public int getCountOfCompletedTargets() {
        return Character.getNumericValue(getText().charAt(0));
    }

    public boolean checkCompletedOfTarget(int a) {
        return targets[a][0].getAttribute("class").equals("done-true");
    }


}
