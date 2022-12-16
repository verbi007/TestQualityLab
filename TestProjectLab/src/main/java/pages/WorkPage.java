package pages;

import coreUI.BaseSeleniumPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class WorkPage extends BaseSeleniumPage {


    @FindBy(xpath = "//a[@href='/compose/']")
    private WebElement newMessageBtn;

    @FindBy(xpath = "//*[@data-name='to']//input")
    private WebElement sendTo;

    @FindBy(xpath = "//*[@name='Subject']")
    private WebElement titleMessage;

    @FindBy(xpath = "//*[@contenteditable='true']/div")
    private WebElement inputMessage;

    @FindBy(xpath = "//button[@data-test-id='send']")
    private WebElement sendBtn;

    @FindBy(xpath = "//a[@class='layer__link']")
    private WebElement expectedTitle;

    public WorkPage() {
        PageFactory.initElements(driver, this);
    }

    public WorkPage sendMessage(String toMessage, String title, String textMessage) {
        wait.until(ExpectedConditions.titleContains("Почта Mail.ru"));
        newMessageBtn.click();
        sendTo.sendKeys(toMessage);
        titleMessage.sendKeys(title);
        inputMessage.sendKeys(textMessage);
        sendBtn.click();
        return this;
    }

    public String getExpectedTitle() {
        return expectedTitle.getText();
    }


}
