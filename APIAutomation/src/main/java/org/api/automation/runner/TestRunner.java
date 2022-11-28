package org.api.automation.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/org/api/automation/features",
        glue = "org/api/automation/step_defs",
        tags=""
)
public class TestRunner {

}

