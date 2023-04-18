package com.framework.userinterface.web.factory;


import com.framework.userinterface.web.interfaces.DesignPage;
import com.framework.userinterface.web.interfaces.HomePage;
import com.framework.userinterface.web.interfaces.LoginPage;
import com.framework.userinterface.web.pom.ProjectPage;
import com.framework.userinterface.web.pom.TeamProjectPage;
import org.openqa.selenium.WebDriver;

public class PageFactory {
    public static LoginPage getLogInPage(
            String testName, WebDriver driver) {
        return new com.framework.userinterface.web.pom.LoginPage(testName, driver);
    }

    public static DesignPage getDesignPage(
            String testName, WebDriver driver) {
        return new com.framework.userinterface.web.pom.DesignPage(testName, driver);
    }

    public static HomePage getHomePage(
            String testName, WebDriver driver) {
        return new com.framework.userinterface.web.pom.HomePage(testName, driver);
    }
    public static ProjectPage getProjectPage(
            String testName, WebDriver driver) {
        return new com.framework.userinterface.web.pom.ProjectPage(testName, driver);
    }
    public static TeamProjectPage getTeamProjectPage(
            String testName, WebDriver driver) {
        return new com.framework.userinterface.web.pom.TeamProjectPage(testName, driver);
    }
}
