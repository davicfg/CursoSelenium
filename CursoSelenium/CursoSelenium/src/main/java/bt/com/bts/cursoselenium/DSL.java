/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bt.com.bts.cursoselenium;

import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

/**
 *
 * @author davicfg
 */
public class DSL {

    private WebDriver driver;

    public DSL(WebDriver driver) {
        this.driver = driver;
    }

    /**
     * ******* TextField e TextArea ***********
     */
    public void escrever(String id_campo, String texto) {
        escrever(By.id(id_campo), texto);
    }

    public void escrever(By by, String texto) {
        driver.findElement(by).clear();
        driver.findElement(by).sendKeys(texto);
    }

    public String obterValorCampo(String id_campo) {
        return driver.findElement(By.id(id_campo)).getAttribute("value");
    }

    /**
     * ******* Radio e Check ***********
     */
    public void clicarRadio(String id_campo) {
        driver.findElement(By.id(id_campo));
    }

    public boolean isRadioMarcado(String id_campo) {
        return driver.findElement(By.id(id_campo)).isSelected();
    }

    public void clicarCheck(String id) {
        driver.findElement(By.id(id)).click();
    }

    public boolean isCheckMarcado(String id) {
        return driver.findElement(By.id(id)).isSelected();
    }

    /**
     * ******* Combo ***********
     */
    public void selecionarCombo(String id, String valor) {
        WebElement element = driver.findElement(By.id(id));
        Select select = new Select(element);
        select.selectByVisibleText(valor);
    }

    public void deselecionarCombo(String id, String valor) {
        WebElement element = driver.findElement(By.id(id));
        Select select = new Select(element);
        select.deselectByValue(valor);
    }

    public String obterValorCombo(String id) {
        WebElement element = driver.findElement(By.id(id));
        Select select = new Select(element);
        return select.getFirstSelectedOption().getText();
    }

    public List<String> obterValoresCombo(String id) {
        WebElement element = driver.findElement(By.id(id));
        Select select = new Select(element);
        List<WebElement> todasOcoesSelecionadas = select.getAllSelectedOptions();
        List<String> valores = new ArrayList<>();
        for (WebElement opcao : todasOcoesSelecionadas) {
            valores.add(opcao.getText());
        }
        return valores;
    }

    /**
     * ******* Botao ***********
     */
    public void clicarBotao(String id_btn) {
        driver.findElement(By.id(id_btn));
    }

    public String obterValorElemento(String id_campo) {
        return obterValorElemento(By.id(id_campo));
    }

    public String obterValorElemento(By by) {
        return driver.findElement(by).getAttribute("value");
    }

    /**
     * ******* Link ***********
     */
    public void clicarLink(String link_txt) {
        driver.findElement(By.linkText(link_txt)).click();
    }

    /**
     * ******* Texto ***********
     */
    public String obterTexto(String id) {
        return obterTexto(By.id(id));
    }

    public String obterTexto(By by) {
        return driver.findElement(by).getText();
    }

    /**
     * ******* Alertas ***********
     */
    public String alertaObterTexto() {
        Alert alert = driver.switchTo().alert();
        return alert.getText();
    }

    public String alertaObterTextoEAceita() {
        Alert alert = driver.switchTo().alert();
        String valor = alert.getText();
        alert.accept();
        return valor;

    }

    public String alertaObterTextoENega() {
        Alert alert = driver.switchTo().alert();
        String valor = alert.getText();
        alert.dismiss();
        return valor;

    }

    public void alertaEscrever(String valor) {
        Alert alert = driver.switchTo().alert();
        alert.sendKeys(valor);
        alert.accept();
    }
    
    /**
     * ******* Alertas ***********
     */
    
    public void entrarFrame(String id){
        driver.switchTo().frame(id);
    }
    
    public void sairFrame(String id){
        driver.switchTo().defaultContent();
    }
    
    public void trocarJanela(String id){
        driver.switchTo().window(id);
    }
}