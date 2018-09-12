/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bt.com.bts.cursoselenium;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.Select;

/**
 *
 * @author davi
 */
public class CampoTreinamento {
    public static void main(String[] args) {
        System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"/src/main/recursos/geckodriver");
        DesiredCapabilities capabilities = DesiredCapabilities.firefox();
        capabilities.setCapability("marionette", true);
        WebDriver driver = new FirefoxDriver(capabilities);
        driver.manage().window().maximize();  
        
        //CAMPO IMPUT
        driver.get("file:///"+System.getProperty("user.dir")+"/src/main/recursos/componentes.html");
        System.out.println(driver.getTitle()); 
        WebElement input = driver.findElement(By.id("elementosForm:nome"));
        input.sendKeys("Davi");
        System.err.println("INPUT");
        System.err.println("Davi".equals(input.getAttribute("value")));
        
        //TEXT AREA
        driver.get("file:///"+System.getProperty("user.dir")+"/src/main/recursos/componentes.html");
        System.out.println(driver.getTitle()); 
        WebElement caixaTexto = driver.findElement(By.id("elementosForm:sugestoes"));
        caixaTexto.sendKeys("Fazer cussos.");
        System.err.println("TEXT AREA");
        System.err.println("Fazer cussos.".equals(caixaTexto.getAttribute("value")));
        
        //RADIO
        driver.get("file:///"+System.getProperty("user.dir")+"/src/main/recursos/componentes.html");
        System.out.println(driver.getTitle()); 
        WebElement rButton = driver.findElement(By.id("elementosForm:sexo:0"));
        rButton.click();
        System.err.println("RADIO");
        System.err.println(rButton.isSelected());
        
        //SELECT
        driver.get("file:///"+System.getProperty("user.dir")+"/src/main/recursos/componentes.html");
        System.out.println(driver.getTitle()); 
        WebElement element = driver.findElement(By.id("elementosForm:escolaridade"));
        Select select = new Select(element);
//        select.selectByIndex(2);
//        select.selectByValue("2grauincomp");
        select.selectByVisibleText("2o grau completo");
        System.err.println("SELECT");
        System.err.println(select.getOptions().get(0).getAttribute("value"));
        
        List<WebElement> opcoes = select.getOptions();
        for (WebElement opcao : opcoes) {
            System.err.println(opcao.getText());
        }
        
        //COMBO MULTI
        driver.get("file:///"+System.getProperty("user.dir")+"/src/main/recursos/componentes.html");
        System.out.println(driver.getTitle()); 
        WebElement esporte = driver.findElement(By.id("elementosForm:esportes"));
        Select selectCombo = new Select(esporte);
//        select.selectByIndex(2);
//        select.selectByValue("2grauincomp");
        selectCombo.selectByVisibleText("Corrida");
        selectCombo.selectByVisibleText("Natacao");
        System.err.println("SELECT COMBO");
        System.err.println(selectCombo.getOptions().get(0).getAttribute("value"));
        
        List<WebElement> opcoesCombo = selectCombo.getOptions();
        for (WebElement opcao : opcoesCombo) {
            System.err.println(opcao.getText());
        }
        
        //ALERTAS
        
        
        try {
            Thread.sleep(10000);
        } catch (InterruptedException ex) {
            System.err.println(ex.getMessage());
        }
        
        
        driver.quit();
        
    }
}
