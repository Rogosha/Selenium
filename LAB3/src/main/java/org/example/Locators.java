package org.example;

import org.openqa.selenium.By;

public interface Locators {
    interface MainPage{
        By CATALOG_BUTTON = By.xpath("/html/body/div[1]/div/div[2]/div[2]/div/header/div[1]/div/div/noindex[1]/div/div/button");
    }
    interface Catalog{
        By LAPTOPS_AND_COMPUTERS = By.xpath("/html/body/div[7]/div/div/div/div/div/div/div[1]/div/ul/li[21]/a/span");
        By LAPTOPS = By.xpath("/html/body/div[7]/div/div/div/div/div/div/div[2]/div/div/div/div[1]/div/div/div/div/div/div/div/div[1]/div[1]/ul/li[1]/div/a");
    }
    interface LAPTOPS{
        By LAPTOPS_NAMES = By.xpath("//div[@data-apiary-widget-name='@light/Organic']/child::div//div[@class='m4M-1']//h3");
        By LAPTOPS_PRICES = By.xpath("//div[@data-apiary-widget-name='@light/Organic']/child::div//span[@class='_1ArMm']");
        By LAPTOPS_SALES = By.xpath("//div[@data-apiary-widget-name='@light/Organic']/child::div//span[@class='_2Vt2k']");
        By RESALE_BUTTON = By.xpath("//*[@id=\"/content/page/fancyPage/cms/4/SearchFilters-SearchFilters\"]/div/div/div/div/div[7]/div/fieldset/div/div/div/div/div/div[2]/label/span/span[1]/span");
    }
}
