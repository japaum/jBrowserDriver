package japa.teste;

import java.io.BufferedWriter;
import java.io.FileWriter;

import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.machinepublishers.jbrowserdriver.JBrowserDriver;
import com.machinepublishers.jbrowserdriver.Settings;
import com.machinepublishers.jbrowserdriver.Timezone;
import com.machinepublishers.jbrowserdriver.UserAgent;

public class Teste {
	public static void main(String[] args) {

		  DesiredCapabilities capabilities = 
			        new DesiredCapabilities("jbrowserdriver", "1", Platform.WIN10);
		
		// You can optionally pass a Settings object here,
		// constructed using Settings.Builder
		JBrowserDriver driver = new JBrowserDriver(Settings.builder().userAgent(UserAgent.CHROME).
				timezone(Timezone.AMERICA_NEWYORK).build());
		
		// This will block for the page load and any
		// associated AJAX requests
		driver.get("https://web.whatsapp.com/");
		driver.pageWait();

		// You can get status code unlike other Selenium drivers.
		// It blocks for AJAX requests and page loads after clicks 
		// and keyboard events.
		System.out.println(driver.getStatusCode());
		// Returns the page source in its current state, including
		// any DOM updates that occurred after page load
		System.out.println(driver.getPageSource());
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter("C:\\work\\Nova pasta\\teste.html"));
			writer.write(driver.getPageSource());

			writer.close();
		}catch (Exception e) {
			// TODO: handle exception
		}
		// Close the browser. Allows this thread to terminate.
		driver.quit();
	}
}
