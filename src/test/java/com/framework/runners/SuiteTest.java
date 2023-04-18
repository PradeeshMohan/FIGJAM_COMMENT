package com.framework.runners;


import com.framework.lib.test.Base;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        plugin = {
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
                "pretty",
                "summary",
                "html:target/cucumber",
                "json:target/cucumber.json"
        },
        features = {"src/test/resources/features/figma.feature"},
        glue = {"com.framework.stepDefinitionFiles"},
        monochrome = true,
        tags = "@AllTest",
        snippets = CucumberOptions.SnippetType.CAMELCASE
)
//@Listeners({com.framework.listners.EventListenerTestNG.class})
public class SuiteTest extends Base {
}
