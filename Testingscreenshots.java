package Ex;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Testingscreenshots {

	public static void main(String[] args) throws Exception {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.google.com/search?q=tajmahal+images&tbm=isch&chips=q:tajmahal+images,g_1:night:ELPDxrryT0w%3D&hl=en-US&sa=X&ved=2ahUKEwjioO_h0db3AhWtgWMGHbSEC3MQ4lYoBHoECAEQIw&biw=1349&bih=625");
        File file = driver.getScreenshotAs(OutputType.FILE);
        File tar =new File("./snaps/img.png");
        FileUtils.copyFile(file, tar); 
        System.out.println("sreenshot has been captured");
        
	}

}
