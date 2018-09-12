/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bt.com.bts.cursoselenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

/**
 *
 * @author davi
 */
public class JanelaGenerica {
    public static void main(String[] args) {
        System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"/src/main/recursos/geckodriver");
        DesiredCapabilities capabilities = DesiredCapabilities.firefox();
        capabilities.setCapability("marionette", true);
        WebDriver driver = new FirefoxDriver(capabilities);
        
        driver.get("file:///"+System.getProperty("user.dir")+"/src/main/recursos/componentes.html");
        driver.findElement(By.id("buttonPopUpHard")).click();
        driver.switchTo().window("Popup");
        driver.findElement(By.tagName("textarea")).sendKeys("DAVI CARVALHO");
        driver.close();
        driver.switchTo().window("");
        
        driver.findElement(By.tagName("textarea")).sendKeys("DAVI CARVALHO");
    }
}
