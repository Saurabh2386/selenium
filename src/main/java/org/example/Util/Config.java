package org.example.Util;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.io.FileInputStream;
import java.util.Properties;

public class Config {

    private static  WebDriver driver = null;

    public static String getProperty(String prop) {
        Properties properties = null;
        try {
            FileInputStream fs = new FileInputStream(System.getProperty("user.dir") + "\\properties\\application.properties");
            properties =new Properties();
            properties.load(fs);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return properties.getProperty(prop);
    }
    public static WebDriver setDriver(){
        String browser = getProperty("browser");
        System.out.println(browser);
        if(browser.equalsIgnoreCase("chrome")){
           driver = new ChromeDriver();
           WebDriverManager.chromedriver().setup();
        }
        else if(browser.equalsIgnoreCase("edge")){
            driver = new EdgeDriver();
            WebDriverManager.edgedriver().setup();
        }
        else if(browser.equalsIgnoreCase("firefox")){
            driver = new FirefoxDriver();
            WebDriverManager.firefoxdriver().setup();
        }

        driver.manage().window().maximize();
        driver.get(getProperty("url"));

        return driver;
    }

    public static WebElement element(By by){
        WebElement element = driver.findElement(by);
        return element;
    }

    public static void closeWindow(){
        driver.close();
        driver.quit();
    }

    public static void closeWindow(int time){
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.close();
        driver.quit();
    }
}
