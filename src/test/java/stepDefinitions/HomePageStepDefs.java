package stepDefinitions;

import Pages.HomePage;
import Utils.Driver;
import Utils.PropertyReader;
import Utils.SeleniumUtils;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Wait;

import java.awt.*;
import java.awt.event.KeyEvent;

public class HomePageStepDefs {

    @Given("I am on the homepage")
    public void iAmOnTheHomepage() {
        Driver.getDriver().get(PropertyReader.getTheProperties("url"));

    }
    @When("I click the career link AND verify the url is {string}")
    public void i_click_the_career_link_and_verify_the_url_is(String targetURL) {
        targetURL = "https://careers.labcorp.com/global/en";
        HomePage homePage = new HomePage();

        homePage.careerLink.click();

        homePage.switchTabs();

        Assert.assertEquals(Driver.getDriver().getCurrentUrl(), targetURL);

    }
    @When("I search for a job {string} AND select it")
    public void i_search_for_a_and_select_it(String job) throws AWTException {
        job = "QA Test Automation";
        HomePage homePage = new HomePage();
//        Robot robot = new Robot();
        Actions act = new Actions(Driver.getDriver());


        homePage.searchBox.sendKeys(job);
        SeleniumUtils.waitFor(3);
//        robot.keyPress(KeyEvent.VK_ENTER);
        act.sendKeys(Keys.ENTER).build().perform();

        SeleniumUtils.waitForVisibility(homePage.firstJobItem, 4);
        homePage.firstJobItem.click();

    }
    @When("I verify the job title {string}, location {string}, id {string}, requirements {string}, programming language {string}, and testing tool {string}")
    public void i_verify(String title, String location, String id, String requirements, String language, String tool) {
        HomePage homePage = new HomePage();

        title = "QA Test Automation Developer";
        location = "Durham, North Carolina, United States of America";
        id = "21-90223_RM";
        requirements = "or equivalent work experience";
        language = "Java";
        tool = "Maven";

        Assert.assertEquals(homePage.jobTitle.getText(), title);
        Assert.assertTrue(homePage.jobLocal.getText().contains(location));
        Assert.assertTrue(homePage.jobID.getText().contains(id));
        Assert.assertTrue(homePage.jobDescription.getText().contains(requirements));
        Assert.assertTrue(homePage.jobDescription.getText().contains(language));
        Assert.assertTrue(homePage.jobDescription.getText().contains(tool));


    }
    @When("I click the apply button")
    public void i_click_the_apply_button() {
        HomePage homePage = new HomePage();

        SeleniumUtils.waitForClickablility(homePage.applyBtn, 3);
        homePage.applyBtn.click();

    }
//    @When("I verify {string}, {string}, {string}, {string}")
//    public void i_verify(String string, String string2, String string3, String string4) {
//
//
//    }
//    @Then("I click to Return to Job Search")
//    public void i_click_to_return_to_job_search() {
//
//
//    }

}
