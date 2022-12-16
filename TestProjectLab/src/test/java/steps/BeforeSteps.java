package steps;

import com.codeborne.selenide.Selenide;
import io.cucumber.java.en.Given;

public class BeforeSteps {
    @Given("Открываем сайт {string}")
    public void openWebSite(String url) {
        Selenide.open(url);
    }
}
