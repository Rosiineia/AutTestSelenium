import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;



public class TesteGoogle {
	
	@SuppressWarnings("deprecation")
	@Test
	public void teste() {
		//System.setProperty("webdriver.gecko.driver", "C:\\01 Arquivo Pessoal\\Cursos\\Udemy\\Testes Funcionais Com Selenium WebDrive- do basico ao grid\\Drivers\\geckodriver-v0.33.0-win64");
		WebDriver driver = new FirefoxDriver();
		//WebDriver driver = new ChromeDriver();
		//WebDriver driver = new InternetExplorerDriver();
		driver.get("https://www.google.com/");
		//System.out.println(driver.getTitle());
		Assert.assertEquals("Google", driver.getTitle());
		driver.quit();			
		
	}
	
	@Test
	public void testeFirefoxDriver() {
		
		
		WebDriver driver = new FirefoxDriver();		
		driver = new FirefoxDriver();
		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		Assert.assertEquals("Campo de Treinamento", driver.getTitle());

		// driver.quit(); // (Fecha a pagina
	}

}
