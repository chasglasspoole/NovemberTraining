package cucumberJava;

import org.testng.annotations.Test;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions( features = {"src/test/java/cucumberJava/cucumberJava.feature"}, glue = {"cucumberJava",})
public class RunCucumberTests extends AbstractTestNGCucumberTests {
  @Test
  public void runTests() {
  }
}
