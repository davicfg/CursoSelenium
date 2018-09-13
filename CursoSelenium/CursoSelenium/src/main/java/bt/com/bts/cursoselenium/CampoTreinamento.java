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
        
        //CAMPO IMPUT
        driver.get("file:///"+System.getProperty("user.dir")+"/src/main/recursos/componentes.html");
        System.out.println(driver.getTitle()); 
        dsl.escrever("elementosForm:nome", "Davi");
        System.err.println("INPUT");
        System.err.println("Davi".equals(dsl.obterValorCampo("elementosForm:nome")));
        
        //TEXT AREA
        driver.get("file:///"+System.getProperty("user.dir")+"/src/main/recursos/componentes.html");
        System.out.println(driver.getTitle()); 
        dsl.escrever("elementosForm:sugestoes","Fazer cussos.");
        System.err.println("TEXT AREA");
        System.err.println("Fazer cussos.".equals(dsl.obterValorCampo("elementosForm:sugestoes")));
        
        //RADIO
        driver.get("file:///"+System.getProperty("user.dir")+"/src/main/recursos/componentes.html");
        System.out.println(driver.getTitle()); 
        dsl.clicarRadio("elementosForm:sexo:0");
        
        System.err.println("RADIO");
        System.err.println(dsl.isRadioMarcado("elementosForm:sexo:0"));
        
        //SELECT
        driver.get("file:///"+System.getProperty("user.dir")+"/src/main/recursos/componentes.html");
        dsl.selecionarCombo("elementosForm:escolaridade", "2o grau completo");
        System.err.println("SELECT");
        System.err.println(dsl.obterValorCombo("elementosForm:escolaridade"));
        
        //COMBO MULTI
        driver.get("file:///"+System.getProperty("user.dir")+"/src/main/recursos/componentes.html");
        System.out.println(driver.getTitle()); 
        dsl.selecionarCombo("elementosForm:esportes", "Corrida");
        dsl.selecionarCombo("elementosForm:esportes", "Natacao");
        
        WebElement esporte = driver.findElement(By.id("elementosForm:esportes"));
        Select selectCombo = new Select(esporte);
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
