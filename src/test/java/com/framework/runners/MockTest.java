package com.framework.runners;

import com.framework.lib.test.Base;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(
        plugin = {
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
                "pretty",
                "summary",
                "html:test-output/cucumber/cucumber.html",
                "json:test-output/cucumber/cucumber.json",
                "junit:test-output/cucumber/cucumber_junit.xml",
                "testng:test-output/cucumber/cucumber_testng.xml"
        },
        features = {"src/test/resources/features/Mock.feature"},
        glue = {"com.framework.stepDefinitionFiles"},
        monochrome = true,
        tags = "@MOCK",
        snippets = CucumberOptions.SnippetType.CAMELCASE
)

public class MockTest extends Base {
}