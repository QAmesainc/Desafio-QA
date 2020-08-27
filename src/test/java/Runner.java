import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.CucumberOptions.SnippetType;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/features",
        plugin = {"pretty", "html:target/CucumberReport"},
        glue = "",
        tags = {"@TesteWiktionary"},
        snippets = SnippetType.CAMELCASE,
        monochrome = true)
public class Runner {

}