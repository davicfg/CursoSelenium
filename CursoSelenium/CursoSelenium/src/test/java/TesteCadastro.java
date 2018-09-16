
import bt.com.bts.cursoselenium.CampoTreinamentoPage;
import bt.com.bts.cursoselenium.DSL;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TesteCadastro {

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
        dsl = new DSL(driver);
        page = new CampoTreinamentoPage(driver);
    }

    @After
    public void finaliza() {
        driver.quit();
    }

    @Test
    public void deveRealizarCadastroComSucesso() {
//        dsl.escrever("elementosForm:sobrenome", "Davi");
        page.setNome( "Wagner");
//        dsl.escrever("elementosForm:sobrenome", "Costa");
        page.setSobrenome("Costa");
//        dsl.clicarRadio("elementosForm:sexo:0");
        page.setSexoMasculino();
//        dsl.clicarRadio("elementosForm:comidaFavorita:2");
        page.setComidaPizza();
//        dsl.selecionarCombo("elementosForm:escolaridade", "Mestrado");;
        page.setEscolaridade("Mestrado");
//        dsl.selecionarCombo("elementosForm:esportes", "Natacao");
        page.setEsporte("Natacao");
//        dsl.clicarBotao("elementosForm:cadastrar");
        page.cadastrar();
        Assert.assertTrue(page.obterResultadoCadastro().startsWith("Cadastrado!"));
        Assert.assertTrue(page.obterNomeCadastro().endsWith("Wagner"));
        Assert.assertEquals("Sobrenome: Costa", page.obterSobrenomeCadastro());
        Assert.assertEquals("Sexo: Masculino", page.obterSexoCadastro());
        Assert.assertEquals("Comida: Pizza", page.obterComidaCadastro());
        Assert.assertEquals("Escolaridade: mestrado", page.obterEscolaridadeCadastro());
        Assert.assertEquals("Esportes: Natacao", dsl.obterTexto("descEsportes"));
    }

    @Test
    public void deveValidarNomeObrigatorio() {
        dsl.clicarBotao("elementosForm:cadastrar");
        Assert.assertEquals("Nome eh obrigatorio", dsl.alertaObterTextoEAceita());
    }

    @Test
    public void deveValidarSobrenomeObrigatorio() {
        dsl.escrever("elementosForm:nome", "Nome qualquer");
        dsl.clicarBotao("elementosForm:cadastrar");
        Assert.assertEquals("Sobrenome eh obrigatorio", dsl.alertaObterTextoEAceita());
    }

    @Test
    public void deveValidarSexoObrigatorio() {
        dsl.escrever("elementosForm:nome", "Nome qualquer");
        dsl.escrever("elementosForm:sobrenome", "Sobrenome qualquer");
        dsl.clicarBotao("elementosForm:cadastrar");
        Assert.assertEquals("Sexo eh obrigatorio", dsl.alertaObterTextoEAceita());
    }

    @Test
    public void deveValidarComidaVegetariana() {
        dsl.escrever("elementosForm:nome", "Nome qualquer");
        dsl.escrever("elementosForm:sobrenome", "Sobrenome qualquer");
        dsl.clicarRadio("elementosForm:sexo:1");
        dsl.clicarRadio("elementosForm:comidaFavorita:0");
        dsl.clicarRadio("elementosForm:comidaFavorita:3");
        dsl.clicarBotao("elementosForm:cadastrar");
        Assert.assertEquals("Tem certeza que voce eh vegetariano?", dsl.alertaObterTextoEAceita());
    }

    @Test
    public void deveValidarEsportistaIndeciso() {
        dsl.escrever("elementosForm:nome", "Nome qualquer");
        dsl.escrever("elementosForm:sobrenome", "Sobrenome qualquer");
        dsl.clicarRadio("elementosForm:sexo:1");
        dsl.clicarRadio("elementosForm:comidaFavorita:0");
        dsl.selecionarCombo("elementosForm:esportes", "Karate");
        dsl.selecionarCombo("elementosForm:esportes", "O que eh esporte?");
        dsl.clicarBotao("elementosForm:cadastrar");
        Assert.assertEquals("Voce faz esporte ou nao?", dsl.alertaObterTextoEAceita());
    }
}
