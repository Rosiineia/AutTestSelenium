import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TesteFramesEJanelas {

	@Test
	public void deveInteragirComFrames() {
		WebDriver driver = new ChromeDriver();
		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");

		driver.switchTo().frame("frame1");
		driver.findElement(By.id("frameButton")).click();
		// **** escrever o resultado no formaulario de nome******

		Alert alert = driver.switchTo().alert();
		String msg = alert.getText();
		Assert.assertEquals("Frame OK!", alert.getText());
		alert.accept();

		driver.switchTo().defaultContent();
		driver.findElement(By.id("elementosForm:nome")).sendKeys(msg);

		// driver.quit();
	}

	@Test
	public void deveInteragirComJanelas() {
		WebDriver driver = new ChromeDriver();
		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");

		driver.findElement(By.id("buttonPopUpEasy")).click();

		// Trocar para popup que já conheço o titulo

		driver.switchTo().window("Popup");
		// Escreve no popup
		driver.findElement(By.tagName("textarea")).sendKeys("Deu certo");
		driver.close();
		// Volta e escreve na tela principal (Aba sugestões)
		driver.switchTo().window("");
		driver.findElement(By.tagName("textarea")).sendKeys("E agora");

		// driver.quit();
	}

	@Test
	public void deveInteragirComJanelaSemTitulo() {
		WebDriver driver = new ChromeDriver();
		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");

		driver.findElement(By.id("buttonPopUpHard")).click();
		// Imprime as janelas : pricipal e popoup (assim vou referenciar a que não tem
		// titulo)
		System.out.println(driver.getWindowHandle());
		System.out.println(driver.getWindowHandles());
		// Como o id que retornou muda, criarei um array
		driver.switchTo().window((String) driver.getWindowHandles().toArray()[1]);
		// Escreve no popup
		driver.findElement(By.tagName("textarea")).sendKeys("Deu certo");

		// Volta para tela principal
		driver.switchTo().window((String) driver.getWindowHandles().toArray()[0]);
		// Volta e escreve na tela principal (Aba sugestões)

		driver.findElement(By.tagName("textarea")).sendKeys("E agora");

		driver.quit();
	}
}
