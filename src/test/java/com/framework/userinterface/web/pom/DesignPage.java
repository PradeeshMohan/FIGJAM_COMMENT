package com.framework.userinterface.web.pom;

import com.framework.lib.utils.ScreenShotAssistant;
import com.framework.userinterface.web.utils.BrowserUtil;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.List;

public class DesignPage extends BrowserUtil implements com.framework.userinterface.web.interfaces.DesignPage {
    WebDriver driver;
    @FindBy(xpath = LOCATOR.CANVAS)
    public WebElement canvas;

    @FindBy(xpath = LOCATOR.SHAPE_TOOL_DROPDOWN)
    public WebElement shapeToolDropdown;

    @FindBy(xpath = LOCATOR.RECTANGLE_TOOL)
    public WebElement rectangleTool;

    @FindBy(xpath = LOCATOR.STAR_TOOL)
    public WebElement starTool;

    @FindBy(xpath = LOCATOR.FILE_NAME_ON_TOOLBAR)
    public WebElement nameOfDoc;

    @FindBy(xpath = LOCATOR.MAIN_MENU_DROPDOWN_BUTTON)
    public WebElement mainMainDropdown;

    @FindBy(xpath = LOCATOR.BACK_TO_FILE_OPTION)
    public WebElement backToFileOption;

    @FindBy(xpath = LOCATOR.TITLE_BAR)
    public WebElement titleBar;
    @FindBy(xpath = LOCATOR.FILENAME_DROPDOWN_BUTTON)
    private WebElement fileNameDropDown;
    @FindBy(xpath = LOCATOR.RENAME_BUTTON)
    private WebElement renameButton;
    @FindBy(xpath = LOCATOR.FILENAME_TEXTBOX)
    private WebElement fileNameTextBox;
    @FindBy(xpath = LOCATOR.FILENAME)
    private WebElement fileName;
    @FindBy(xpath = LOCATOR.TOOLS_MARKER)
    private WebElement toolsMarker;
    @FindBy(xpath = LOCATOR.DELETE_BUTTON)
    private WebElement deleteButton;
    @FindBy(xpath = LOCATOR.SUBMIT_DELETE_BUTTON)
    private WebElement submitDeleteButton;
    @FindBy(xpath = LOCATOR.DELETE_POPUP)
    private WebElement deletePopup;
    @FindBy(xpath = LOCATOR.SHARE_BUTTON)
    private WebElement shareButton;

    @FindBy(xpath = LOCATOR.SHARE_ACCESS_DROPDOWN)
    private WebElement shareAccessDD;
    @FindBy(xpath = LOCATOR.SHARE_ACCESS_OPTIONS)
    private WebElement shareAccessOptions;
    @FindBy(xpath = LOCATOR.SHARE_INPUT_EMAIL)
    private WebElement shareInputEmail;
    @FindBy(xpath = LOCATOR.SHARE_SEND_INVITE)
    private WebElement shareSendInvite;
    @FindBy(xpath = LOCATOR.SHARED_EMAIL_FIELD)
    private WebElement sharedEmailField;
    @FindBy(xpath = LOCATOR.DROPDOWN_BUTON)
    public WebElement dropDownButton;
    @FindAll({@FindBy(xpath = LOCATOR.TEAMS)})
    public List<WebElement> teams;
    @FindAll({@FindBy(xpath = LOCATOR.PROJECTS_IN_TEAMS)})
    public List<WebElement> projectsInTeams;
    @FindBy(xpath = LOCATOR.MOVE_BUTTON)
    public WebElement moveButton;
    @FindBy(xpath = LOCATOR.SHAPES_TOOL_FIGJAMFILE)
    public WebElement shapesToolFigJam;
    @FindBy(xpath = LOCATOR.CHANGE_SHAPE_MENU_FIGJAMFILE)
    public WebElement changeShapeMenuFigJam;
    @FindBy(xpath = LOCATOR.ROUNDED_RECTANGLE_SHAPE_FIGJAMFILE)
    public WebElement roundedReactangleShape;
    @FindBy(xpath = LOCATOR.CHANGE_COLOUR_MENU_FIGJAMFILE)
    public WebElement changeColourMenuFigJam;
    @FindBy(xpath = LOCATOR.YELLOW_COLOUR_FIGJAMFILE)
    public WebElement yellowcolourFigjam;
    @FindBy(xpath = LOCATOR.CHANGE_LINESTYLE_MENU_FIGJAMFILE)
    public WebElement changeLineStyleMenuFigJam;
    @FindBy(xpath = LOCATOR.DASHED_LINESTYLE_FIGJAMFILE)
    public WebElement dashedLineStyleFigJam;
    @FindBy(xpath = LOCATOR.CHANGE_TYPEFACE_MENU_FIGJAMFILE)
    public WebElement changeTypeFaceMenuFigJam;
    @FindBy(xpath = LOCATOR.BOOKISH_TYPEFACE_FIGJAMFILE)
    public WebElement bookishTypeFaceFigJam;
    @FindBy(xpath = LOCATOR.CHANGE_FONT_SIZE_MENU_FIGJAMFILE)
    public WebElement changeFontSizeMenuFigJam;
    @FindBy(xpath = LOCATOR.MEDIUM_SIZE_FONT_FIGJAMFILE)
    public WebElement mediumSizeFontFigJam;
    @FindBy(xpath = LOCATOR.BOLD_FONT_MENU_FIGJAMFILE)
    public WebElement boldFontMenuFigJam;
    @FindBy(xpath = LOCATOR.STRIKETHROUGH_MENU_FIGJAMFILE)
    public WebElement strikeThroughFigJam;
    @FindBy(xpath = LOCATOR.CREATE_LINK_MENU_FIGJAMFILE)
    public WebElement createLinkMenu;
    @FindBy(xpath = LOCATOR.ENTER_LINK_FIGJAMFILE)
    public WebElement enterLinkFigJam;
    @FindBy(xpath = LOCATOR.BULLETED_LIST_MENU_FIGJAMFILE)
    public WebElement bulletedListFigJam;
    @FindBy(xpath = LOCATOR.TEXT_ALIGNMENT_MENU_FIGJAMFILE)
    public WebElement textAlignmentMenuFigJam;
    @FindBy(xpath = LOCATOR.TEXT_ALIGN_LEFT_FIGJAMFILE)
    public WebElement textAlignLeftFigJam;
    @FindBy(xpath = LOCATOR.COMMENT_BUTTON_FIGJAMFILE)
    public WebElement commentButtonFigJam;

