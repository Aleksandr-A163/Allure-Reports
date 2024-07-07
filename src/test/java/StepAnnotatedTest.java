import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;

public class StepAnnotatedTest extends TestBase {
    private static final String REPOSITORY = "eroshenkoam/allure-example";
    private static final int NUMBER = 87;
    private static final String TITLE = "Issue for HW qa.guru";

    @Test
    public void testIssueSearchWithAnnotatedStep() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        WebSteps steps = new WebSteps();
        steps.openMainPage();
        steps.searchForRepository(REPOSITORY);
        steps.clickOnRepositoryLink(REPOSITORY);
        steps.openIssuesTab();
        steps.shouldSeeIssueWithNumberAndTitle(NUMBER, TITLE);
    }
}