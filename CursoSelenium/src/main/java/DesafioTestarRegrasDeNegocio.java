import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;



public class DesafioTestarRegrasDeNegocio {
	
	@Test
	public void deveValidarNomeObrigatorio() {
		WebDriver driver = new ChromeDriver();
		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");	
		
		
		//************BOTÃO CADASTRAR**************************
				driver.findElement(By.id("elementosForm:cadastrar")).click();
				Alert alert = driver.switchTo().alert();
				Assert.assertEquals("Nome eh obrigatorio", alert.getText());
				driver.quit();
	}
	@Test
	public void deveValidarSobrenomeObrigatorio() {
		WebDriver driver = new ChromeDriver();
		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		
		driver.findElement(By.id("elementosForm:nome")).sendKeys("Rosineia");		
		
		//************BOTÃO CADASTRAR**************************
				driver.findElement(By.id("elementosForm:cadastrar")).click();
				Alert alert = driver.switchTo().alert();
				Assert.assertEquals("Sobrenome eh obrigatorio", alert.getText());
				driver.quit();
	}
	
	@Test
	public void deveValidarOpcaoSexualObrigatorio() {
		WebDriver driver = new ChromeDriver();
		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		//CADASTRO
		driver.findElement(By.id("elementosForm:nome")).sendKeys("Rosineia");
		driver.findElement(By.id("elementosForm:sobrenome")).sendKeys("Jesus");
		
		//************BOTÃO CADASTRAR**************************
				driver.findElement(By.id("elementosForm:cadastrar")).click();
				Alert alert = driver.switchTo().alert();
				Assert.assertEquals("Sexo eh obrigatorio", alert.getText());
				driver.quit();
	}
	
	@Test
	public void deveValidarComidaObrigatorio() {
		WebDriver driver = new ChromeDriver();
		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		//CADASTRO
		driver.findElement(By.id("elementosForm:nome")).sendKeys("Rosineia");
		driver.findElement(By.id("elementosForm:sobrenome")).sendKeys("Jesus");
		driver.findElement(By.id("elementosForm:sexo:1")).click();
		driver.findElement(By.id("elementosForm:comidaFavorita:0")).click();
		driver.findElement(By.id("elementosForm:comidaFavorita:3")).click();
		
		//************BOTÃO CADASTRAR**************************
				driver.findElement(By.id("elementosForm:cadastrar")).click();
				Alert alert = driver.switchTo().alert();
				Assert.assertEquals("Tem certeza que voce eh vegetariano?", alert.getText());
				driver.quit();
	}
	
	@Test
	public void deveValidarPratiDeEsporteObrigatorio() {
		WebDriver driver = new ChromeDriver();
		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		//CADASTRO
		driver.findElement(By.id("elementosForm:nome")).sendKeys("Rosineia");
		driver.findElement(By.id("elementosForm:sobrenome")).sendKeys("Jesus");
		driver.findElement(By.id("elementosForm:sexo:1")).click();
		driver.findElement(By.id("elementosForm:comidaFavorita:0")).click();
		new Select(driver.findElement(By.id("elementosForm:esportes"))).selectByVisibleText("Corrida");
		new Select(driver.findElement(By.id("elementosForm:esportes"))).selectByVisibleText("O que eh esporte?");
		
		//************BOTÃO CADASTRAR**************************
				driver.findElement(By.id("elementosForm:cadastrar")).click();
				Alert alert = driver.switchTo().alert();
				Assert.assertEquals("Voce faz esporte ou nao?", alert.getText());
				driver.quit();
	}
}
