package steps;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class AuthorizationSteps {
    private SelenideElement logInBtn = $(By.xpath("//button[text()='Войти']"));
    private SelenideElement loginContent = $("#login-content");
    private SelenideElement frameAuth = $(By.xpath("//iframe[@class='ag-popup__frame__layout__iframe']"));
    private SelenideElement usernameField = $(By.xpath("//input[@name='username']"));
    private SelenideElement nextBtn = $(By.xpath("//button[@data-test-id='next-button']"));
    private SelenideElement passwordField = $(By.xpath("//*[@type='password']"));
    private SelenideElement enterBtn = $(By.xpath("//*[@data-test-id='submit-button']"));
    private SelenideElement username = $(By.xpath("//div[contains(@class, 'ph-project__account')]"));
    private SelenideElement closePopup = $(By.xpath("//div[@class='ph-project-promo-close-icon svelte-m7oyyo']"));


    @When("^Нажимаем на кнопку вход$")
    public void clickLogInBtn() {
        logInBtn.shouldHave(Condition.exist).click();
    }

    @And("Появляется окно авторизации")
    public void switchToFrameAuthorization() {
        Selenide.switchTo().frame(frameAuth);
    }

    @And("Вводим имя пользователя {string}")
    public void enterLogin(String login) {
        usernameField.shouldBe(Condition.enabled).sendKeys(login);
    }

    @And("Нажимаем кнопку Ввести пароль")
    public void clickNextBtn() {
        nextBtn.shouldBe(Condition.enabled).click();
    }

    @And("Вводим пароль {string}")
    public void enterPassword(String password) {
        passwordField.shouldBe(Condition.exist).sendKeys(password);
    }

    @And("Нажимаем кнопку Войти")
    public void clickEnterBtn() {
        enterBtn.shouldBe(Condition.exist).click();
        closePopup.shouldBe(Condition.visible).click();
    }

    @Then("В поле профиля видим введенное имя пользователя {string}")
    public void checkUserName(String login) {
        username.shouldHave(Condition.attribute("aria-label", login));
    }

    @Given("Авторизация: логин {string}, пароль {string}")
    public void auth(String login, String password) {
        logInBtn.shouldHave(Condition.exist).click();
        Selenide.switchTo().frame(frameAuth);
        usernameField.shouldBe(Condition.enabled).sendKeys(login);
        nextBtn.shouldBe(Condition.enabled).click();
        passwordField.shouldBe(Condition.exist).sendKeys(password);
        enterBtn.shouldBe(Condition.exist).click();
        closePopup.shouldBe(Condition.visible).click();
        username.shouldHave(Condition.attribute("aria-label", login));
    }
}
