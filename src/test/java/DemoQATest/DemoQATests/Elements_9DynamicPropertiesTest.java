package DemoQATest.DemoQATests;

import DemoQATest.DemoQABase.Base;
import DemoQATest.DemoQAPages.DynamicsPropertiesPage;
import DemoQATest.DemoQAPages.HomePage;
import DemoQATest.DemoQAPages.SidebarPage;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class Elements_9DynamicPropertiesTest extends Base {

    public void goToDynamicProperties () {
        scrollIntoView(homePage.getCards().get(homePage.getCards().size()-1));
        homePage.clickOnElements();
        scrollIntoView(sidebarPage.getButtons().get(8));
        sidebarPage.clickOnButton("Dynamic Properties");
    }

    @BeforeMethod
    public void PageSetUp () {
        driver= new ChromeDriver();
        wdwait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get(homeURL);
        homePage = new HomePage();
        dynamicsPage = new DynamicsPropertiesPage();
        sidebarPage = new SidebarPage();
    }

    @Test
    public void dynamicPropertiesSidebar_IsClickable ()  {
        goToDynamicProperties();
        Assert.assertEquals(driver.getCurrentUrl(), "https://demoqa.com/dynamic-properties");
        Assert.assertEquals(dynamicsPage.elementsHeader.getText(), "Dynamic Properties");
    }

    @Test
    public void dynamicPropertiesSidebar_buttonsArePresent ()  {
        goToDynamicProperties();
        Assert.assertTrue(dynamicsPage.colorchangeButton.isDisplayed());
        Assert.assertTrue(dynamicsPage.willEnableButton.isDisplayed());
        wdwait.until(ExpectedConditions.visibilityOf(dynamicsPage.visibleAfterButton));
        Assert.assertTrue(dynamicsPage.visibleAfterButton.isDisplayed());

    }
    @AfterMethod
    public void close () {
        driver.manage().deleteAllCookies();
        driver.close();
    }
}
