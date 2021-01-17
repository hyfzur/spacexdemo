import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.Test;

@Test
@CucumberOptions(
        features = "src/test/resources",
        plugin = {
                "summary"
        }
)
public class CucumberTest extends AbstractTestNGCucumberTests {


}