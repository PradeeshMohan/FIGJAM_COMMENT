package com.framework.userinterface.web.pom;

import com.framework.lib.base.browser.BrowserPage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class HomePage extends BrowserPage implements com.framework.userinterface.web.interfaces.HomePage {

    WebDriver driver;

    @FindBy(xpath = LOCATOR.NEW_DESIGN_BUTTON)
    public WebElement newDesignButton;
    @FindBy(xpath=LOCATOR.TEAMS_BUTTON)
    private WebElement teamsButton;
    @FindBy(xpath=LOCATOR.TEAMS_SELECTION)
    private WebElement selectTeam;

    @FindBy(xpath = LOCATOR.DRAFTS_BUTTON)
    public WebElement draftsButton;
    @FindBy(xpath = LOCATOR.NEW_FIGJAMFILE_BUTTON)
    public WebElement newFifJamFileButton;

    @FindAll({@FindBy(xpath = LOCATOR.DRAFT_FILES)})
    public List<WebElement> draftFiles;


    public HomePage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public HomePage(String testName, WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @Override
    public void clickOnNewDesign() {
        click(newDesignButton);
    }

    @Override
    public boolean isDisplayed() {
        return newDesignButton.isDisplayed();
    }

    @Override
    public boolean checkIfFileIsInDraft(String fileName) {
        WebElement element = webDriver.findElement(By.xpath
                ("//div/a//div[text()=\"" + fileName + "\"]"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        return element.isDisplayed();
    }

    @Override
    public void userOpensTheFileFromDraft(String fileName) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,-350)", "");
        sleepThread(20);
        WebElement element = webDriver.findElement(By.xpath
                ("//div[text()=\"" + fileName + "\"]"));
        doubleClick(element);
    }
 @Override
    public void clickOnTheTeamsAndSelectTheTeam() {
        if (teamsButton.isDisplayed()) {
            Actions actions = new Actions(driver);
            actions.moveToElement(teamsButton).click().perform();
        }
        click(selectTeam);

    }
    @Override
    public void clickOnDrafts() {
        click(draftsButton);
    }

    @Override
    public void clickOnNewFigJamFile() {
        click(newFifJamFileButton);
        sleepThread(2000);

    }

    @Override
    public void openFileFromDrafts(String fileName) {
        for (int i = 0; i < draftFiles.size(); i++) {
            WebElement draftFile = draftFiles.get(i);
            String file = draftFile.getText();
            System.out.println(file);
            if (file.equalsIgnoreCase(fileName)) {
                doubleClick(draftFile);
                System.out.println("Clicked File From Drafts");
                break;
            }
        }
    }


}
