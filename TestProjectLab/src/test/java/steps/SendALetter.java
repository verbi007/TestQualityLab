package steps;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.mn.Харин;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Selenide.$;

public class SendALetter {
    private SelenideElement closePopup = $(By.xpath("//div[@class='ph-project-promo-close-icon svelte-m7oyyo']"));
    private SelenideElement writeALetterBtn = $(By.xpath("//a[@href='/compose/']"));
    private SelenideElement windowSendLet = $(By.xpath("//div[@class='compose-windows compose-windows_rise']"));
    private SelenideElement sendTo = $(By.xpath("//*[@data-name='to']//input"));
    private SelenideElement titleMessage = $(By.xpath("//*[@name='Subject']"));
    private SelenideElement inputMessage = $(By.xpath("//*[@contenteditable='true']/div"));
    private SelenideElement sendBtn = $(By.xpath("//button[@data-test-id='send']"));
    private SelenideElement actualTitle = $(By.xpath("//a[@class='layer__link']"));


    @When("^Нажать на кнопку 'Написать письмо'$")
    public void clickWriteALetter() {
        closePopup.click();
        writeALetterBtn.click();
    }

    @And("Появляется окно отправки письма")
    public void windowSendALetter() {
        windowSendLet.shouldBe(Condition.enabled);
    }

    @And("Ввести данные {string} в поле {string}")
    public void enterValueInField(String value, String field) {
        switch (field) {
            case "Кому":
                sendTo.sendKeys(value);
                break;
            case "Тема":
                titleMessage.sendKeys(value);
                break;
            case "Сообщение":
                inputMessage.sendKeys(value);
                break;
        }
    }

    @And("Нажать кнопку {string}")
    public void clickSendBtn() {
        sendBtn.click();
    }

    @Then("Появляется сообщение {string}")
    public void checkAlert(String expectedTitle) {
        actualTitle.shouldHave(Condition.text(expectedTitle));
    }
}
