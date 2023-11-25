package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.example.Settings.BROWSER;

public class WebBrowser {

   public static WebDriver get() {
      WebDriver driver;
      switch (BROWSER) {
         case "Chrome":
            System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\chromedriver.exe");
            driver = new ChromeDriver();
            break;
         case "Yandex":
            System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\yandexdriver.exe");
            driver = new ChromeDriver();
            break;
         default:
            throw new RuntimeException("Некорректный тип браузера. Может быть: \"Chrome\" или \"Yandex\"");
      }

      return driver;
   }

}
