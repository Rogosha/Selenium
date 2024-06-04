package org.example;

import org.openqa.selenium.By;

import java.util.Calendar;

public interface Locators {
    interface MainPage {
        By TIMETABLE_BUTTON = By.xpath("//html/body/header/nav/div/div[2]/div/div/ul/li[3]/a");
    }
    interface Timetable {
        By LOOK_ON_SITE = By.xpath("//html/body/main/div[1]/div/div/div/ul/li[1]/div[3]/div/div[1]/a");
    }
    interface TimetableSecond {
        By TEXTBOX = By.xpath("//html/body/div/div[1]/div[1]/div[3]/input[1]");
        By GROUP = By.xpath("//html/body/div//div/div[2]/div[1]");
        By TIMETABLE_FOR_WEEK = By.xpath("//html/body/div/div[5]/div[1]");
    }
}
