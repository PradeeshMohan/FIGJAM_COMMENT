package com.framework.stepDefinitionFiles;

import com.framework.lib.PythonUtils.PythonExecutor;
import com.framework.lib.stepdefinition.Steps;
import com.framework.lib.utils.ConfigFileReader;
import com.framework.lib.utils.PropertyFileManager;
import com.framework.lib.utils.VariablePool;
import com.framework.userinterface.web.factory.PageFactory;
import com.framework.userinterface.web.interfaces.*;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Keys;
import org.testng.Assert;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;
import java.time.Duration;
import java.time.Instant;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


public class StepDefinition extends Steps {

    /**
     * The Config.
     */
    protected final ConfigFileReader config = PropertyFileManager.getInstance().getConfigReader();

    protected VariablePool pool = new VariablePool();


    protected final String appUrl = config.getProperty("app-url");
    protected final String screenShotDir = config.getProperty("screen-shot-dir");

    protected final int implicitWaitSec = Integer.parseInt(config.getProperty("implicitlyWait"));

    String username = config.getProperty("figma-username");
    String userPassword = config.getProperty("figma-password");
    String expectedProjectName = config.getProperty("expected-projectname");
    String newFileName = config.getProperty("filename");
    String deletePopupText = config.getProperty("delete-popup-text");
    String shareEmail = config.getProperty("share-email");
    String teamName = config.getProperty("team-name");


    /**
     * The page Objects.
     */
    // Mobile Page Objects
    LoginPage loginPage;
    HomePage homePage;
    DesignPage designPage;
    ProjectPage projectPage;
    TeamProjectPage teamProjectPage;


    /**
     * The Scenario timestamp.
     */
    long scenarioTimestamp;


    public StepDefinition() throws IOException {
    }

