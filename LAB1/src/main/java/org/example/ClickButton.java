package org.example;

import org.openqa.selenium.WebElement;

public class ClickButton {
    public static void clickButton(WebElement[][] targets, WebElement text, int a) {
        targets[a][1].click();
        Sleeping.sleep(200);
        try {
            if (!(targets[a][0].getAttribute("class").equals("done-true") && text.getText().equals(4 - a + " of 5 remaining"))) {
                throw new Exception("Элемент " + (a+1) + " не сработал");
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
