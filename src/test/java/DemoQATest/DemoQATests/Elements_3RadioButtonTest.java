package DemoQATest.DemoQATests;

import DemoQATest.DemoQABase.Base;
import DemoQATest.DemoQAPages.HomePage;
import DemoQATest.DemoQAPages.RadioButtonPage;
import DemoQATest.DemoQAPages.SidebarPage;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class Elements_3RadioButtonTest extends Base {

    public void goToRadioButton () {
        scrollIntoView(homePage.getCards().get(homePage.getCards().size()-1));
        homePage.clickOnElements();
        sidebarPage.clickOnButton("Radio Button");
    }

    @BeforeMethod
    public void PageSetUp () {
        driver= new ChromeDriver();
        wdwait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get(homeURL);
        homePage = new HomePage();
        radioButtonPage = new RadioButtonPage();
        sidebarPage = new SidebarPage();
    }

    @Test
    public void radioButtonSidebar_IsClickable()  {
        goToRadioButton();
        Assert.assertEquals(driver.getCurrentUrl(), "https://demoqa.com/radio-button");
        Assert.assertEquals(radioButtonPage.elementsHeader.getText(), "Radio Button");
    }

    @Test
    public void radioButton_YesButtonIsClickable () {
        goToRadioButton();
        radioButtonPage.clickYesRadioButton();
        Assert.assertEquals(radioButtonPage.message.getText(), "Yes");
    }

    @Test
    public void radioButton_ImpressiveButtonIsClickable () {
        goToRadioButton();
        radioButtonPage.clickImpressiveRadioButton();
        Assert.assertEquals(radioButtonPage.message.getText(), "Impressive");
    }

    @Test
    public void radioButton_NoButtonIsClickable () {
        goToRadioButton();
        radioButtonPage.clickNoRadioButton();
        Assert.assertEquals(radioButtonPage.message.getText(), "No");
    }

    @AfterMethod
    public void close () {
        driver.manage().deleteAllCookies();
        driver.close();
    }
}
