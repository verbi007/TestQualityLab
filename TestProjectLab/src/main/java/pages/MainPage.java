package pages;

import coreUI.BaseSeleniumPage;
import dataProvider.ConfigProvider;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage extends BaseSeleniumPage {

    @FindBy(xpath = "//button[text()='Войти']")
    private WebElement logInBtn;

    public MainPage() {
        driver.get(ConfigProvider.URL);
        PageFactory.initElements(driver, this);
    }

    public AuthorizationPage logInBtnClick() {
        logInBtn.click();
        return new AuthorizationPage();
    }


}
