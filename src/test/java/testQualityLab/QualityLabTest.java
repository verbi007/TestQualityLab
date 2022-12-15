package testQualityLab;

import coreUI.BaseSeleniumTest;
import dataProvider.ConfigProvider;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.MainPage;


public class QualityLabTest extends BaseSeleniumTest {



    @Test(testName = "Авторизация и отправка письма")
    public void authorizationAndSendMassage() {

        new MainPage()
                .logInBtnClick()
                .authorization(ConfigProvider.LOGIN, ConfigProvider.PASSWORD)
                .sendMessage(ConfigProvider.URL_SEND_TO, "Test", "Я это сделал, Крошка!!!!!");
        Assert.assertTrue(driver.findElement(By.xpath("//a[@class='layer__link' and text()='Письмо отправлено']")).isDisplayed());
    }


}
