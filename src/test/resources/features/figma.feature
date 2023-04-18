Feature: Figma App Testing

  @AllTest
  Scenario: Demo Test 1
    Given SetUp the browser
    Then Login into the application
    And Verify that Home page is displayed
    When Click on the new design option
    Then Verify that Design page is displayed
    When User selects the star tool
    Then User draws the shape from start position "0,0" to end position "100,100"
    And Take the ScreenShot of the Canvas "screenShot1"
    And Get the areas "canvasArea1" of figures in the canvas from "screenShot1"
    Then Change the Title of Document to "newDesignTitle12"
    When Go to the home page of figma
    Then Verify that Home page is displayed
    And Check if file "newDesignTitle12" is present in the draft
    Then User opens the file "newDesignTitle12" from the draft
    And Take the ScreenShot of the Canvas "screenShot2"
    And Get the areas "canvasArea2" of figures in the canvas from "screenShot2"
    Then Compare the areas of "canvasArea1" and "canvasArea2"
    And Move the figure "1" in the "screenShot2" by "100,100"

 @AllTest
  Scenario: Create edit and delete new FigJam file under project
    Given SetUp the browser
    Then Login into the application
    Then Verify that Home page is displayed
    Then User Click on teams and Select the team
    And  Validate the team and go to the project tab
    Then User Click on new FigJam file
    Then Verify that Design page is displayed
    When User Rename the file and save the file
    Then Validate the file name
    And Edit the file
    Then Delete the file
    And Validate the file is Deleted Successfully

  @AllTest
  Scenario: To Validate Whether User can Share the File
    Given SetUp the browser
    Then Login into the application
    Then Verify that Home page is displayed
    When Click on the new design option
    Then Verify that Design page is displayed
    When User Rename the file and save the file
    Then Validate the file name
    When User selects the star tool
    Then User draws the shape from start position "0,0" to end position "100,100"
    Then User click on Share Button
    And Select the access from DropDown
    Then User Enter the E-Mail need to share
    Then Send the Invite
    And Validate the Invite is Sent
    
  @AllTest
  Scenario:Create and Edit a New FigJam File under drafts and move to project
    Given SetUp the browser
    Then Login into the application
    And Verify that Home page is displayed
    When Go to Drafts
    Then click on New FigJam file
    Then Verify that Design page is displayed
    Then Change the Title of Document to "NewFigJamTitle01"
    When Click on the dropdown and select move to project
    Then Select the team and move

  @AllTest
  Scenario: Drawing Shapes and adding text on Workspace in Existing FigJam File
    Given SetUp the browser
    Then Login into the application
    And Verify that Home page is displayed
    Then click on New FigJam file
    Then Verify that Design page is displayed
    Then Change the Title of Document to "Case 41"
    When Go to the home page of figma
    When Go to Drafts
    Then Choose Existing FigJam file "Case 41" from Drafts
    When Click on shapes from the tool bar
    And Click on workspace and draw the shape
    When Add all properties to drawn shape from property menu
    Then Add text "Hi All" into the shapes

    @AllTest
    Scenario: Validating User can Add comments in New FigJam File
      Given SetUp the browser
      Then Login into the application
      And Verify that Home page is displayed
      Then click on New FigJam file
      Then Verify that Design page is displayed
      Then Click add comment icon
      Then Drag on Canvas to add Comment
      Then Add Text "Hi New Comment" in Comment bubble
      And click Submit
      Then Verify the comment "Hi New Comment"


