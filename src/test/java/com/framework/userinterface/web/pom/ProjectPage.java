package com.framework.userinterface.web.pom;

import com.framework.lib.base.browser.BrowserPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class ProjectPage extends BrowserPage implements com.framework.userinterface.web.interfaces.ProjectPage {
    WebDriver driver;

    public ProjectPage(String testName, WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = LOCATOR.PROJECT_NAME_TEXT)
    private WebElement projectName;
    @FindBy(xpath = LOCATOR.PROJECT_TAB)
    private WebElement projectButton;
    @FindBy(xpath = LOCATOR.TEAMPROJECT_TAB)
    private WebElement teamProject;

    @Override
    public void validateSelectedTeam(String expectedProjectName) {
        String nameOfProject = projectName.getText();
        Assert.assertEquals(nameOfProject, expectedProjectName);
    }

    @Override
    public void clickProjectTab() {
        click(projectButton);
        click(teamProject);
    }
}
