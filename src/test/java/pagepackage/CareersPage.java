package pagepackage;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CareersPage {

    WebDriver driver;

    @FindBy(xpath = "//a[contains(text(),'See all QA jobs')]")
    WebElement seeAllJobs;

    @FindBy(id = "filter-by-location")
    WebElement locationFilter;

    @FindBy(id = "filter-by-department")
    WebElement departmentFilter;

    @FindBy(css = "div.position-list-item")
    List<WebElement> jobsList;

    public CareersPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void openCareersPage() {
        driver.get("https://useinsider.com/careers/quality-assurance/");
    }

    public void clickSeeAllJobs() {
		
		seeAllJobs.click();
	}

    public void applyFilters(String location, String department) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.elementToBeClickable(locationFilter));

        new Select(locationFilter).selectByVisibleText(location);
        new Select(departmentFilter).selectByVisibleText(department);
    }

    public void clickFirstViewRole() {
        if (!jobsList.isEmpty()) {
            jobsList.get(0).findElement(By.xpath(".//a[text()='View Role']")).click();
        }

        for (String handle : driver.getWindowHandles()) {
            driver.switchTo().window(handle);
        }

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(webDriver -> driver.getCurrentUrl().contains("lever.co"));
    }

	
	}