    protected void setup() {
        webDriver = context.getWebDriverFactory().getWebDriver();
        webDriver.get(appUrl);
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(implicitWaitSec));
        webDriver.manage().window().maximize();

//       Calling the factory methods to create the page objects
        loginPage = PageFactory.getLogInPage(scenarioName, webDriver);
        homePage = PageFactory.getHomePage(scenarioName, webDriver);
        designPage = PageFactory.getDesignPage(scenarioName, webDriver);
        projectPage = PageFactory.getProjectPage(scenarioName, webDriver);
        teamProjectPage = PageFactory.getTeamProjectPage(scenarioName, webDriver);
    }

    @Before
    public void logScenario(Scenario s) {
        scenarioTimestamp = Instant.now().toEpochMilli();
        super.logScenario(s);
        File theDir = new File(screenShotDir);
        if (!theDir.exists()) {
            theDir.mkdirs();
        }
    }

    @After
    public final void tearDown(Scenario scenario) throws Exception {
        super.tearDown(scenario);
        FileUtils.cleanDirectory(new File(screenShotDir));
    }

    @And("SetUp the browser")
    public void setupTheBrowser() {
        setup();
    }

    @Then("Login into the application")
    public void loginIntoTheApplication() {
        loginPage.loginIntoTheApp(username, userPassword);
    }

    @And("Verify that Home page is displayed")
    public void verifyThatHomePageIsDisplayed() {
        Assert.assertTrue(homePage.isDisplayed());
    }

    @When("Click on the new design option")
    public void clickOnTheNewDesignOption() {
        homePage.clickOnNewDesign();
    }

    @Then("Verify that Design page is displayed")
    public void verifyThatDesignPageIsDisplayed() {
        Assert.assertTrue(designPage.isDisplayed());
    }

    @When("User selects the rectangle tool")
    public void userSelectsTheRectangleToolFromTheDropdown() {
        designPage.clickOnShapeToolDropdown();
        designPage.selectRectangleTool();
    }

    @Then("User draws the shape from start position {string} to end position {string}")
    public void userDrawsTheShapeFromTo(String arg0, String arg1) {
        List<Integer> startPos = Arrays.asList(arg0.split(",")).stream().map(Integer::parseInt).collect(Collectors.toList());
        List<Integer> endPos = Arrays.asList(arg1.split(",")).stream().map(Integer::parseInt).collect(Collectors.toList());
        designPage.drawShapeOnCanvas(startPos.get(0), startPos.get(1), endPos.get(0), endPos.get(1));
        sleepThread(20);
    }

    @When("User selects the star tool")
    public void userSelectsTheStarTool() {
        designPage.clickOnShapeToolDropdown();
        designPage.selectStarTool();
    }

    @And("Take the ScreenShot of the Canvas {string}")
    public void takeTheScreenShotOfTheCanvas(String arg0) throws InterruptedException, IOException {
        designPage.clickOnCanvasEmptyArea();
        sleepThread(20);
        String ss = designPage.getCanvasScreenShot();
        sleepThread(50);
        pool.setVariable(arg0, ss);
        ;
    }


    @And("Get the areas {string} of figures in the canvas from {string}")
    public void getTheAreasOfFiguresInTheCanvasFrom(String arg0, String arg1) throws IOException {
        PythonExecutor pythonExecutor = new PythonExecutor(webDriver);
        List<Float> list = pythonExecutor.detectAreas((String) pool.getVariable(arg1));
        pool.setVariable(arg0, list);
    }

    @Then("Change the Title of Document to {string}")
    public void changeTheTitleOfDocumentTo(String arg0) {
        designPage.changeTitle(arg0);
        sleepThread(1800);
    }

    @When("Go to the home page of figma")
    public void goToTheHomePageOfFigma() {
        designPage.goToHomepage();
    }

    @And("Check if file {string} is present in the draft")
    public void checkIfFileIsPresentInTheDraft(String arg0) {
        Assert.assertTrue(homePage.checkIfFileIsInDraft(arg0));
    }

    @Then("User opens the file {string} from the draft")
    public void userOpensTheFileFromTheDraft(String arg0) {
        homePage.userOpensTheFileFromDraft(arg0);
        Assert.assertTrue(designPage.isDisplayed());
    }

    @Then("Compare the areas of {string} and {string}")
    public void compareTheAreasOfAnd(String arg0, String arg1) {
        List<Float> areas1 = (List<Float>) pool.getVariable(arg0);
        List<Float> areas2 = (List<Float>) pool.getVariable(arg1);
        Assert.assertEquals(areas2.size(), areas1.size());
        for (int i = 0; i < areas2.size(); i++) {
            Assert.assertTrue(Math.abs(areas1.get(i) - areas2.get(i)) < 100);
        }
    }

    @And("Move the figure {string} in the {string} by {string}")
    public void moveTheFigureInTheBy(String figureNo, String screenShot, String coords) throws IOException, InterruptedException {
        PythonExecutor pythonExecutor = new PythonExecutor(webDriver);
        List<List<Integer>> list = pythonExecutor.detectCenters((String) pool.getVariable(screenShot));
        int currentX = list.get(Integer.parseInt(figureNo) - 1).get(0);
        int currentY = list.get(Integer.parseInt(figureNo) - 1).get(1);
        List<Integer> desiredCoordList = Arrays.asList(coords.split(",")).stream().map(Integer::parseInt).collect(Collectors.toList());
        int desiredX = desiredCoordList.get(0);
        int desiredY = desiredCoordList.get(1);
        designPage.moveTheElementInsideElement(currentX, currentY, desiredX, desiredY);
        designPage.clickOnCanvasEmptyArea();
    }

    @Then("User Click on teams and Select the team")
    public void userClickOnTeamsAndSelectTheTeam() {
        homePage.clickOnTheTeamsAndSelectTheTeam();
    }

    @And("Validate the team and go to the project tab")
    public void validateTheTeamAndGoToTheProjectTab() {
        projectPage.validateSelectedTeam(expectedProjectName);
        projectPage.clickProjectTab();
    }

    @Then("User Click on new FigJam file")
    public void userClickOnNewFigJamFile() {
        teamProjectPage.createNewFigJamFile();
    }

    @When("User Rename the file and save the file")
    public void userRenameTheFileAndSaveTheFile() {
        designPage.renameAndSaveTheFile(newFileName);
    }

    @Then("Validate the file name")
    public void validateTheFileName() {
        designPage.validateFileName(newFileName);
    }

    @And("Edit the file")
    public void editTheFile() {
        designPage.editTheFile();
    }

    @Then("Delete the file")
    public void deleteTheFile() {
        designPage.deleteTheFile();
    }

    @And("Validate the file is Deleted Successfully")
    public void validateTheFileIsDeletedSuccessfully() {
        designPage.validateTheFileIsDeleted(deletePopupText);
    }

    @Then("User click on Share Button")
    public void userClickOnShareButton() {
        designPage.clickOnShareButton();
    }

    @And("Select the access from DropDown")
    public void selectTheAccessFromDropDown() {
        designPage.selectAccessFromDD();
    }

    @Then("User Enter the E-Mail need to share")
    public void userEnterTheEMailNeedToShare() {
        designPage.enterEmailToShare(shareEmail);
    }

    @Then("Send the Invite")
    public void sendTheInvite() {
        designPage.sendInvite();
    }

    @And("Validate the Invite is Sent")
    public void validateTheInviteIsSent() {
        designPage.validateInvite();
    }

    @When("Go to Drafts")
    public void go_to_drafts() {
        homePage.clickOnDrafts();
    }

    @Then("click on New FigJam file")
    public void click_on_new_fig_jam_file() {
        homePage.clickOnNewFigJamFile();
    }

    @When("Click on the dropdown and select move to project")
    public void click_on_the_dropdown_and_select_move_to_project() {
        designPage.clickOnTitleDropDown();
        designPage.selectMoveToProject();
    }

    @Then("Select the team and move")
    public void select_the_team_and_move() {
        designPage.selectTeamAndMove(teamName);
    }

    @Then("Choose Existing FigJam file {string} from Drafts")
    public void choose_existing_fig_jam_file_from_drafts(String file) {
        homePage.openFileFromDrafts(file);
    }

    @When("Click on shapes from the tool bar")
    public void click_on_shapes_from_the_tool_bar() {
        designPage.clickShapesToolInFigJamFile();
    }

    @When("Click on workspace and draw the shape")
    public void click_on_workspace_and_draw_the_shape() {
        designPage.clickOnCanvas();
    }

    @When("Add all properties to drawn shape from property menu")
    public void add_all_properties_to_drawn_shape_from_property_menu() {
        designPage.addAllProperties();
    }

    @Then("Add text {string} into the shapes")
    public void add_text_into_the_shapes(String text) {
        designPage.addTextIntoShape(text);
    }

    @Then("Click add comment icon")
    public void click_add_comment_icon() {
    designPage.clickCommentIconFigJam();
    }
    @Then("Drag on Canvas to add Comment")
    public void drag_on_canvas_to_add_comment() {
    designPage.dragOnCanvasToAddComment();
    }
    @Then("Add Text {string} in Comment bubble")
    public void add_text_in_comment_bubble(String string) {
    designPage.addTextInCommentBubble();
    }
    @Then("click Submit")
    public void click_submit() {
    designPage.clickSubmit();
    }

@Then("Verify the comment {string}")
    public void verifyTheComment(String arg0) {
        designPage.verifyTheComment(arg0);
    }
}