package com.cats.boot;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)

@CucumberOptions(features = "src/test/resources/", plugin = {"pretty", "rerun:rerun.txt", "html:target/local-html-report/"},
        glue = "com.cats.boot.test")
public class CucumberTest {
}
