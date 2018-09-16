/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bt.com.bts.cursoselenium;

import org.openqa.selenium.WebDriver;

/**
 *
 * @author davicfg
 */
public class CampoTreinamentoPage {

    private DSL dsl;

    public CampoTreinamentoPage(WebDriver driver) {
        this.dsl = new DSL(driver);
    }

    public void setNome(String nome) {
        dsl.escrever("elementosForm:nome", nome);
    }

    public void setSobrenome(String sobrenome) {
        dsl.escrever("elementosForm:sobrenome", sobrenome);
    }

    public void setSexoMasculino() {
        dsl.clicarRadio("elementosForm:sexo:0");
    }

    public void setSexoFeminino() {
        dsl.clicarRadio("elementosForm:sexo:1");
    }

    public void setComidaCarne() {
        dsl.clicarRadio("elementosForm:comidaFavorita:0");
    }

    public void setComidaFrango() {
        dsl.clicarRadio("elementosForm:comidaFavorita:0");
    }

    public void setComidaPizza() {
        dsl.clicarRadio("elementosForm:comidaFavorita:0");
    }

    public void setComidaVegetariano() {
        dsl.clicarRadio("elementosForm:comidaFavorita:0");
    }

    public void setEscolaridade(String escolaridade) {
        dsl.selecionarCombo("elementosForm:escolaridade", escolaridade);
    }
    
    public void setEsporte(String esporte){
        dsl.selecionarCombo("elementosForm:esportes", esporte);
    }
    
    public void cadastrar(){
        dsl.clicarBotao("elementosForm:cadastrar");
    }

    public String obterResultadoCadastro() {
        return dsl.obterTexto("resultado");
    }

    public String obterNomeCadastro() {
        return dsl.obterTexto("descNome");
    }

    public String obterSobrenomeCadastro() {
        return dsl.obterTexto("descSobrenome");
    }

    public String obterSexoCadastro() {
        return dsl.obterTexto("descSexo");
    }

    public String obterComidaCadastro() {
        return dsl.obterTexto("descComida");
    }

    public String obterEscolaridadeCadastro() {
        return dsl.obterTexto("descEscolaridade");
    }
}
