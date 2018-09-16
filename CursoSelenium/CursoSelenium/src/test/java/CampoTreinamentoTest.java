/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import bt.com.bts.cursoselenium.CampoTreinamentoPage;
import bt.com.bts.cursoselenium.DSL;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Ignore;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 *
 * @author davicfg
 */
public class CampoTreinamentoTest {

    private WebDriver driver;
    private DSL dsl;
    private CampoTreinamentoPage page;

    @Before
    public void inicializa() {
        if (System.getProperty("os.name").equals("Mac OS X")) {
            System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "/src/main/recursos/geckodriver_mac");
        } else if (System.getProperty("os.name").equals("Linux")) {
            System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "/src/main/recursos/geckodriver_linux");
        }
        driver = new FirefoxDriver();
        driver.manage().window().setSize(new Dimension(1200, 765));
        driver.get("file:///" + System.getProperty("user.dir") + "/src/main/recursos/componentes.html");
        page = new CampoTreinamentoPage(driver);
    }

    @After
    public void finaliza() {
        driver.quit();
    }

    @Test
    public void testeTextField() {
        driver.manage().window().setPosition(new Point(2000, 0));
        driver.manage().window().maximize();
        driver.get("file:///" + System.getProperty("user.dir") + "/src/main/recursos/componentes.html");
        System.out.println(driver.getTitle());
        WebElement input = driver.findElement(By.id("elementosForm:nome"));
        input.sendKeys("Davi");
        Assert.assertEquals("Davi", input.getAttribute("value"));
    }

    @Test
    public void testeTextArea() {
        driver.manage().window().setPosition(new Point(2000, 0));
        driver.manage().window().maximize();
        driver.get("file:///" + System.getProperty("user.dir") + "/src/main/recursos/componentes.html");
        System.out.println(driver.getTitle());
        WebElement caixaTexto = driver.findElement(By.id("elementosForm:sugestoes"));
        caixaTexto.sendKeys("Fazer cussos.");
        Assert.assertEquals("Fazer cussos.", caixaTexto.getAttribute("value"));
    }

    @Test
    public void testeRadioButton() {
        driver.manage().window().setPosition(new Point(2000, 0));
        driver.manage().window().maximize();
        driver.get("file:///" + System.getProperty("user.dir") + "/src/main/recursos/componentes.html");
        System.out.println(driver.getTitle());
        WebElement rButton = driver.findElement(By.id("elementosForm:sexo:0"));
        rButton.click();
        Assert.assertTrue(rButton.isSelected());
    }

    @Test
    public void testJavascript() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("document.getElementById('elementosForm:nome').value = 'Escrito via js'");
        js.executeScript("document.getElementById('elementosForm:sobrenome').type = 'radio'");

        WebElement element = driver.findElement(By.id("elementosForm:nome"));
        js.executeScript("arguments[0].style.border = arguments[1]", element, "solid 4px red");
    }
}
