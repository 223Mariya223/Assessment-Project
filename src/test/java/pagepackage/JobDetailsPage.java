package pagepackage;

import org.openqa.selenium.WebDriver;

public class JobDetailsPage {
	 WebDriver driver;

	    public JobDetailsPage(WebDriver driver) {
	        this.driver = driver;
	    }

	    public boolean isLeverPageOpened() {
	        return driver.getCurrentUrl().contains("lever.co");
	    }
}
