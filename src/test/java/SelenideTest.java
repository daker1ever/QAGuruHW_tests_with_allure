import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selectors;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

public class SelenideTest extends TestBase {

    @Test
    void checkIssueTestWithListener() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        open("https://github.com/qa-guru/qa_guru_14_10");
        $("#issues-tab").click();
        $(Selectors.withText("Issue for Autotest")).shouldBe(Condition.exist);
    }

    @Test
    void checkIssueTestWithLambda() {
        SelenideLogger.addListener("allure", new AllureSelenide());

        step("Открываем страницу проекта", () -> open("https://github.com/qa-guru/qa_guru_14_10"));
        step("Переходим на таб \"Issue\"", () -> $("#issues-tab").click());
        step("Проверяем наличие проблемы с названием \"Issue for Autotest\"", () -> {
            $(Selectors.withText("Issue for Autotest")).shouldBe(Condition.exist);
        });
    }

    @Test
    public void checkIssueTestWithStep() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        MethodWithSteps mws = new MethodWithSteps();
        mws.openTargetPage();
        mws.switchToIssueTab();
        mws.checkIssueName();
    }
}
