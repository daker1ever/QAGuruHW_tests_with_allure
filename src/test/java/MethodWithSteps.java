import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selectors;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class MethodWithSteps {
    @Step("Открываем страницу проекта")
    public void openTargetPage() {
        open("https://github.com/qa-guru/qa_guru_14_10");
    }

    @Step("Переходим на таб \"Issue\"")
    public void switchToIssueTab() {
        $("#issues-tab").click();
    }

    @Step("Проверяем наличие проблемы с названием \"Issue for Autotest\"")
    public void checkIssueName() {
        $(Selectors.withText("Issue for Autotest")).shouldBe(Condition.exist);
    }

}
