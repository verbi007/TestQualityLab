package pages;

import coreUI.BaseSeleniumPage;
import dataProvider.ConfigProvider;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AuthorizationPage extends BaseSeleniumPage {

    @FindBy(xpath = "//iframe[contains(@src, 'https://account.mail.ru/login/')]")
    private WebElement iframeLogIn;

    @FindBy(xpath = "//input[@name='username']")
    private WebElement usernameField;

    @FindBy(xpath = "//button[@data-test-id='next-button']")
    private WebElement nextButton;

    @FindBy(xpath = "//*[@type='password']")
    private WebElement passwordField;

    @FindBy(xpath = "//*[@data-test-id='submit-button']")
    private WebElement enterBtn;

    public AuthorizationPage() {
        PageFactory.initElements(driver, this);
    }

    public WorkPage authorization(String login, String password) {
        driver.switchTo().frame(iframeLogIn);
        usernameField.sendKeys(ConfigProvider.LOGIN);
        nextButton.click();
        passwordField.sendKeys(ConfigProvider.PASSWORD);
        enterBtn.click();
        return new WorkPage();
    }
}
