import java.util.List;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;



public class TesteCampoTreinamento {

	@Test
	public void teste() {
		WebDriver driver = new FirefoxDriver();
		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		Assert.assertEquals("Campo de Treinamento", driver.getTitle());

		//driver.quit(); // (Fecha a pagina
	}

	@SuppressWarnings("deprecation")
	@Test
	public void testeField() {
		WebDriver driver = new ChromeDriver();
		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		// Assert.assertEquals("Campo de Treinamento", driver.getTitle());
		driver.findElement(By.id("elementosForm:nome")).sendKeys("Teste da escrita");
		// driver.findElement(By.id("elementosForm:sobrenome")).sendKeys("Teste
		// Sobrenome");
		// driver.findElement(By.id("elementosForm:sugestoes")).sendKeys("Teste
		// Sugestões");

		Assert.assertEquals("Teste da escrita", driver.findElement(By.id("elementosForm:nome")).getAttribute("value"));

		driver.quit(); // (Fecha a pagina
	}

	@Test
	public void deveInteragirComTextArea() {
		WebDriver driver = new ChromeDriver();
		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		// Assert.assertEquals("Campo de Treinamento", driver.getTitle());
		driver.findElement(By.id("elementosForm:sugestoes")).sendKeys("teste Sugestões\n\nssajj\n ultima linha");
		// Assert.assertEquals("Teste Sugestões",
		// driver.findElement(By.id("elementosForm:sugestoes")).getAttribute("value"));

		driver.quit();

	}

	@Test
	public void deveInteragirComRadioButon() {
		WebDriver driver = new ChromeDriver();
		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		driver.findElement(By.id("elementosForm:sexo:1")).click();
		Assert.assertTrue(driver.findElement(By.id("elementosForm:sexo:1")).isSelected());

		driver.quit(); // (Fecha a pagina

	}

	@Test
	public void deveInteragirComCheckbox() {

		WebDriver driver = new ChromeDriver();
		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		driver.findElement(By.id("elementosForm:comidaFavorita:3")).click();
		Assert.assertTrue(driver.findElement(By.id("elementosForm:comidaFavorita:3")).isSelected());

		driver.quit(); // (Fecha a pagina;

	}

	@Test
	public void deveInteragirComCombo() {

		WebDriver driver = new ChromeDriver();
		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		WebElement element = driver.findElement(By.id("elementosForm:escolaridade"));
		Select combo = new Select(element);

		// Três formas de chamar

		// combo.selectByIndex(3);
		// combo.selectByValue("mestrado");
		combo.selectByVisibleText("Superior");

		// Coferir

		Assert.assertEquals("Superior", combo.getFirstSelectedOption().getText());

		driver.quit(); // (Fecha a pagina;
	}

	@Test
	public void deveverificarValoresCombo() {

		WebDriver driver = new ChromeDriver();
		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		WebElement element = driver.findElement(By.id("elementosForm:escolaridade"));
		Select combo = new Select(element);
		List<WebElement> options = combo.getOptions();
		Assert.assertEquals(9, options.size());

		boolean encontrou = false;
		for (WebElement option : options) {
			if (option.getText().equals("1o grau completo")) {
				encontrou = true;
				break;
			}
		}
		Assert.assertTrue(encontrou);

		driver.quit();
	}

	@Test
	public void deveverificarValoresComboMultiplo() {

		WebDriver driver = new ChromeDriver();
		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		WebElement element = driver.findElement(By.id("elementosForm:esportes"));
		Select combo = new Select(element);
		combo.selectByVisibleText("Natacao");
		combo.selectByVisibleText("Corrida");
		combo.selectByVisibleText("O que eh esporte?");

		// verifica a quantidade de elementos
		List<WebElement> allSelectdOptions = combo.getAllSelectedOptions();
		Assert.assertEquals(3, allSelectdOptions.size());

		// desmarcar algum item

		combo.deselectByVisibleText("Corrida");

		// verifica a quantidade de elementos
		allSelectdOptions = combo.getAllSelectedOptions();
		Assert.assertEquals(2, allSelectdOptions.size());

		driver.quit();
	}

	@Test
	public void deveinteragirComBotoes() {

		WebDriver driver = new ChromeDriver();
		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		WebElement botao = driver.findElement(By.id("buttonSimple"));
		botao.click();

		Assert.assertEquals("Obrigado!", botao.getAttribute("value"));

		driver.quit();

	}

	@Test
	// @Ignore //Diz para não executar, pois é um teste com "falso positivo"
	public void deveinteragirComLink() {

		WebDriver driver = new ChromeDriver();
		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		driver.findElement(By.linkText("Voltar")).click();

		Assert.assertEquals("Voltou!", driver.findElement(By.id("resultado")).getText());

		driver.quit();
	}

	@Test
	public void deveBuscarTextosNaPagina() {

		WebDriver driver = new ChromeDriver();
		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");

		// Imprime o todo texto da pagina no console

		// System.out.println(driver.findElement(By.tagName("body")).getText());

		//// Imprime uma palavra da pagina no console

		// System.out.println(driver.findElement(By.tagName("body")).getText().contains("Campo
		// de Treinamento"));

		// Veririca a solicitação de palavra na pagina

		// Assert.assertTrue(driver.findElement(By.tagName("body")).getText().contains("Campo
		// de Treinamento"));

		// Veririca o local especifico da palavra na pagina o mais "correto"

		Assert.assertEquals("Campo de Treinamento", driver.findElement(By.tagName("h3")).getText());

		System.out.println(driver.findElement(By.tagName("h3")).getText());

		// busca 2

		Assert.assertEquals("Cuidado onde clica, muitas armadilhas...",driver.findElement(By.className("facilAchar")).getText());
		
		System.out.println(driver.findElement(By.className("facilAchar")).getText());

		driver.quit();
	}
}
