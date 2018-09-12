/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import static org.junit.Assert.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 *
 * @author davicfg
 */
public class CampoTreinamentoTest {
    
    @Test
    public void testeTextField(){
        System.setProperty("webdriver.gecko.driver", "../geckodriver");
        WebDriver driver = new FirefoxDriver();
        driver.manage().window().setPosition(new Point(2000, 0));
        driver.manage().window().maximize();
        driver.get("file:///"+System.getProperty("user.dir")+"/src/main/recursos/componentes.html");
        System.out.println(driver.getTitle()); 
        WebElement input = driver.findElement(By.id("elementosForm:nome"));
        input.sendKeys("Davi");
        Assert.assertEquals("Davi", input.getAttribute("value"));
        
        driver.quit();
    }
    @Test
    public void testeTextArea(){
        System.setProperty("webdriver.gecko.driver", "../geckodriver");
        WebDriver driver = new FirefoxDriver();
        driver.manage().window().setPosition(new Point(2000, 0));
        driver.manage().window().maximize();
        driver.get("file:///"+System.getProperty("user.dir")+"/src/main/recursos/componentes.html");
        System.out.println(driver.getTitle()); 
        WebElement caixaTexto = driver.findElement(By.id("elementosForm:sugestoes"));
        caixaTexto.sendKeys("Fazer cussos.");
        Assert.assertEquals("Fazer cussos.", caixaTexto.getAttribute("value"));
        
        driver.quit()   ;
    }
    
    @Test
    public void testeRadioButton(){
        System.setProperty("webdriver.gecko.driver", "../geckodriver");
        WebDriver driver = new FirefoxDriver();
        driver.manage().window().setPosition(new Point(2000, 0));
        driver.manage().window().maximize();
        driver.get("file:///"+System.getProperty("user.dir")+"/src/main/recursos/componentes.html");
        System.out.println(driver.getTitle()); 
        WebElement rButton = driver.findElement(By.id("elementosForm:sexo:0"));
        rButton.click();
        Assert.assertTrue(rButton.isSelected());
        driver.quit()   ;
    }
}
