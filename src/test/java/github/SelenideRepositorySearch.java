package github;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class SelenideRepositorySearch {

    @BeforeAll
    static void beforeAll() {
        Configuration.pageLoadStrategy = "eager";
        Configuration.baseUrl = "https://github.com";
        Configuration.browserSize = "1920x1080";
        //Configuration.holdBrowserOpen = true;
    }

    @Test
    void shouldFindSelenideRepositoryAtTheTop () {
        open("/selenide/selenide");
        $("#wiki-tab").click();
        $("#wiki-pages-filter").setValue("SoftAssertions").pressEnter();
        $("#wiki-pages-box").shouldHave(text("SoftAssertions"));
        $("#wiki-pages-box").$(byText("SoftAssertions")).click();
        $(".markdown-body").shouldHave(text("Using JUnit5 extend test class"));
        $(".markdown-body").shouldHave(text("@ExtendWith({SoftAssertsExtension.class})\n" +
                "class Tests {\n" +
                "  @Test\n" +
                "  void test() {\n" +
                "    Configuration.assertionMode = SOFT;\n" +
                "    open(\"page.html\");\n" +
                "\n" +
                "    $(\"#first\").should(visible).click();\n" +
                "    $(\"#second\").should(visible).click();\n" +
                "  }\n" +
                "}"));
        $(".markdown-body").shouldHave(text("class Tests {\n" +
                "  @RegisterExtension \n" +
                "  static SoftAssertsExtension softAsserts = new SoftAssertsExtension();\n" +
                "\n" +
                "  @Test\n" +
                "  void test() {\n" +
                "    Configuration.assertionMode = SOFT;\n" +
                "    open(\"page.html\");\n" +
                "\n" +
                "    $(\"#first\").should(visible).click();\n" +
                "    $(\"#second\").should(visible).click();\n" +
                "  }\n" +
                "}"));
        sleep(6000);

    }
}
