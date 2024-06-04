package org.example;

import org.openqa.selenium.By;

public interface Locators {
    interface window {
        By  TITLE   = By.xpath("//html/body/div/div/h2");
        By  TEXT    = By.xpath("//html/body/div/div/div/span");
    }
    interface list {
        By YOUR_TEXTBOX = By.xpath("//html/body/div/div/div/form/input[1]");
        By YOUR_TEXTBOX_BUTTON = By.xpath("//html/body/div/div/div/form/input[2]");
    }
}