   @FindBy(xpath =LOCATOR.COMMENT_TEXTBOX_FIGJAMFILE )
   public WebElement commentTextBoxFigJam;
    @FindBy(xpath = LOCATOR.COMMENT_SUBMIT_FIGJAMFILE)
    public WebElement commentSubmitFigJam;
    @FindBy(xpath = LOCATOR.COMMENT_VERIFY_FIGJAMFIME)
    public WebElement commentVerifyFigJam;

    public DesignPage(String testName, WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @Override
    public boolean isDisplayed() {
        fluentWait(webDriver, 3, titleBar);
        return titleBar.isDisplayed();
    }

    @Override
    public void selectRectangleTool() {
        rectangleTool.click();
    }

    @Override
    public void clickOnShapeToolDropdown() {
        click(shapeToolDropdown);
    }

    @Override
    public void renameAndSaveTheFile(String newName) {
        click(fileNameDropDown);
        click(renameButton);
        sleepThread(50);
        sendValue(fileNameTextBox, newName);
        fileNameTextBox.sendKeys(Keys.ENTER);
    }

    @Override
    public void validateFileName(String newName) {
        String filename = fileName.getText();
        Assert.assertEquals(filename, newName);
    }

    @Override
    public void editTheFile() {
        click(toolsMarker);
        WebElement drawingArea = canvas;
        Actions action = new Actions(driver);
        action.moveToElement(drawingArea, -10, 10).clickAndHold(drawingArea)
                .moveByOffset(50, 100).release().perform();
    }

    @Override
    public void deleteTheFile() {
        click(fileNameDropDown);
        click(deleteButton);
        click(submitDeleteButton);
    }

    @Override
    public void validateTheFileIsDeleted(String deletepopupText) {
        String deleteText = deletePopup.getText();
        if (deleteText.equals(deletepopupText)) {
            System.out.println("File has been Deleted successfully");
        }
    }

    @Override
    public void clickOnShareButton() {
        click(shareButton);
    }

    @Override
    public void selectAccessFromDD() {
        click(shareAccessDD);
        click(shareAccessOptions);
    }

    @Override
    public void enterEmailToShare(String email) {
        sendValue(shareInputEmail, email);
    }

    @Override
    public void sendInvite() {
        click(shareSendInvite);
    }

    @Override
    public void validateInvite() {
        Assert.assertTrue(sharedEmailField.isDisplayed());
        System.out.println("File Shared Successfully");
    }

    @Override
    public void selectStarTool() {
        click(starTool);
    }

    @Override
    public void drawShapeOnCanvas(int X, int Y, int X1, int Y1) {
        Rectangle rect = canvas.getRect();
        int h = rect.getHeight() / 2;
        int w = rect.getWidth() / 2;
        clickHoldMoveInsideElement(canvas, -w + 5 + X, -h + 5 + Y, X1, Y1);
    }

    @Override
    public String getCanvasScreenShot() throws IOException {
        return ScreenShotAssistant.getElementScreenShot(canvas);
    }

    @Override
    public void clickOnCanvasEmptyArea() throws InterruptedException {
        Rectangle rect = canvas.getRect();
        int h = rect.getHeight() / 2;
        int w = rect.getWidth() / 2;
        clickInsideElement(canvas, -w + 5, h - 5);
    }

    @Override
    public void changeTitle(String title) {
        click(nameOfDoc);
        sendValueUsingAction(title);
    }

    @Override
    public void goToHomepage() {
        mainMainDropdown.click();
        sleepThread(10);
        backToFileOption.click();
        sleepThread(5000);
    }

    @Override
    public void moveTheElementInsideElement(int X, int Y, int X1, int Y1) {
        Rectangle rect = canvas.getRect();
        int h = rect.getHeight() / 2;
        int w = rect.getWidth() / 2;
        clickHoldMoveInsideElement(canvas, -w + 1 + X, -h + 1 + Y, X1, Y1);
    }

    @Override
    public void clickOnTitleDropDown() {
        click(dropDownButton);
        sleepThread(500);
    }

    @Override
    public void selectMoveToProject() {
        for (int i = 0; i < 4; i++) {
            keyPressReleaseByRobot(KeyEvent.VK_DOWN);
            sleepThread(500);
        }
        keyPressReleaseByRobot(KeyEvent.VK_ENTER);
    }

    @Override
    public void selectTeamAndMove(String teamName) {
        for (int i = 0; i < teams.size(); i++) {
            String team = teams.get(i).getText();
            System.out.println(team);
            if (team.equalsIgnoreCase(teamName)) {
                WebElement teamProject = projectsInTeams.get(i);
                teamProject.click();
                break;
            }
        }
        moveButton.click();
        System.out.println("File Moved To Project");
        sleepThread(1000);
    }

    @Override
    public void clickShapesToolInFigJamFile() {
        sleepThread(1000);
        keyPressReleaseByRobot(KeyEvent.VK_ESCAPE);
        shapesToolFigJam.click();
    }

    @Override
    public void clickOnCanvas() {
        canvas.click();
    }

    @Override
    public void addAllProperties() {
        click(changeShapeMenuFigJam);
        click(roundedReactangleShape);
        click(changeColourMenuFigJam);
        click(yellowcolourFigjam);
        click(changeLineStyleMenuFigJam);
        click(dashedLineStyleFigJam);
        click(changeTypeFaceMenuFigJam);
        click(bookishTypeFaceFigJam);
        click(changeFontSizeMenuFigJam);
        sleepThread(500);
        click(mediumSizeFontFigJam);
        click(boldFontMenuFigJam);
        click(strikeThroughFigJam);
        click(createLinkMenu);
        sendValue(enterLinkFigJam, "www.google.com");
        enterLinkFigJam.sendKeys(Keys.ENTER);
        click(bulletedListFigJam);
        click(textAlignmentMenuFigJam);
        click(textAlignLeftFigJam);
    }

    @Override
    public void addTextIntoShape(String text) {
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.ENTER).perform();
        actions.sendKeys("Hi all").perform();
        actions.sendKeys(Keys.ESCAPE).perform();
        actions.sendKeys(Keys.ESCAPE).perform();
    }

    @Override
    public void clickCommentIconFigJam() {
        click(commentButtonFigJam);
    }

    @Override
    public void dragOnCanvasToAddComment() {
        WebElement commentArea = canvas;
        Actions action = new Actions(driver);
        action.moveToElement(commentArea, -10, 10).clickAndHold(commentArea)
                .moveByOffset(50, 100).release().perform();
    }

    @Override
    public void addTextInCommentBubble() {
        click(commentTextBoxFigJam);
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.ENTER).perform();
        actions.sendKeys("Hi New Comment");
        actions.sendKeys(Keys.ESCAPE).perform();
    }

    @Override
    public void clickSubmit() {
        click(commentSubmitFigJam);
    }

    @Override
    public void verifyTheComment(String verifyComment) {
        String comment = commentVerifyFigJam.getText();
        Assert.assertEquals(comment, verifyComment);
        System.out.println("Added comment");
    }


    }



