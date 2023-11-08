import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestAlert {

	@Test
	public void deveInteragirComAlertSimples() {

		WebDriver driver = new ChromeDriver();
		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");

		driver.findElement(By.id("alert")).click();

		// pedir ao selenium para acessar o alerta que está externo

		Alert alert = driver.switchTo().alert();
		String texto = alert.getText();
		Assert.assertEquals("Alert Simples", texto);
		alert.accept();

		// Escreve a msg do alert no "nome" formulario

		driver.findElement(By.id("elementosForm:nome")).sendKeys(texto);

		// driver.quit();
	}

	@Test
	public void deveInteragirComAlertConfirm() {

		WebDriver driver = new ChromeDriver();
		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");

		driver.findElement(By.id("confirm")).click();

		// pedir ao selenium para acessar o alerta que está externo

		Alert alerta = driver.switchTo().alert();
		// String texto = alert.getText();
		Assert.assertEquals("Confirm Simples", alerta.getText());
		alerta.accept();
		Assert.assertEquals("Confirmado", alerta.getText());
		alerta.accept();

		// CANCELANDO ALERTA
		driver.findElement(By.id("confirm")).click();
		alerta = driver.switchTo().alert();
		// String texto = alert.getText();
		Assert.assertEquals("Confirm Simples", alerta.getText());
		alerta.dismiss();
		Assert.assertEquals("Negado", alerta.getText());
		alerta.dismiss();

		driver.quit();

		// Escreve a msg do alert no "nome" formulario

		// driver.findElement(By.id("elementosForm:nome")).sendKeys(alerta.getText());

		// driver.quit();
	}

	@Test
	public void deveInteragirComAlertPrompt() {

		WebDriver driver = new ChromeDriver();
		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");

		driver.findElement(By.id("prompt")).click();
		Alert alerta = driver.switchTo().alert();
		Assert.assertEquals("Digite um numero", alerta.getText());
		alerta.sendKeys("12");
		alerta.accept();
		Assert.assertEquals("Era 12?", alerta.getText());
		alerta.accept();
		Assert.assertEquals(":D", alerta.getText());
		alerta.accept();

		driver.quit();

	}

}
