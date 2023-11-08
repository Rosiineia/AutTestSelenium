import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DesafioCadastrocomSucesso {

	@Test
	public void desafioCadastroSucesso() {
		WebDriver driver = new ChromeDriver();
		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		// Assert.assertEquals("Campo de Treinamento", driver.getTitle());
		driver.findElement(By.id("elementosForm:nome")).sendKeys("Rosineia");
		driver.findElement(By.id("elementosForm:sobrenome")).sendKeys("Jesus");
		
		// ********************SEXO*************************************************
		driver.findElement(By.id("elementosForm:sexo:1")).click();
		Assert.assertTrue(driver.findElement(By.id("elementosForm:sexo:1")).isSelected());

		// **********************COMIDA FAVORITA*******************
		driver.findElement(By.id("elementosForm:comidaFavorita:0")).click();
		Assert.assertTrue(driver.findElement(By.id("elementosForm:comidaFavorita:0")).isSelected());
		// ************ESCOLARIDADE*******************
		WebElement element = driver.findElement(By.id("elementosForm:escolaridade"));
		Select combo = new Select(element);
		// COMO chamar

		combo.selectByVisibleText("Superior");

		// CoNferir

		Assert.assertEquals("Superior", combo.getFirstSelectedOption().getText());

		// *************ESPORTE****************
		new Select(driver.findElement(By.id("elementosForm:esportes"))).selectByVisibleText("Futebol");
		//***************SUGESTÃO**************
		driver.findElement(By.id("elementosForm:sugestoes")).sendKeys("Teste Sugestões");
		
		//************CADASTRAR**************************
		driver.findElement(By.id("elementosForm:cadastrar")).click();
		
		
		//***********RESULTADO DO CADASTRO************
		Assert.assertTrue(driver.findElement(By.id("resultado")).getText().startsWith("Cadastrado!"));
		
		Assert.assertEquals("Nome: Rosineia",driver.findElement(By.id("descNome")).getText());
		
		Assert.assertEquals("Sobrenome: Jesus",driver.findElement(By.id("descSobrenome")).getText());
		
		Assert.assertEquals("Sexo: Feminino",driver.findElement(By.id("descSexo")).getText());
		Assert.assertEquals("Comida: Carne",driver.findElement(By.id("descComida")).getText());
		Assert.assertEquals("Escolaridade: superior",driver.findElement(By.id("descEscolaridade")).getText());
		Assert.assertEquals("Esportes: Futebol",driver.findElement(By.id("descEsportes")).getText());
		Assert.assertEquals("Sugestoes: Teste Sugestões",driver.findElement(By.id("descSugestoes")).getText());
		
		
		

		//driver.quit(); // (Fecha a pagina
	}

}
