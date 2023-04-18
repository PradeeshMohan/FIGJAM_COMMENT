package com.framework.userinterface.web.interfaces;

import java.io.IOException;

public interface DesignPage {

    boolean isDisplayed();

    void selectRectangleTool();

    void clickOnShapeToolDropdown();

    void selectStarTool();

    void drawShapeOnCanvas(int X, int Y, int X1, int Y1);

    String getCanvasScreenShot() throws IOException;

    void clickOnCanvasEmptyArea() throws InterruptedException;

    void changeTitle(String title);

    void goToHomepage();

    void moveTheElementInsideElement(int X, int Y, int X1, int Y1);

    void renameAndSaveTheFile(String newName);

    void validateFileName(String newName);

    void editTheFile();

    void deleteTheFile();

    void validateTheFileIsDeleted(String deletepopupText);

    void clickOnShareButton();

    void selectAccessFromDD();

    void enterEmailToShare(String email);

    void sendInvite();

    void validateInvite();

    void clickOnTitleDropDown();

    void selectMoveToProject();

    void selectTeamAndMove(String teamName);

    void clickShapesToolInFigJamFile();

    void clickOnCanvas();

    void addAllProperties();

    void addTextIntoShape(String text);

    void clickCommentIconFigJam();
    void dragOnCanvasToAddComment();
    void addTextInCommentBubble();
    void clickSubmit();
    void verifyTheComment(String verifyComment);
}