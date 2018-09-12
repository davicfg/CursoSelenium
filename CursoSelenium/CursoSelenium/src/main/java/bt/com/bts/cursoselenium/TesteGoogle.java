/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bt.com.bts.cursoselenium;

import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

/**
 *
 * @author davicfg
 */
public class TesteGoogle {
    public static void main(String[] args) {
        System.out.println("Hello World!");
        System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"/src/main/recursos/geckodriver");
        DesiredCapabilities capabilities = DesiredCapabilities.firefox();
        capabilities.setCapability("marionette", true);
        WebDriver driver = new FirefoxDriver(capabilities);
        driver.get("http://www.google.com");
        driver.manage().window().maximize();  
        driver.quit();
    }
}
