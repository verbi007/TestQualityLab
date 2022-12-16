package testQualityLab;

import coreUI.BaseSeleniumTest;
import dataProvider.ConfigProvider;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.MainPage;
import pages.WorkPage;


public class QualityLabTest extends BaseSeleniumTest {
    private String ACTUAL_TITLE = "Письмо отправлено";

    @Test(testName = "Авторизация и отправка письма")
    public void authorizationAndSendMassage() {

        WorkPage workPage = new MainPage()
                .logInBtnClick()
                .authorization(ConfigProvider.LOGIN, ConfigProvider.PASSWORD)
                .sendMessage(ConfigProvider.URL_SEND_TO, ConfigProvider.TITLE_MESSAGE, ConfigProvider.TEXT_MESSAGE);

        Assert.assertEquals(ACTUAL_TITLE, workPage.getExpectedTitle());
    }


}
