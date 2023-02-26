package DemoQATest.DemoQATests;

import DemoQATest.DemoQABase.Base;
import DemoQATest.DemoQAPages.HomePage;
import DemoQATest.DemoQAPages.SidebarPage;
import DemoQATest.DemoQAPages.TextBoxPage;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class Elements_1TextboxTest extends Base {

    public void goToTextBox () {
        scrollIntoView(homePage.getCards().get(homePage.getCards().size()-1));
        homePage.clickOnElements();
        sidebarPage.clickOnButton("Text Box");
    }

    @BeforeMethod
    public void PageSetUp () {
        driver= new ChromeDriver();
        wdwait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get(homeURL);
        homePage = new HomePage();
        textBoxPage= new TextBoxPage();
        sidebarPage = new SidebarPage();
    }

    @Test
    public void textBoxSidebar_IsClickable () {
        goToTextBox();
        Assert.assertEquals(driver.getCurrentUrl(), "https://demoqa.com/text-box");
        Assert.assertEquals(textBoxPage.elementsHeader.getText(), "Text Box");
        Assert.assertTrue(textBoxPage.subminButton.isDisplayed());
    }

    @Test
    public void textBoxSidebar_UserCanBeAdded_EenterFullData () {
        goToTextBox();
        textBoxPage.insertFullName(excelReader.getStringData("TextBoxData", 1, 1));
        textBoxPage.insertEmail(excelReader.getStringData("TextBoxData", 2, 1));
        textBoxPage.insertCurrentAddress(excelReader.getStringData("TextBoxData", 3, 1));
        textBoxPage.insertPeremanentAddress(excelReader.getStringData("TextBoxData", 4, 1));
        scrollIntoView(textBoxPage.subminButton);
        textBoxPage.subminButton.click();
        for (int i =1; i<textBoxPage.getTextBoxMessage().size(); i++) {
            Assert.assertEquals(textBoxPage.getTextBoxMessage().get(i-1).getText(),
                    excelReader.getStringData("TextBoxData", i,2));
        }
    }
    @Test
    public void textBoxSidebar_UserCanBeAdded_enterOnlyName () {
        goToTextBox();
        textBoxPage.insertFullName(excelReader.getStringData("TextBoxData", 1, 1));
        scrollIntoView(textBoxPage.subminButton);
        textBoxPage.subminButton.click();
        Assert.assertEquals(textBoxPage.getTextBoxMessage().get(0).getText(),
                    excelReader.getStringData("TextBoxData", 1,2));
    }

    @Test
    public void textBoxSidebar_UserCanBeAdded_enterNumberInNameFiled () {
        goToTextBox();
        textBoxPage.insertNumberFullName(excelReader.getIntegerData("TextBoxData", 1, 3));
        scrollIntoView(textBoxPage.subminButton);
        textBoxPage.subminButton.click();
        Assert.assertEquals(textBoxPage.getTextBoxMessage().get(0).getText(),"Name:1");
    }

    @Test
    public void textBoxSidebar_UserCantBeAdded_enterInvalidEmailData () {
        String invalidEmail= "sonja";
        goToTextBox();
        textBoxPage.insertFullName(excelReader.getStringData("TextBoxData", 1, 1));
        textBoxPage.insertEmail(invalidEmail);
        scrollIntoView(textBoxPage.subminButton);
        textBoxPage.subminButton.click();
        textBoxPage.assertThatDataIsNotAdded();
    }

    @Test
    public void textBoxSidebar_UserCantBeAdded_enterBlankField () {
        goToTextBox();
        scrollIntoView(textBoxPage.subminButton);
        textBoxPage.subminButton.click();
        textBoxPage.assertThatDataIsNotAdded();
    }

    @AfterMethod
    public void close () {
        driver.manage().deleteAllCookies();
        driver.close();
    }
}
