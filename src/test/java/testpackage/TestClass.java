package testpackage;

import org.testng.Assert;
import org.testng.annotations.Test;

import basepackage.BaseClass;
import pagepackage.CareersPage;
import pagepackage.HomePage;
import pagepackage.JobDetailsPage;

public class TestClass extends BaseClass {

    @Test
    public void testQaJobs() {
        
        HomePage home = new HomePage(driver);
        home.openHomePage();
        Assert.assertTrue(home.isHomePageLoaded(), "Home page not loaded!");

        
        CareersPage careers = new CareersPage(driver);
        careers.openCareersPage();
        careers.clickSeeAllJobs();
        careers.applyFilters("Istanbul", "Quality Assurance");

        
        careers.clickFirstViewRole();
        JobDetailsPage job = new JobDetailsPage(driver);
        Assert.assertTrue(job.isLeverPageOpened(), "Lever page not opened!");
    }
}
