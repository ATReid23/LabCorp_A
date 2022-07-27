package Pages;

import Utils.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;

public class HomePage {

    public HomePage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }


    @FindBy (xpath = "//div[@id='login-container']//a[@class='no-ext ext']")
    public WebElement careerLink;

    @FindBy (xpath = "(//input[@id='typehead'])[2]")
    public WebElement searchBox;

    @FindBy (xpath = "(//span[@data-ph-id='ph-page-element-page11-Zk12Zp'])[1]")
    public WebElement firstJobItem;

    @FindBy (xpath = "//h1[@class='job-title']")
    public WebElement jobTitle;
    @FindBy (xpath = "//span[@class='au-target job-location']")
    public WebElement jobLocal;
    @FindBy (xpath = "//span[@class='au-target jobId']")
    public WebElement jobID;
    @FindBy (xpath = "//div[@class='job-desc row']")
    public WebElement jobDescription;

    @FindBy (xpath = "//div[@class='Sub-Actions']//a[@class='btn primary-button au-target']")
    public WebElement applyBtn;

    public void switchTabs(){
        ArrayList<String> tabs = new ArrayList<>(Driver.getDriver().getWindowHandles());
        Driver.getDriver().switchTo().window(tabs.get(1));
    }

}
