/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bt.com.bts.cursoselenium;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

/**
 *
 * @author davi
 */
public class TesteAlertas {
    public static void main(String[] args) throws InterruptedException {
        if (System.getProperty("os.name").equals("Mac OS X")) {
            System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"/src/main/recursos/geckodriver_mac");
        } else if (System.getProperty("os.name").equals("Linux")) {
             System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"/src/main/recursos/geckodriver_linux");
        }
        DesiredCapabilities capabilities = DesiredCapabilities.firefox();
        capabilities.setCapability("marionette", true);
        WebDriver driver = new FirefoxDriver(capabilities);
        driver.manage().window().maximize();  
        
        DSL dsl = new DSL(driver);
        
        //ALERT SIMPLES
        driver.get("file:///"+System.getProperty("user.dir")+"/src/main/recursos/componentes.html");
//        driver.findElement(By.id("alert")).click();
        dsl.clicarBotao("alert");
        Alert alert = driver.switchTo().alert();
        System.out.println("ALERTA ");
        System.err.println(dsl.alertaObterTextoEAceita());
        alert.accept();
        
        driver.findElement(By.id("elementosForm:nome")).sendKeys("Texto");
        
        //ALERTA CONFIRMA
        driver.get("file:///"+System.getProperty("user.dir")+"/src/main/recursos/componentes.html");
//        driver.findElement(By.id("confirm")).click();
        dsl.clicarBotao("confirm");
        Alert alertConfirm = driver.switchTo().alert();
        System.out.println("ALERTA CONFIRMA");
        System.err.println(dsl.alertaObterTextoEAceita());
        
        driver.findElement(By.id("elementosForm:nome")).sendKeys("Texto");
        
        
        //PROMPT
        driver.get("file:///"+System.getProperty("user.dir")+"/src/main/recursos/componentes.html");
        dsl.clicarBotao("prompt");
        System.out.println("ALERTA PROMPT");
        Thread.sleep(3000);
        dsl.alertaEscrever("12");
        Thread.sleep(3000);
        driver.switchTo().alert().accept();
        driver.switchTo().alert().accept();
        driver.switchTo().alert().accept();
        
//        FRAMES
        driver.get("file:///"+System.getProperty("user.dir")+"/src/main/recursos/componentes.html");
        driver.switchTo().frame("frame1");
        driver.findElement(By.id("frameButton")).click();
        Alert alertaFrame = driver.switchTo().alert();
        System.out.println("ALERTA IFRAME");
        System.err.println(alertaFrame.getText());
        alert.accept();
        driver.switchTo().defaultContent();
        driver.findElement(By.id("elementosForm:nome")).sendKeys("Texto");
        driver.quit();
    }
}
