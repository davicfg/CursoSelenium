
import bt.com.bts.cursoselenium.CampoTreinamentoPage;
import bt.com.bts.cursoselenium.DSL;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author davicfg
 */
public class FramesEJanelasTest {

    private WebDriver driver;
    private CampoTreinamentoPage page;
    private DSL dsl;

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
        dsl = new DSL(driver);
    }

    @After
    public void finaliza() {
        driver.quit();
    }

    @Test
    public void deveInteragirComFrameEscondido() {
        WebElement element = driver.findElement(By.id("frame2"));
        dsl.executarJS("window.scrollBy(0, arguments[0])", element.getLocation().y);
        dsl.entrarFrame("frame2");
        dsl.clicarBotao("frameButton");
        String msg = dsl.alertaObterTextoEAceita();
        Assert.assertEquals("Frame OK!", msg);
    }
}
