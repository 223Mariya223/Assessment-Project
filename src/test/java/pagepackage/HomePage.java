package pagepackage;

import org.openqa.selenium.WebDriver;

public class HomePage {
	WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void openHomePage() {
        driver.get("https://useinsider.com/");
    }

    public boolean isHomePageLoaded() {
        return driver.getTitle().contains("Insider");
    }
}
